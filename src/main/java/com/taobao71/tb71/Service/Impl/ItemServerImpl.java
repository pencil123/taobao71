package com.taobao71.tb71.Service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.taobao71.tb71.Service.ItemServer;
import com.taobao71.tb71.mapper.ItemMapper;
import com.taobao71.tb71.model.domain.Item;

public class ItemServerImpl extends ServiceImpl<ItemMapper, Item> implements ItemServer {
  public Item getItemByItemId(Long itemId){
    QueryWrapper<Item> wrapper = new QueryWrapper<>();
    wrapper.eq("item_id", itemId);
    return getOne(wrapper);
  }
}
