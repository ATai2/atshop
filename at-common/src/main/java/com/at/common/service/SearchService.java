package com.at.common.service;



import com.at.common.bean.PmsSearchParam;
import com.at.common.bean.PmsSearchSkuInfo;

import java.util.List;

public interface SearchService {
    List<PmsSearchSkuInfo> list(PmsSearchParam pmsSearchParam);
}
