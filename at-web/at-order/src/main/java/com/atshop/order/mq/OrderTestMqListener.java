package com.atshop.order.mq;

import com.at.common.bean.OmsOrder;
import com.at.common.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.MapMessage;

@Component
public class OrderTestMqListener {

    @Autowired
    OrderService orderService;

    @JmsListener(destination = "test",containerFactory = "jmsQueueListener")
    public void consumePaymentResult(MapMessage mapMessage) throws JMSException {

        String out_trade_no = mapMessage.getString("key");

        // 更新订单状态业务
        System.out.println(out_trade_no);

        OmsOrder omsOrder = new OmsOrder();
        omsOrder.setOrderSn(out_trade_no);

        orderService.updateOrder(omsOrder);

        System.out.println("11111111111111");


    }
}
