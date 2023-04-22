package com.yangweiyao.mybatis.binding;

import cn.hutool.core.lang.ClassScanner;
import com.yangweiyao.mybatis.session.Configuration;
import com.yangweiyao.mybatis.session.SqlSession;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author YangWeiYao
 * @Description 提供包路径的扫描和映射器代理类注册机服务，完成接口对象的代理类注册处理。
 * @date 2023-4-22 15:05
 */
public class MapperRegistry {


    private final Configuration configuration;
    private final Map<Class<?>, MapperProxyFactory<?>> knownMappers = new HashMap<>();

    public MapperRegistry(Configuration configuration) {
        this.configuration = configuration;
    }

    @SuppressWarnings("unchecked")
    public <T> T getMapper(Class<T> type, SqlSession sqlSession) {
        final MapperProxyFactory<T> mapperProxyFactory =  ((MapperProxyFactory<T>) knownMappers.get(type));
        if(mapperProxyFactory == null) {
            throw new RuntimeException("Type " + type + " is not known to the MapperRegistry.");
        }
        try {
            return mapperProxyFactory.newInstance(sqlSession);
        } catch (Exception e) {
            throw new RuntimeException("Error getting mapper instance. Cause: " + e, e);
        }
    }

    public <T> void addMapper(Class<T> type) {
        if(type.isInterface()) {
            // Mapper 必须是接口才会注册
            if(hasMapper(type)) {
                throw new RuntimeException("Type " + type + " is already known to the MapperRegistry.");
            }
            // 注册映射器代理工厂
            knownMappers.put(type, new MapperProxyFactory<>(type));
        }
    }

    public <T> boolean hasMapper(Class<T> type) {
        return knownMappers.containsKey(type);
    }

    public void addMappers(String packageName) {
        Set<Class<?>> mapperSet = ClassScanner.scanAllPackage();
        for (Class<?> mapperClass  : mapperSet) {
            addMapper(mapperClass);
        }
    }

}
