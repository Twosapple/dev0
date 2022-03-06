package com.fc.service;

import com.fc.entity.Student;
import com.fc.vo.PageInfo;

public interface StudentService {
//    业务层【BO】接口
    PageInfo<Student> getPageInfo(int pageNo, int pageSize);
}
