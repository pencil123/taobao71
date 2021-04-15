package com.taobao71.tb71.Service;

import com.taobao.api.request.TbkDgMaterialOptionalRequest;
import com.taobao.api.request.TbkItemInfoGetRequest;
import com.taobao71.tb71.model.domain.Item;
import com.taobao71.tb71.model.vo.Tpwd;
import org.springframework.stereotype.Service;

/**
 * tk 接口调用
 */
@Service
public interface TaobaoClientServer {
    /**
     *
     * @param tbkDgMaterialOptionalRequest
     * @return
     */
    public String searchMaterial(TbkDgMaterialOptionalRequest tbkDgMaterialOptionalRequest);

    public Item getItemInfo(TbkItemInfoGetRequest tbkItemInfoGetRequest);


    /**
     * 生成淘口令
     */
    public Tpwd gainTpwd(String targetUrl);

//    public String searchCouponByItemID(String itemId);
}
