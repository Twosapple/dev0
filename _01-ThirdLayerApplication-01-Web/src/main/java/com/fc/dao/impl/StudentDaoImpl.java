package com.fc.dao.impl;

import com.fc.dao.StudentDao;
import com.fc.entity.Student;
import com.fc.util.DruidUtil;
import com.fc.vo.PageInfo;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import javax.management.Query;
import java.sql.SQLException;
import java.util.List;

public class StudentDaoImpl implements StudentDao {
    QueryRunner queryRunner = new QueryRunner();

    Connection connection = DruidUtil.getConnection();

    // 获取总数据量
    public int getTotalCount() {


        String sql = "select * from student";

        List<Student> list = null;

        try {
            list = queryRunner.query(connection, sql, new BeanListHandler<>(Student.class));
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }

        if (list == null) {
            return 0;
        }

        return list.size();
    }

    // 获取每页中的数据
    public List<Student> getList(int start, int pageSize) {
        String sql = "select * from student limit ?, ?";

        List<Student> list = null;

        try {
            list = queryRunner.query(connection, sql, new BeanListHandler<>(Student.class), start, pageSize);
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }

        return list;
    }

//    // 获取分页信息对象
//    public PageInfo<Student> getPageInfo(int pageNo, int pageSize) {
//        // 获取总数据量
//        int totalCount = getTotalCount();
//
//        // 获取每页的开头，用于查询数据库
//        int start = (pageNo - 1) * pageSize;
//
//        // 获取每页中的所有内容
//        List<Student> list = getListByPage(start, pageSize);
//
//        // 获取分页信息对象
//        return new PageInfo<>(totalCount, pageSize, pageNo, list);
//    }
}
