package com.yangweiyao.mybatis.transaction.jdbc;

import com.yangweiyao.mybatis.session.TransactionIsolationLevel;
import com.yangweiyao.mybatis.transaction.Transaction;
import com.yangweiyao.mybatis.transaction.TransactionFactory;

import javax.sql.DataSource;
import java.sql.Connection;

/**
 * @author YangWeiYao
 * @Description
 * @date 2023-5-21 16:49
 */
public class JdbcTransactionFactory implements TransactionFactory {

    @Override
    public Transaction newTransaction(Connection conn) {
        return new JdbcTransaction(conn);
    }

    @Override
    public Transaction newTransaction(DataSource dataSource, TransactionIsolationLevel level, boolean autoCommit) {
        return new JdbcTransaction(dataSource, level, autoCommit);
    }

}
