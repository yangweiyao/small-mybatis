package com.yangweiyao.mybatis.test;

import com.yangweiyao.mybatis.binding.MapperProxyFactory;
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
        MapperProxyFactory<UserDao> factory = new MapperProxyFactory<>(UserDao.class);

        Map<String, String> sqlSession = new HashMap<>();
        sqlSession.put("com.yangweiyao.mybatis.test.dao.UserDao.queryUserName", "模拟执行 Mapper.xml 中 SQL 语句的操作：查询用户姓名");

        UserDao userDao = factory.newInstance(sqlSession);
        System.out.println(userDao.queryUserName(1L));

    }

}
