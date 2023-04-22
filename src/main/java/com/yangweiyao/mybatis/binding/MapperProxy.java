package com.yangweiyao.mybatis.binding;

import com.yangweiyao.mybatis.session.SqlSession;

import java.io.Serializable;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author YangWeiYao
 * @Description 映射器代理类，通过实现 InvocationHandler#invoke 代理类接口，封装操作逻辑的方式，对外接口提供数据库操作对象。
 * @date 2023-4-22 14:39
 */
public class MapperProxy<T> implements InvocationHandler, Serializable {

    private static final long serialVersionUID = -6395296665913272548L;

    private final SqlSession sqlSession;

    private final Class<T> mapperInterface;

    public MapperProxy(SqlSession sqlSession, Class<T> mapperInterface) {
        this.sqlSession = sqlSession;
        this.mapperInterface = mapperInterface;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if(Object.class.equals(method.getDeclaringClass())) {
            // 如果是 Object 提供的 toString、hashCode 等方法是不需要代理执行的
            return method.invoke(this, args);
        } else {
            return sqlSession.selectOne(method.getName(), args);
        }
    }

    public SqlSession getSqlSession() {
        return sqlSession;
    }

    public Class<T> getMapperInterface() {
        return mapperInterface;
    }
}
