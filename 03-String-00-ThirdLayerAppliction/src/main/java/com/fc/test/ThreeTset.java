package com.fc.test;

import com.fc.dao.impl.UserDaoOracleImpl;
import com.fc.service.UserService;
import com.fc.service.impl.UserServiceImpl;
import org.junit.Test;

public class ThreeTset {
@Test
    public void test(){
//    只有两层,就直接通过业务层调用
    UserService userService = new UserServiceImpl();
    userService.setUserDao(new UserDaoOracleImpl());
    userService.useJDBC();
}
}
