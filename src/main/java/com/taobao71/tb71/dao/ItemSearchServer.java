package com.taobao71.tb71.dao;

import com.taobao71.tb71.domain.ItemSearch;
import org.springframework.stereotype.Service;

@Service
public interface ItemSearchServer {
    public Integer addItemSearch(ItemSearch itemSearch);
    public Integer itemExistRetrunId(Long item_id) ;
}
