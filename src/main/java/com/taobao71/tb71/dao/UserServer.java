package com.taobao71.tb71.dao;

import com.taobao71.tb71.domain.User;
import org.springframework.stereotype.Component;

@Component
public interface UserServer {
    /**
     * 用户信息插入；只维护Openid 字段
     * @param openid
     * @return 用户的ID
     */
    public Integer addUser(String openid);
}
