package com.taobao71.tb71.dao;

import com.taobao71.tb71.domain.Material;
import org.springframework.stereotype.Component;

@Component
public interface MaterialServer {
    public void addMaterial(Material material);
}
