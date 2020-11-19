package com.atshop.user.dao;

import com.atshop.user.entity.Product;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ProductRepository extends PagingAndSortingRepository<Product,Integer> {
}
