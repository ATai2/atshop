package com.atshop.modules.git;

import cn.hutool.core.util.ZipUtil;
import com.atshop.annotation.AnonymousAccess;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.ListBranchCommand;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.diff.DiffEntry;
import org.eclipse.jgit.diff.DiffFormatter;
import org.eclipse.jgit.lib.*;
import org.eclipse.jgit.revwalk.RevCommit;
import org.eclipse.jgit.revwalk.RevTree;
import org.eclipse.jgit.revwalk.RevWalk;
import org.eclipse.jgit.treewalk.AbstractTreeIterator;
import org.eclipse.jgit.treewalk.CanonicalTreeParser;
import org.eclipse.jgit.treewalk.FileTreeIterator;
import org.springframework.boot.system.ApplicationHome;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Slf4j
@RestController
public class GitController {


    static String root = "D:\\code\\dmp2103\\dmp-datafactory\\target\\classes/";
//    static String root = "/var/lib/jenkins/workspace/dmp2103/dmp-datafactory/target/classes/";

    @AnonymousAccess
    @GetMapping("/branchlist")
    public Object branchList(String gitRepoPath) {
        try (Git git = Git.open(new File(gitRepoPath));
        ) {
            ListBranchCommand listBranchCommand = git.branchList();
            List<Ref> refList = listBranchCommand.call();
            List<String> collect = refList.stream().map(Ref::getName).collect(Collectors.toList());
            return collect;

        } catch (IOException | GitAPIException e) {
            e.printStackTrace();
        }
        return null;
    }

    @AnonymousAccess
    @GetMapping("/loglist")
    public Object loglist(String gitRepoPath, Integer size) {
        try (Git git = Git.open(new File(gitRepoPath));
        ) {
            List<RevCommit> refList = new ArrayList<>();
            if (size == null || size == 0) {
                size = 10;
            }
            Iterable<RevCommit> log = git.log().setMaxCount(size).call();
            for (Iterator<RevCommit> iterator = log.iterator(); iterator.hasNext(); ) {
                RevCommit rev = iterator.next();
                System.out.println(rev.getFullMessage());
            }
            List<String> collect = refList.stream().map(AnyObjectId::getName).collect(Collectors.toList());
            return collect;

        } catch (IOException | GitAPIException e) {
            e.printStackTrace();
        }
        return null;
    }

    @AnonymousAccess
    @GetMapping("/difffilelist")
    public List difffilelist(String gitRepoPath, String revision, Integer size) {
        try (Git git = Git.open(new File(gitRepoPath));
        ) {
            List<RevCommit> refList = new ArrayList<>();
            if (size == null || size == 0) {
                size = 10;
            }
            List<String> collect;
            if (StringUtils.isEmpty(revision)) {
                Iterable<RevCommit> log = git.log().setMaxCount(size).call();
                for (Iterator<RevCommit> iterator = log.iterator(); iterator.hasNext(); ) {
                    RevCommit rev = iterator.next();
                    refList.add(rev);
                    System.out.println(rev.getFullMessage());
                }
                collect = refList.stream().map(AnyObjectId::getName).collect(Collectors.toList());
            } else {
                Iterable<RevCommit> log = git.log().call();
                for (Iterator<RevCommit> iterator = log.iterator(); iterator.hasNext(); ) {
                    RevCommit rev = iterator.next();
                    if (rev.getId().getName().contains(revision)) {
                        refList.add(rev);
                        refList.add(iterator.next());
                        break;
                    }
                    System.out.println(rev.getFullMessage());

                }
                collect = refList.stream().map(AnyObjectId::getName).collect(Collectors.toList());
            }


            if (collect.size() > 1) {
                AbstractTreeIterator newTree = prepareTreeParser(git.getRepository(), refList.get(0));
                AbstractTreeIterator oldTree = prepareTreeParser(git.getRepository(), refList.get(1));
                List<DiffEntry> entries = git.diff().setOldTree(oldTree).setNewTree(newTree).setShowNameAndStatusOnly(true).call();
                entries.forEach(diffEntry -> System.out.println(diffEntry.getNewPath()));
                return entries.stream().map(DiffEntry::getNewPath).filter(new Predicate<String>() {
                    @Override
                    public boolean test(String s) {
                        return !s.contains("dmp-datafactory/src/test/");
                    }
                }).collect(Collectors.toList());
            }
            return collect;

        } catch (IOException | GitAPIException e) {
            e.printStackTrace();
        }
        return null;
    }

    @AnonymousAccess
    @GetMapping("/getLatestFile")
    public Object getLatestFile(RepoInfo repoInfo, HttpServletResponse response) {
        List difffilelist = difffilelist(repoInfo.getPath(), repoInfo.getRevision(), 10);
        return getFile(difffilelist, response);
    }

