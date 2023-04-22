package com.yangweiyao.mybatis.builder;

import com.yangweiyao.mybatis.session.Configuration;

/**
 * @author YangWeiYao
 * @Description
 * @date 2023-4-22 16:33
 */
public abstract class BaseBuilder {

    protected final Configuration configuration;

    public BaseBuilder(Configuration configuration) {
        this.configuration = configuration;
    }

    public Configuration getConfiguration() {
        return configuration;
    }
}
