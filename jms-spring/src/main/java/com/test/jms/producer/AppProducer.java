package com.test.jms.producer;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppProducer {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("producer.xml");
        ProducerService bean = ac.getBean(ProducerService.class);
        //ProducerService bean = (ProducerService) ac.getBean("ProducerServiceImpl2");
        for (int i = 1; i <= 100; i++) {
            bean.sendMessage("test:" + i);
        }
        ((ClassPathXmlApplicationContext) ac).close();
    }
}
