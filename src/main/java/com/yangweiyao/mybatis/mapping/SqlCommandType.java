package com.yangweiyao.mybatis.mapping;

/**
 * @author YangWeiYao
 * @Description
 * @date 2023-4-22 17:06
 */
public enum SqlCommandType {
    /**
     * 未知
     */
    UNKNOWN,
    /**
     * 插入
     */
    INSERT,
    /**
     * 更新
     */
    UPDATE,
    /**
     * 删除
     */
    DELETE,
    /**
     * 查找
     */
    SELECT;
}
