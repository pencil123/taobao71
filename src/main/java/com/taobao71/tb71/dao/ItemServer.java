package com.taobao71.tb71.dao;

import com.taobao71.tb71.domain.Item;
import org.springframework.stereotype.Service;

@Service
public interface ItemServer {
    public Integer addItem(Item item);

}
