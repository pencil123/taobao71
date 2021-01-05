package com.taobao71.tb71.Service;

import com.taobao.api.request.TbkDgMaterialOptionalRequest;
import com.taobao.api.request.TbkItemInfoGetRequest;
import com.taobao.api.response.TbkDgMaterialOptionalResponse;
import com.taobao71.tb71.dao.ItemSearchServer;
import com.taobao71.tb71.domain.ItemSearch;
import com.taobao71.tb71.domain.Tpwd;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Map;

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

    /**
     *
     * @param tbkItemInfoGetRequest
     * @return
     */
    public ItemSearch getItemInfo(TbkItemInfoGetRequest tbkItemInfoGetRequest);


    /**
     * 生成淘口令
     */
    public Tpwd gainTpwd(String targetUrl);

//    public String searchCouponByItemID(String itemId);
}
