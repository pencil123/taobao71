package com.taobao71.tb71.Service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.taobao71.tb71.model.domain.User;
import org.springframework.stereotype.Service;

@Service
public interface UserServer extends IService<User> {

  public User getByOpenId(String openID);
}
