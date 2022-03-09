package com.fc.dao;

import com.fc.entity.Student;

import java.util.List;

public interface StudentDao {
         List<Student> findLessThanAge(Integer age);
         List<Student> findGreaterThanAge(Integer age);
}
