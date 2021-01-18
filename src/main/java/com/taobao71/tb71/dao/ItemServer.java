package com.taobao71.tb71.dao;

import com.taobao71.tb71.domain.Item;
import org.springframework.stereotype.Service;

/**
 * 逻辑：自建库处理
 * 商品信息对象Item 管理
*/
@Service
public interface ItemServer {

    /**
     * 向数据库中查询商品Item信息
     * @param item
     * @return 上面的ID
     */
    public Integer addItem(Item item);

    /**
     * 商品Item 信息是否存储在数据库中
     * @param itemId
     * @return 返回商品的ID；如果没有则返回0
     */
    public Item getItemByItemId(Long itemId);
}
