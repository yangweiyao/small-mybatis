package com.yangweiyao.mybatis.session.defaults;

import com.yangweiyao.mybatis.binding.MapperRegistry;
import com.yangweiyao.mybatis.mapping.MappedStatement;
import com.yangweiyao.mybatis.session.Configuration;
import com.yangweiyao.mybatis.session.SqlSession;

/**
 * @author YangWeiYao
 * @Description
 * @date 2023-4-22 15:21
 */
public class DefaultSqlSession implements SqlSession {

    private final Configuration configuration;

    public DefaultSqlSession(Configuration configuration) {
        this.configuration = configuration;
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T> T selectOne(String statement) {
        return (T) ("你的操作被代理了！" + statement);
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T> T selectOne(String statement, Object parameter) {
        MappedStatement mappedStatement = configuration.getMappedStatement(statement);
        return (T) ("你被代理了！" + "\n方法：" + statement + "\n入参：" + parameter + "\n待执行SQL：" + mappedStatement.getSql());
    }

    @Override
    public Configuration getConfiguration() {
        return configuration;
    }

    @Override
    public <T> T getMapper(Class<T> type) {
        return configuration.getMapper(type, this);
    }
}
