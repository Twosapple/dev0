package com.fc.dao;

import com.fc.entity.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface StudentDao {
    //查询所有
List<Student> findAll();
//根据id查询   注解方式
Student findById(@Param("id") Integer id);
//增添    创建对象方式
int insert(Student student);
//删除 根据id删除
    int delete(@Param("id") Integer id);
//    修改
    int update(Student student);
    //模糊查询
    List<Student> findByKeyword(@Param("keyword")String keyword);
    //主键回填
    int getAutoIncrement(Student student);
}
