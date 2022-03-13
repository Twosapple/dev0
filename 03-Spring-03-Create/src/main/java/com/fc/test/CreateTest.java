package com.fc.test;

import com.fc.dao.UserDao;
import com.fc.dao.impl.UserDaoImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CreateTest {
    @Test
    public void test(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao = applicationContext.getBean("userDao2", UserDao.class);

        userDao.add();
    }
    @Test
    public void testStatic(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        UserDao userDao3 = applicationContext.getBean("userDao3", UserDao.class);
        userDao3.add();
    }
}
