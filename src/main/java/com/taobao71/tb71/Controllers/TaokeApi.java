package com.taobao71.tb71.Controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


public interface TaokeApi {
    public void searchMatericalItems(String keyword);
}
