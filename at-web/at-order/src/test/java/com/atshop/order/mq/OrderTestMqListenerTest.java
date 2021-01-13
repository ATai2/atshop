package com.atshop.order.mq;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQMapMessage;
import org.apache.activemq.command.ActiveMQTextMessage;
import org.junit.Before;
import org.junit.Test;

import javax.jms.*;

import static org.junit.Assert.*;

public class OrderTestMqListenerTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void consumePaymentResult() {
        ConnectionFactory connect = new ActiveMQConnectionFactory("tcp://94.191.68.209:61617");
        try {
            Connection connection = connect.createConnection();
            connection.start();
            //第一个值表示是否使用事务，如果选择true，第二个值相当于选择0
            Session session = connection.createSession(true, Session.SESSION_TRANSACTED);
            Queue testqueue = session.createQueue("test");

            MessageProducer producer = session.createProducer(testqueue);
            MapMessage mapMessage = new ActiveMQMapMessage();
            mapMessage.setString("key", "sss");

            producer.setDeliveryMode(DeliveryMode.PERSISTENT);
            producer.send(mapMessage);
            session.commit();
            connection.close();

        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void consumePaymentResult2() {
        ConnectionFactory connect = new ActiveMQConnectionFactory("tcp://94.191.68.209:61617");
        try {
            Connection connection = connect.createConnection();
            connection.start();
            //第一个值表示是否使用事务，如果选择true，第二个值相当于选择0
            Session session = connection.createSession(true, Session.SESSION_TRANSACTED);
            Queue testqueue = session.createQueue("ttt");

            MessageProducer producer = session.createProducer(testqueue);
            TextMessage textMessage = new ActiveMQTextMessage();
            textMessage.setText("今天天气真好！");
            producer.setDeliveryMode(DeliveryMode.PERSISTENT);
            producer.send(textMessage);
            session.commit();
            connection.close();

        } catch (JMSException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void test_consume(){
        ConnectionFactory connect = new ActiveMQConnectionFactory(ActiveMQConnection.DEFAULT_USER,ActiveMQConnection.DEFAULT_PASSWORD,"tcp://192.168.67.163:61616");
        try {
            Connection connection = connect.createConnection();
            connection.start();
            //第一个值表示是否使用事务，如果选择true，第二个值相当于选择0
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            Destination testqueue = session.createQueue("test");

            MessageConsumer consumer = session.createConsumer(testqueue);
            consumer.setMessageListener(new MessageListener() {
                @Override
                public void onMessage(Message message) {
                    if(message instanceof TextMessage){
                        try {
                            String text = ((TextMessage) message).getText();
                            System.out.println(text);

                            //session.rollback();
                        } catch (JMSException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                    }
                }
            });


        }catch (Exception e){
            e.printStackTrace();;
        }
    }
}