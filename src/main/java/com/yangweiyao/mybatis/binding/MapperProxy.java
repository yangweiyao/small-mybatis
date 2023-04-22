package com.yangweiyao.mybatis.binding;

import java.io.Serializable;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * @author YangWeiYao
 * @Description 映射器代理类，通过实现 InvocationHandler#invoke 代理类接口，封装操作逻辑的方式，对外接口提供数据库操作对象。
 * @date 2023-4-22 14:39
 */
public class MapperProxy<T> implements InvocationHandler, Serializable {

    private static final long serialVersionUID = -6395296665913272548L;

    private final Map<String, String> sqlSession;

    private final Class<T> mapperInterface;

    public MapperProxy(Map<String, String> sqlSession, Class<T> mapperInterface) {
        this.sqlSession = sqlSession;
        this.mapperInterface = mapperInterface;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if(Object.class.equals(method.getDeclaringClass())) {
            // 如果是 Object 提供的 toString、hashCode 等方法是不需要代理执行的
            return method.invoke(this, args);
        } else {
            // sqlSession 的 Map 对象以接口名称+方法名称作为key
            return "代理对象：" + sqlSession.get(mapperInterface.getName() + "." + method.getName());
        }
    }

    public Map<String, String> getSqlSession() {
        return sqlSession;
    }

    public Class<T> getMapperInterface() {
        return mapperInterface;
    }
}
