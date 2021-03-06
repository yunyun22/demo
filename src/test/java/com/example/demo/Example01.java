package com.example.demo;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.jdbc.ScriptRunner;
import org.apache.ibatis.jdbc.SqlRunner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * @author wang, jinqiao
 * @date 04/03/2021
 */
public class Example01 {
    private Connection conn = null;

    @BeforeEach
    public void initData() {
        try {
            // 加载HSQLDB驱动
            Class.forName("org.hsqldb.jdbcDriver");
            // 获取Connection对象
            conn = DriverManager.getConnection("jdbc:hsqldb:mem:mybatis", "sa", "");
            // 使用Mybatis的ScriptRunner工具类执行数据库脚本
            ScriptRunner scriptRunner = new ScriptRunner(conn);
            scriptRunner.setLogWriter(null);
            scriptRunner.runScript(Resources.getResourceAsReader("create-table.sql"));
            scriptRunner.runScript(Resources.getResourceAsReader("init-data.sql"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testHsqldbQuery() {
        // SqlRunner是Mybatis封装的操作数据库的工具类
        SqlRunner sqlRunner = new SqlRunner(conn);
        try {
            //调用SqlRunner类的selectAll()方法查询数据
            List<Map<String, Object>> results = sqlRunner.selectAll("select * from user");
            results.forEach(System.out::println);
            sqlRunner.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
