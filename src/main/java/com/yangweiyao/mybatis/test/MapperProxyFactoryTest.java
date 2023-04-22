package com.yangweiyao.mybatis.test;

import com.yangweiyao.mybatis.binding.MapperProxyFactory;
import com.yangweiyao.mybatis.binding.MapperRegistry;
import com.yangweiyao.mybatis.session.SqlSession;
import com.yangweiyao.mybatis.session.SqlSessionFactory;
import com.yangweiyao.mybatis.session.defaults.DefaultSqlSessionFactory;
import com.yangweiyao.mybatis.test.dao.UserDao;

import java.util.HashMap;
import java.util.Map;

/**
 * @author YangWeiYao
 * @Description
 * @date 2023-4-22 14:53
 */
public class MapperProxyFactoryTest {

    public static void main(String[] args) {

        // 1. 注册 Mapper
//        MapperRegistry registry = new MapperRegistry();
//        registry.addMappers("com.yangweiyao.mybatis.test.dao");
//
//        // 2. 从 SqlSession 工厂获取 Session
//        SqlSessionFactory sqlSessionFactory = new DefaultSqlSessionFactory(registry);
//        SqlSession sqlSession = sqlSessionFactory.openSession();

//        Map<String, String> sqlSession = new HashMap<>();
//        sqlSession.put("com.yangweiyao.mybatis.test.dao.UserDao.queryUserName", "模拟执行 Mapper.xml 中 SQL 语句的操作：查询用户姓名");

//        UserDao userDao = factory.newInstance(sqlSession);

//        // 3. 获取映射器对象
//        UserDao userDao = sqlSession.getMapper(UserDao.class);
//
//        System.out.println(userDao.queryUserName(1L));

    }

}
