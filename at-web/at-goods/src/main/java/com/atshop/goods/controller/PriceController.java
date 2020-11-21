//package com.atshop.goods.controller;
//
//import com.atshop.goods.entity.PriceInfo;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.math.BigDecimal;
//
//@Slf4j
//@RestController
//@RequestMapping("/prices")
//public class PriceController {
//
//    @GetMapping("/{id}")
//    public PriceInfo getPrice(@PathVariable Long id) {
//      log.info("productId is "+id);
//
//      PriceInfo priceInfo=new PriceInfo();
//      priceInfo.setId(id);
//      priceInfo.setPrice(new BigDecimal(100));
//      return priceInfo;
//
//    }
//
//}
