package com.yangweiyao.mybatis.builder;

import com.yangweiyao.mybatis.session.Configuration;
import com.yangweiyao.mybatis.type.TypeAliasRegistry;

/**
 * @author YangWeiYao
 * @Description
 * @date 2023-4-22 16:33
 */
public abstract class BaseBuilder {

    protected final Configuration configuration;
    protected final TypeAliasRegistry typeAliasRegistry;

    public BaseBuilder(Configuration configuration) {
        this.configuration = configuration;
        this.typeAliasRegistry = this.configuration.getTypeAliasRegistry();
    }

    public Configuration getConfiguration() {
        return configuration;
    }
}
