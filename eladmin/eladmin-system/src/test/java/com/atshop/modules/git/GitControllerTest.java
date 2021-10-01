package com.atshop.modules.git;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GitControllerTest {


    @Test
    void branchList() {
        GitController target = new GitController();
        Object o = target.branchList("D:\\code\\dmp2103");
        List<String> o1 = (List<String>) o;
        for (String s : o1) {
            System.out.println(s);
        }

    }

    @Test
    void log() {
        GitController target = new GitController();
        Object o = target.loglist("D:\\code\\dmp2103", 0);
        List<String> o1 = (List<String>) o;
        for (String s : o1) {
            System.out.println(s);
        }

    }

    @Test
    void difffilelist() {
        GitController target = new GitController();
        Object o = target.difffilelist("D:\\code\\dmp2103", null,0);
        List<String> o1 = (List<String>) o;
        for (String s : o1) {
            System.out.println(s);
        }

    }

    @Test
    void diffList() {
        GitController target = new GitController();
        RepoInfo repoInfo = new RepoInfo();
        repoInfo.setBranch("refs/heads/feature/2110facade");
        repoInfo.setPath("D:\\code\\dmp2103");
        target.diffList(repoInfo);
    }

    @Test
    void getLatestFile() {
        GitController target = new GitController();
        RepoInfo repoInfo = new RepoInfo();
        repoInfo.setBranch("refs/heads/feature/2110facade");
        repoInfo.setPath("D:\\code\\dmp2103");
        target.getLatestFile(repoInfo, null);
    }
}