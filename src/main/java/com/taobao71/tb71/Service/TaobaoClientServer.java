package com.taobao71.tb71.Service;

import com.taobao.api.request.TbkDgMaterialOptionalRequest;
import com.taobao.api.request.TbkItemInfoGetRequest;
import com.taobao.api.response.TbkDgMaterialOptionalResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public interface TaobaoClientServer {

    public String searchMaterial(TbkDgMaterialOptionalRequest tbkDgMaterialOptionalRequest);

    public String getItemInfo(TbkItemInfoGetRequest tbkItemInfoGetRequest);

//    public String searchCouponByItemID(String itemId);
}
