package com.taobao71.tb71.Controllers;

import com.taobao.api.request.TbkDgMaterialOptionalRequest;
import com.taobao.api.request.TbkItemInfoGetRequest;
import com.taobao71.tb71.Service.tk.TaobaoClientServer;
import com.taobao71.tb71.Service.tk.TaokeServer;
import com.taobao71.tb71.model.domain.Coupon;
import com.taobao71.tb71.rabbitmq.Publisher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tkapi")
public class TaokeController {
    @Autowired
    private TaobaoClientServer taobaoClientServer;
    @Autowired
    private Publisher publisher;
    @Autowired
    private TaokeServer taokeServer;

    private TbkItemInfoGetRequest req = new TbkItemInfoGetRequest();
    static Logger logger = LoggerFactory.getLogger(TaokeController.class);

    @RequestMapping("searchMaterical")
    public void searchMatericalItems(@RequestParam(value = "keyword",required = false,defaultValue = "女装") String keyword){
        TbkDgMaterialOptionalRequest req = new TbkDgMaterialOptionalRequest();
        req.setQ(keyword);
        taobaoClientServer.searchMaterial(req);
    }

    /**
     * 从接口处查询数据；根据Item_id 查询信息
     * @param item_id 宝贝的ID
     */
    @RequestMapping("getItemInfo")
    public void getItemInfo(@RequestParam(value = "item_id",required = true,defaultValue = "123") String item_id){
        TbkItemInfoGetRequest req = new TbkItemInfoGetRequest();
        req.setNumIids(item_id);
        taobaoClientServer.getItemInfo(req);
    }

    /**
     * 更加item_id 查询优惠券；判断是否已经存储，如果没有，则调用接口。
     * @param item_id 宝贝ID
     * @return
     */
    @RequestMapping("getCouponByItemId")
    public Coupon searchCouponByItemId(@RequestParam(value = "item_id",required = true,defaultValue = "123") String item_id) {
        return taokeServer.getCouponByItemId(item_id,true);
    }
}
