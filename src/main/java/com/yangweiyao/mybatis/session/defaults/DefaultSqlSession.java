package com.yangweiyao.mybatis.session.defaults;

import com.yangweiyao.mybatis.binding.MapperRegistry;
import com.yangweiyao.mybatis.session.SqlSession;

/**
 * @author YangWeiYao
 * @Description
 * @date 2023-4-22 15:21
 */
public class DefaultSqlSession implements SqlSession {

    private final MapperRegistry mapperRegistry;

    public DefaultSqlSession(MapperRegistry mapperRegistry) {
        this.mapperRegistry = mapperRegistry;
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T> T selectOne(String statement) {
        return (T) ("你的操作被代理了！" + statement);
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T> T selectOne(String statement, Object parameter) {
        return (T) ("你的操作被代理了！" + "方法：" + statement + " 入参：" + parameter);
    }

    @Override
    public <T> T getMapper(Class<T> type) {
        return mapperRegistry.getMapper(type, this);
    }
}
