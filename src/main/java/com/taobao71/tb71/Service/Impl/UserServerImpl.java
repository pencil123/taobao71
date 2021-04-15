package com.taobao71.tb71.Service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.taobao71.tb71.Service.UserServer;
import com.taobao71.tb71.mapper.UserMapper;
import com.taobao71.tb71.model.domain.User;

public class UserServerImpl extends ServiceImpl<UserMapper, User> implements UserServer {

  public User getByOpenId(String openID){
    QueryWrapper<User> wrapper = new QueryWrapper<>();
    wrapper.eq("openid", openID);
    return baseMapper.selectOne(wrapper);
  }
}