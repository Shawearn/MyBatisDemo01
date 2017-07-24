package com.shawearn.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * 用于创建 SqlSessionFactory 对象；
 *
 * Created by Shawearn on 7/24/2017.
 */
public class SqlSessionFactoryUtil {
    private static SqlSessionFactory sqlSessionFactory = null;

    /**
     * 私有构造参数，防止外部通过 new 实例化 SqlSessionFactoryUtil；
     */
    private SqlSessionFactoryUtil() {
    }

    /**
     * 创建 SqlSessionFactory 对象；
     *
     * @return
     */
    private static void createSqlSessionFactory() {
        synchronized (SqlSessionFactoryUtil.class) {
            if (sqlSessionFactory == null) {
                InputStream inputStream = null;
                try {
                    inputStream = Resources.getResourceAsStream("mybatis-config.xml");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            }
        }
    }

    /**
     * 打开 SqlSession；
     *
     * @return
     */
    public static SqlSession openSqlSession() {
        if (sqlSessionFactory == null) {
            createSqlSessionFactory();
        }
        return sqlSessionFactory.openSession();
    }
}
