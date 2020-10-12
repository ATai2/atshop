package com.atshop.atsql.com.atshop.sql.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.jdbc.ScriptRunner;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.Reader;
import java.nio.charset.Charset;
import java.sql.Connection;
import java.sql.DriverManager;

@Slf4j
@RestController
public class SqlExecController {

    private static String dbHost = "localhost";
    private static String dbName = "paas";
    private static String userName = "sa";
    private static String userPassword = "asdfF@1234";
    private static String dbPort = "1433";


    @GetMapping("hello")
    public String hello() {
        log.info("info");
        log.error("error");
        log.debug("debug");
        return "ok";
    }

    @GetMapping("sql")
    public String sql() {
        try {
            Connection conn = getMySqlConnection();
            ScriptRunner runner = new ScriptRunner(conn);
            Resources.setCharset(Charset.forName("UTF-8"));
            //设置字符集,不然中文乱码插入错误
            runner.setLogWriter(null);
            //设置是否输出日志
            // 绝对路径读取
//          Reader read = new FileReader(new File("f:\\test.sql"));
            // 从class目录下直接读取
            Reader read = Resources.getResourceAsReader("test.sql");
            runner.runScript(read);
            runner.closeConnection();
            conn.close();
            System.out.println("sql脚本执行完毕");
        } catch (Exception e) {
            System.out.println("sql脚本执行发生异常");
            e.printStackTrace();
        }
        return "ok";
    }


    /**
     * @return
     * @throws Exception
     * @功能描述： 获取数据库连接
     */
    public static Connection getMySqlConnection() throws Exception {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String url = "jdbc:sqlserver://" + dbHost + ":" + dbPort + ";databaseName=";
        return DriverManager.getConnection(url, userName, userPassword);
    }


}
