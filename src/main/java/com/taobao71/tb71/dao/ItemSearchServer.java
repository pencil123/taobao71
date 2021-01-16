package com.taobao71.tb71.dao;

import com.taobao71.tb71.domain.ItemSearch;
import org.springframework.stereotype.Service;

/**
 * 逻辑：优惠券搜索
 * 用户搜索商品和优惠券的操作记录
 */
@Service
public interface ItemSearchServer {

    /**
     * 将用户搜索的商品信息，写入到数据库
     * @param itemSearch
     * @return 返回 search_id
     */
    public Long addItemSearch(ItemSearch itemSearch);
}
