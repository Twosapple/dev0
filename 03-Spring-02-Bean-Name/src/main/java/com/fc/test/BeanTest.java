package com.fc.test;

import com.fc.entity.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanTest {
    @Test
    public void test(){
//        获取spring链接
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
//      //根据id映射到配置文件中
//        Object bean = applicationContext.getBean("student");
//      //      bean原本是一个地址,然后强转为对象
//        Student student=(Student) bean;
//        System.out.println(student);
//        运用字节码对象拿到对象
        Student student = applicationContext.getBean(Student.class);
        System.out.println(student);
    }
}
