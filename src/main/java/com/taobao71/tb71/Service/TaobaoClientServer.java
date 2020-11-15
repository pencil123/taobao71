package com.taobao71.tb71.Service;

import com.taobao.api.request.TbkDgMaterialOptionalRequest;
import com.taobao.api.request.TbkItemInfoGetRequest;
import com.taobao.api.response.TbkDgMaterialOptionalResponse;
import com.taobao71.tb71.dao.ItemSearchServer;
import com.taobao71.tb71.domain.ItemSearch;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public interface TaobaoClientServer {

    public String searchMaterial(TbkDgMaterialOptionalRequest tbkDgMaterialOptionalRequest);

    public ItemSearch getItemInfo(TbkItemInfoGetRequest tbkItemInfoGetRequest);

//    public String searchCouponByItemID(String itemId);
}
