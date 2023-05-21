package com.yangweiyao.mybatis.datasource;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * @author yangweiyao
 * @Description 数据源工厂
 * @date 2023-5-21 16:56
 */
public interface DataSourceFactory {

    void setProperties(Properties props);

    DataSource getDataSource();

}
