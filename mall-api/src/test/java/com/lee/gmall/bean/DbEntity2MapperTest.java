package com.lee.gmall.bean;

import ch.qos.logback.core.util.FileUtil;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.FileSystemUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class DbEntity2MapperTest {

    @Test
    public void test() throws IOException {
        String source="D:\\code\\java\\atshop\\mall-api\\src\\main\\java\\com\\lee\\gmall\\bean";
        String dest="D:\\code\\java\\atshop\\mall-manage-service\\src\\main\\java\\com\\lee\\gmall\\manage\\mapper";

        File file=new File(source);
        File destDir=new File(dest);
        File[] files = file.listFiles();
        File[] desFiles = destDir.listFiles();
        List<File> destFileList= Arrays.asList(desFiles);
        for (int i = 0; i < files.length; i++) {
            File sfile = files[i];
            String fName = sfile.getName().replaceAll(".java", "");
//            System.out.println(fName);
            String mapperName = fName + "Mapper.java";
            String pathname = dest + File.separator + mapperName;
            if (destFileList.contains(new File(pathname))) {
                System.out.println("=============");
            }else{
                String content="package com.lee.gmall.manage.mapper;\n" +
                        "\n" +
                        "import com.lee.gmall.bean."+fName+";\n" +
                        "import tk.mybatis.mapper.common.Mapper;\n" +
                        "\n" +
                        "public interface "+fName+"Mapper extends Mapper<"+fName+"> {\n" +
                        "}";
                System.out.println(content);
                File destContentFile=new File(pathname);
                FileUtils.write(destContentFile,content, Charset.defaultCharset());
            }
        }
//        String fileName=
    }

}