package com.test.jms.queue;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class AppProducer {
    private static final String URL = "tcp://67.216.193.93:61616";
    private static final String QUEUE_NAME = "queue-test";

    public static void main(String[] args) throws JMSException {
        //1.创建ConnectionFactory
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(URL);
        //2.创建连接
        Connection connection = connectionFactory.createConnection();
        //3.启动连接
        connection.start();
        //4.创建回话
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        //5.创建目标
        Destination destination = session.createQueue(QUEUE_NAME);
        //6.创建生产者
        MessageProducer producer = session.createProducer(destination);

        for (int i = 0; i < 100; i++) {
            //7.创建消息
            TextMessage textMessage = session.createTextMessage("test" + i);
            //8.发布消息
            producer.send(textMessage);

                System.out.println("发送消息:" + textMessage.getText());
        }
        //9.关闭连接
        connection.close();
    }
}
