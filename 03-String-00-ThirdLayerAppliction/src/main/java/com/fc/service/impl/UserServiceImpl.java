package com.fc.service.impl;

import com.fc.dao.UserDao;
import com.fc.dao.impl.UserDaoImpl;
import com.fc.dao.impl.UserDaoMySQLImpl;
import com.fc.dao.impl.UserDaoOracleImpl;
import com.fc.service.UserService;

public class UserServiceImpl implements UserService {
//    业务层连接不到数据库,就让底层去链接,底层创建一个对象,然后调用业务层的方法实现
    private UserDao userDao;
    @Override
    public void useJDBC() {
       userDao.useJDBC();
    }

    @Override
    public void setUserDao(UserDao userDao) {
        this.userDao=userDao;
    }
}
