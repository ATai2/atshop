package com.atshop.kettle;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.pentaho.di.core.KettleEnvironment;
import org.pentaho.di.core.database.DatabaseMeta;
import org.pentaho.di.core.exception.KettleException;
import org.pentaho.di.repository.RepositoryDirectoryInterface;
import org.pentaho.di.repository.kdr.KettleDatabaseRepository;
import org.pentaho.di.repository.kdr.KettleDatabaseRepositoryMeta;
import org.pentaho.di.trans.Trans;
import org.pentaho.di.trans.TransMeta;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

class ApplicationTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void test() throws KettleException {
        KettleEnvironment.init();
        KettleDatabaseRepository kettleDatabaseRepository = new KettleDatabaseRepository();

        DatabaseMeta databaseMeta = new DatabaseMeta("kettle", "Mysql",
                "Native", "94.191.68.209", "kettle", "13306",
                "root", "root");
        // 数据库形式的资源库元对象
        KettleDatabaseRepositoryMeta repInfo = new KettleDatabaseRepositoryMeta();
        repInfo.setConnection(databaseMeta);
        //资源库名称
        repInfo.setName("dmp-repo");
        // 数据库形式的资源库对象
        KettleDatabaseRepository kdr = new KettleDatabaseRepository();
        // 用资源库元对象初始化资源库对象
        kdr.init(repInfo);
        kdr.connect("adm", "adm");
        RepositoryDirectoryInterface directoryTree = kdr.loadRepositoryDirectoryTree();
        System.out.println(directoryTree);


    }

    @Test
    void testTrans() throws KettleException {
        KettleEnvironment.init();
        // krt文件方式
        TransMeta tm = new TransMeta("");
        Trans trans = new Trans(tm);
//        if (params != null) {
//            Iterator<Map.Entry<String, String>> entries = params.entrySet().iterator();
//            while (entries.hasNext()) {
//                Map.Entry<String, String> entry = entries.next();
//                trans.setParameterValue(entry.getKey(),entry.getValue());
//            }
//        }

        trans.execute(null);
        trans.waitUntilFinished();
    }

    @Test
    public void testDriver() throws ClassNotFoundException, SQLException {
        Class<?> aClass = Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://94.191.68.209:13306/kettle", "root", "root");
        System.out.println(connection);
    }
}