package com.atshop.user.entity;

import com.atshop.user.UserApplication;
import com.atshop.user.dao.ProductRepository;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = UserApplication.class)
public class PhoneTest extends TestCase {
    @Autowired
    ProductRepository productRepository;

    @Test
    public void save(){
        Product product=new Product();
        product.setId(4);
        product.setName("a");
        product.setSku("sku");
//        product.setType(PhoneType.MOBILE);
        productRepository.save(product);
    }

    @Test
    public void find(){
        productRepository.findAll().forEach(System.out::println);
    }
}