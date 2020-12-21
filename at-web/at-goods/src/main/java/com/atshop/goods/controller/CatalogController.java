package com.atshop.goods.controller;


import com.at.common.bean.PmsBaseCatalog1;
import com.at.common.bean.PmsBaseCatalog2;
import com.at.common.bean.PmsBaseCatalog3;
import com.atshop.goods.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class CatalogController {

    @Autowired
    CatalogService catalogService;

    @RequestMapping("getCatalog3")
    @ResponseBody
    public List<PmsBaseCatalog3> getCatalog3(@RequestParam String catalog2Id){

        List<PmsBaseCatalog3> catalog3s = catalogService.getCatalog3(catalog2Id);
        return catalog3s;
    }


    @RequestMapping("getCatalog2")
    @ResponseBody
    public List<PmsBaseCatalog2> getCatalog2(@RequestParam String catalog1Id){

        List<PmsBaseCatalog2> catalog2s = catalogService.getCatalog2(catalog1Id);
        return catalog2s;
    }

    @RequestMapping("getCatalog1")
    @ResponseBody
    public List<PmsBaseCatalog1> getCatalog1(){

        List<PmsBaseCatalog1> catalog1s = catalogService.getCatalog1();
        return catalog1s;
    }
}
