package com.yangweiyao.mybatis.test;

import com.yangweiyao.mybatis.io.Resources;
import com.yangweiyao.mybatis.session.SqlSession;
import com.yangweiyao.mybatis.session.SqlSessionFactory;
import com.yangweiyao.mybatis.session.SqlSessionFactoryBuilder;
import com.yangweiyao.mybatis.test.dao.UserDao;

import java.io.IOException;
import java.io.Reader;

/**
 * @author YangWeiYao
 * @Description
 * @date 2023-4-22 17:44
 */
public class SqlSessionFactoryTest {

    public static void main(String[] args) throws IOException {

        // 从SqlSessionFactory中获取SqlSession
        Reader reader = Resources.getResourceAsReader("mybatis-config-datasource.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);

        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 获取映射器对象
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        System.out.println(userDao.queryUserInfoById(1L));

    }

}
