package com.at.common.service;


import com.at.common.bean.PaymentInfo;

import java.util.Map;

public interface PaymentService {
    void savePaymentInfo(PaymentInfo paymentInfo);

    void updatePayment(PaymentInfo paymentInfo);

    void sendDelayPaymentResultCheckQueue(String outTradeNo,int count);

    Map<String,Object> checkAlipayPayment(String out_trade_no);
}
