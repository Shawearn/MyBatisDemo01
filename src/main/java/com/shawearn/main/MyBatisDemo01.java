package com.shawearn.main;

import com.shawearn.mapper.UserMapper;
import com.shawearn.model.User;
import com.shawearn.util.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;

/**
 * Created by Shawearn on 7/24/2017.
 */
public class MyBatisDemo01 {

    public static void main(String[] args) {
        addUser();
        query();
    }

    /**
     * 添加；
     */
    private static void addUser() {
        SqlSession sqlSession = null;
        try {
            sqlSession = SqlSessionFactoryUtil.openSqlSession();
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            User user = new User();
            user.setUserName("Shawearn");
            user.setDescript("第一名用户");
            userMapper.insertUser(user);
            sqlSession.commit();
        } catch (Exception e) {
            sqlSession.rollback();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }

    /**
     * 查询；
     */
    private static void query() {
        SqlSession sqlSession = null;
        User user = null;
        try {
            sqlSession = SqlSessionFactoryUtil.openSqlSession();
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            user = userMapper.selectById(1);
            sqlSession.commit();
        } catch (Exception e) {
            sqlSession.rollback();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
        System.out.println(user.getUserName());
    }
}
