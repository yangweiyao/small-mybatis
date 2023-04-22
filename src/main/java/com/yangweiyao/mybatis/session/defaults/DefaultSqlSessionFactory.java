package com.yangweiyao.mybatis.session.defaults;

import com.yangweiyao.mybatis.binding.MapperRegistry;
import com.yangweiyao.mybatis.session.Configuration;
import com.yangweiyao.mybatis.session.SqlSession;
import com.yangweiyao.mybatis.session.SqlSessionFactory;

/**
 * @author YangWeiYao
 * @Description
 * @date 2023-4-22 15:25
 */
public class DefaultSqlSessionFactory implements SqlSessionFactory {

    private final Configuration configuration;

    public DefaultSqlSessionFactory(Configuration configuration) {
        this.configuration = configuration;
    }

    @Override
    public SqlSession openSession() {
        return new DefaultSqlSession(configuration);
    }
}
