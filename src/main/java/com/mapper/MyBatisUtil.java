package com.mapper;

import org.apache.ibatis.datasource.DataSourceFactory;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;
import java.util.Properties;

/**
 * @author 信息化管理部-方波
 * @site http://www.cr121.com/
 * @company 中铁十二局集团第一工程有限公司
 * @create 2020-03-08 16:38
 */
public class MyBatisUtil {
    private static SqlSessionFactory factory = null;

    static {
        try {
            InputStream is = Resources.getResourceAsStream("mybatis.cfg.xml");
            factory = new SqlSessionFactoryBuilder().build(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static SqlSession getSqlSession() {
        SqlSession session = null;
        if (factory != null) {
            // true表示开启自动提交
            // session = factory.openSession(true);
            session = factory.openSession();
        }

        return session;
    }

    private static final Properties properties = null;

    static {
        try {
            InputStream is = DataSourceFactory.class.getResourceAsStream("db.properties");
            properties.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        Connection connection = null;

        if(properties != null) {
            String driver = properties.getProperty("jdbc.driver");
            String url = properties.getProperty("jdbc.url");
            String username = properties.getProperty("jdbc.username");
            String password = properties.getProperty("jdbc.password");


            try {
                Class.forName(driver);
                connection = DriverManager.getConnection(url, username, password);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        return connection;
    }
}
