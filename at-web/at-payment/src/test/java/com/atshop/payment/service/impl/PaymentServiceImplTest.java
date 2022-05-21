package com.atshop.payment.service.impl;

import com.at.common.bean.PaymentInfo;
import com.atshop.payment.mapper.PaymentInfoMapper;
import com.atshop.service.util.ActiveMQUtil;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Map;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class PaymentServiceImplTest {

    private PaymentServiceImpl paymentServiceImplUnderTest;

    @Before
    public void setUp() {
        paymentServiceImplUnderTest = new PaymentServiceImpl();
        paymentServiceImplUnderTest.paymentInfoMapper = mock(PaymentInfoMapper.class);
        paymentServiceImplUnderTest.activeMQUtil = mock(ActiveMQUtil.class);
    }

    @Test
    public void testSavePaymentInfo() {
        // Setup
        final PaymentInfo paymentInfo = new PaymentInfo();
        paymentInfo.setId("id");
        paymentInfo.setOrderSn("orderSn");
        paymentInfo.setOrderId("orderId");
        paymentInfo.setAlipayTradeNo("alipayTradeNo");
        paymentInfo.setTotalAmount(new BigDecimal("0.00"));
        paymentInfo.setSubject("subject");
        paymentInfo.setPaymentStatus("paymentStatus");
        paymentInfo.setCreateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        paymentInfo.setCallbackTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        paymentInfo.setCallbackContent("callbackContent");

        when(paymentServiceImplUnderTest.paymentInfoMapper.insertSelective(any(PaymentInfo.class))).thenReturn(0);

        // Run the test
        paymentServiceImplUnderTest.savePaymentInfo(paymentInfo);

        // Verify the results
        verify(paymentServiceImplUnderTest.paymentInfoMapper).insertSelective(any(PaymentInfo.class));
    }

    @Test
    public void testUpdatePayment() {
        // Setup
        final PaymentInfo paymentInfo = new PaymentInfo();
        paymentInfo.setId("id");
        paymentInfo.setOrderSn("orderSn");
        paymentInfo.setOrderId("orderId");
        paymentInfo.setAlipayTradeNo("alipayTradeNo");
        paymentInfo.setTotalAmount(new BigDecimal("0.00"));
        paymentInfo.setSubject("subject");
        paymentInfo.setPaymentStatus("paymentStatus");
        paymentInfo.setCreateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        paymentInfo.setCallbackTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        paymentInfo.setCallbackContent("callbackContent");

        // Configure PaymentInfoMapper.selectOne(...).
        final PaymentInfo paymentInfo1 = new PaymentInfo();
        paymentInfo1.setId("id");
        paymentInfo1.setOrderSn("orderSn");
        paymentInfo1.setOrderId("orderId");
        paymentInfo1.setAlipayTradeNo("alipayTradeNo");
        paymentInfo1.setTotalAmount(new BigDecimal("0.00"));
        paymentInfo1.setSubject("subject");
        paymentInfo1.setPaymentStatus("paymentStatus");
        paymentInfo1.setCreateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        paymentInfo1.setCallbackTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        paymentInfo1.setCallbackContent("callbackContent");
        when(paymentServiceImplUnderTest.paymentInfoMapper.selectOne(any(PaymentInfo.class))).thenReturn(paymentInfo1);

        when(paymentServiceImplUnderTest.activeMQUtil.getConnectionFactory()).thenReturn(null);
        when(paymentServiceImplUnderTest.paymentInfoMapper.updateByExampleSelective(any(PaymentInfo.class),
                any(Object.class))).thenReturn(0);

        // Run the test
        paymentServiceImplUnderTest.updatePayment(paymentInfo);

        // Verify the results
        verify(paymentServiceImplUnderTest.paymentInfoMapper).updateByExampleSelective(any(PaymentInfo.class),
                any(Object.class));
    }

    @Test
    public void testSendDelayPaymentResultCheckQueue() {
        // Setup
        when(paymentServiceImplUnderTest.activeMQUtil.getConnectionFactory()).thenReturn(null);

        // Run the test
        paymentServiceImplUnderTest.sendDelayPaymentResultCheckQueue("outTradeNo", 0);

        // Verify the results
    }

    @Test
    public void testCheckAlipayPayment() {
        // Setup
        // Run the test
        final Map<String, Object> result = paymentServiceImplUnderTest.checkAlipayPayment("out_trade_no");

        // Verify the results
    }
}
