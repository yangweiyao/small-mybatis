package com.yangweiyao.mybatis.test.dao;

import com.yangweiyao.mybatis.test.po.UserInfo;

/**
 * @author YangWeiYao
 * @Description
 * @date 2023-4-22 14:52
 */
public interface UserDao {

    String queryUserInfoById(Long userId);

}
