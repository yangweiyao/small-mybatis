package com.yangweiyao.mybatis.session.defaults;

import com.yangweiyao.mybatis.binding.MapperRegistry;
import com.yangweiyao.mybatis.session.SqlSession;
import com.yangweiyao.mybatis.session.SqlSessionFactory;

/**
 * @author YangWeiYao
 * @Description
 * @date 2023-4-22 15:25
 */
public class DefaultSqlSessionFactory implements SqlSessionFactory {

    private final MapperRegistry mapperRegistry;

    public DefaultSqlSessionFactory(MapperRegistry mapperRegistry) {
        this.mapperRegistry = mapperRegistry;
    }

    @Override
    public SqlSession openSession() {
        return new DefaultSqlSession(mapperRegistry);
    }
}