    @AnonymousAccess
    @GetMapping("/getFile")
    public Object getFile(List<String> fileList, HttpServletResponse response) {
        log.info("root:" + root);

        String path = generatePathFile(fileList);
        File patchFile = new File(path);
        String zipPath = patchFile.getParent() + File.separator + "BOOTINFO.zip";
        ZipUtil.zip(path, zipPath);
        byte[] buffer = new byte[1024];
        FileInputStream fis = null;
        BufferedInputStream bis = null;
        try {
            File file = new File(zipPath);
            response.setContentType("application/x-download");
            response.addHeader("Content-Disposition", "attachment;filename=" + file.getName());
            fis = new FileInputStream(file);
            bis = new BufferedInputStream(fis);
            OutputStream os = response.getOutputStream();
            int i = bis.read(buffer);
            while (i != -1) {
                os.write(buffer, 0, i);
                i = bis.read(buffer);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("The file not found!");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;

    }

    private String generatePathFile(List<String> fileList) {

        String targetPath = new ApplicationHome(GitController.class).getSource().getParent() + File.separator + "patch";
        File targetPathFile = new File(targetPath);
        if (targetPathFile.exists()) {
            try {
                FileUtils.forceDelete(targetPathFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        List<String> filePathList = new ArrayList<>();
        List<String> fileRelativeList = new ArrayList<>();
        fileList.forEach(s -> {
            if (s.startsWith("dmp-datafactory/src/main/java/")) {
                filePathList.add(s.replace("dmp-datafactory/src/main/java/", root).replace(".java", ".class"));
                fileRelativeList.add(StringUtils.substringBeforeLast(s.replace("dmp-datafactory/src/main/java/", ""), "/"));
            } else if (s.startsWith("dmp-datafactory/src/main/resources/")) {
                filePathList.add(s.replace("dmp-datafactory/src/main/resources/", root));
                fileRelativeList.add(StringUtils.substringBeforeLast(s.replace("dmp-datafactory/src/main/resources/", ""), "/"));
            }
        });
        for (int i = 0; i < filePathList.size(); i++) {
            String s = filePathList.get(i);
            File file = new File(s);
            if (file.exists()) {
                try {
                    String pathname = targetPath + File.separator + fileRelativeList.get(i) + File.separator + file.getName();
                    FileUtils.copyFile(file, new File(pathname));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return targetPath;

    }

    @AnonymousAccess
    @PostMapping("/difflist")
    public Object diffList(@RequestBody RepoInfo repoInfo) {
        try (Git git = Git.open(new File(repoInfo.getPath()));
        ) {
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            DiffFormatter formatter = new DiffFormatter(out);
            formatter.setRepository(git.getRepository());
            AbstractTreeIterator commitTreeIterator = prepareTreeParser(git.getRepository(), repoInfo.getBranch());
            FileTreeIterator workTreeIterator = new FileTreeIterator(git.getRepository());
            List<DiffEntry> diffEntries = formatter.scan(commitTreeIterator, workTreeIterator);

            for (DiffEntry entry : diffEntries) {
                System.out.println("DIFF Entry: " + entry + ", from: " + entry.getOldId() + ", to: " + entry.getNewId());
                formatter.format(entry);
                String diffText = out.toString("UTF-8");
                System.out.println(diffText);
                out.reset();
            }

            List<String> collect = diffEntries.stream().map(new Function<DiffEntry, String>() {
                @Override
                public String apply(DiffEntry diffEntry) {
                    return diffEntry.getNewPath();
                }
            }).collect(Collectors.toList());
            return collect;

        } catch (IOException | GitAPIException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public AbstractTreeIterator prepareTreeParser(Repository repository, RevCommit commit) {
        System.out.println(commit.getId());
        try (RevWalk walk = new RevWalk(repository)) {
            System.out.println(commit.getTree().getId());
            RevTree tree = walk.parseTree(commit.getTree().getId());

            CanonicalTreeParser oldTreeParser = new CanonicalTreeParser();
            try (ObjectReader oldReader = repository.newObjectReader()) {
                oldTreeParser.reset(oldReader, tree.getId());
            }

            walk.dispose();

            return oldTreeParser;
        } catch (Exception e) {
            // TODO: handle exception
        }
        return null;
    }

    private static AbstractTreeIterator prepareTreeParser(Repository repository, String ref) throws Exception {
        Ref head = repository.getRef(ref);
        RevWalk walk = new RevWalk(repository);
        RevCommit commit = walk.parseCommit(head.getObjectId());
        RevTree tree = walk.parseTree(commit.getTree().getId());
//        repository.getAllRefsByPeeledObjectId();
        CanonicalTreeParser oldTreeParser = new CanonicalTreeParser();
        ObjectReader oldReader = repository.newObjectReader();
        try {
            oldTreeParser.reset(oldReader, tree.getId());
        } finally {
            oldReader.close();
        }
        return oldTreeParser;
    }

}
