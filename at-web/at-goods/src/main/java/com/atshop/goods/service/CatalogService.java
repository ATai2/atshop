package com.atshop.goods.service;


import com.atshop.goods.entity.PmsBaseCatalog1;
import com.atshop.goods.entity.PmsBaseCatalog2;
import com.atshop.goods.entity.PmsBaseCatalog3;

import java.util.List;

public interface CatalogService {
    List<PmsBaseCatalog1> getCatalog1();

    List<PmsBaseCatalog2> getCatalog2(String catalog1Id);

    List<PmsBaseCatalog3> getCatalog3(String catalog2Id);
}
