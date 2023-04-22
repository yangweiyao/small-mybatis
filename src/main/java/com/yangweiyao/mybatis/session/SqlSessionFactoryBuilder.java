package com.yangweiyao.mybatis.session;

import com.yangweiyao.mybatis.builder.xml.XMLConfigBuilder;
import com.yangweiyao.mybatis.session.defaults.DefaultSqlSessionFactory;

import java.io.Reader;

/**
 * @author YangWeiYao
 * @Description
 * @date 2023-4-22 16:31
 */
public class SqlSessionFactoryBuilder {

    public SqlSessionFactory build(Reader reader) {
        XMLConfigBuilder xmlConfigBuilder = new XMLConfigBuilder(reader);
        return build(xmlConfigBuilder.parse());
    }

    public SqlSessionFactory build(Configuration config) {
        return new DefaultSqlSessionFactory(config);
    }

}
