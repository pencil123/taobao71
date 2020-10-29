package com.taobao71.tb71.Controllers.Impl;

import com.taobao.api.request.TbkDgMaterialOptionalRequest;
import com.taobao71.tb71.Controllers.Search;
import com.taobao71.tb71.Controllers.TaokeApi;
import com.taobao71.tb71.Service.TaobaoClientServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/tkapi")
public class TaokeApiImpl implements TaokeApi {
    @Autowired
    private TaobaoClientServer taobaoClientServer;
    static Logger logger = LoggerFactory.getLogger(Search.class);

    @RequestMapping("searchMaterical")
    public void searchMatericalItems(@RequestParam(value = "keyword",required = false,defaultValue = "女装") String keyword){
        TbkDgMaterialOptionalRequest req = new TbkDgMaterialOptionalRequest();
        req.setQ(keyword);
        taobaoClientServer.searchMaterial(req);
    }
}
