package com.yangweiyao.mybatis.session;

import java.sql.Connection;

/**
 * @author YangWeiYao
 * @Description
 * @date 2023-5-21 16:20
 */
public enum TransactionIsolationLevel {

    NONE(Connection.TRANSACTION_NONE),
    READ_COMMITTED(Connection.TRANSACTION_READ_COMMITTED),
    READ_UNCOMMITTED(Connection.TRANSACTION_READ_UNCOMMITTED),
    REPEATABLE_READ(Connection.TRANSACTION_REPEATABLE_READ),
    SERIALIZABLE(Connection.TRANSACTION_SERIALIZABLE);

    private final int level;

    TransactionIsolationLevel(int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
    }

}
