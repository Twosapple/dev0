package com.fc.service.impl;

import com.fc.dao.StudentDao;
import com.fc.dao.impl.StudentDaoImpl;
import com.fc.entity.Student;
import com.fc.service.StudentService;
import com.fc.vo.PageInfo;

import java.util.List;
// 业务层接口的是实现类【BO】
public class StudentServiceImpl implements StudentService {
    StudentDao studentDao=new StudentDaoImpl();
    @Override
//    此方法用来获取PageInfo的,因为获取PageInfo需要传递两个参数,所以问题就变成了如何获取两个参数,
//    这两个参数都和数据库相关,业务逻辑层只能和数据访问层相接,数据访问层可以操作数据层,所以通过业务逻辑层与数据访问层相接,来获得两个参数[创建对象 ]
    public PageInfo<Student> getPageInfo(int pageNo, int pageSize) {
        int totalCount = studentDao.getTotalCount();

        List<Student> list=studentDao.getList(pageNo,pageSize);

        return new PageInfo<>(totalCount,pageSize,pageNo,list);
    }
}
