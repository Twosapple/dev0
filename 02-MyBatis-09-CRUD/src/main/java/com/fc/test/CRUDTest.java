package com.fc.test;

import com.fc.dao.StudentDao;
import com.fc.entity.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class CRUDTest {
@Test
    public void find(){
    try {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");

        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession session = factory.openSession();
        StudentDao studentDao = session.getMapper(StudentDao.class);
        List<Student> students = studentDao.findAll();
        for (Student student : students) {
            System.out.println(student);
        }
        session.commit();
        session.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
}
@Test
    public void findById(){
    try {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = factory.openSession();
        StudentDao studentDao = session.getMapper(StudentDao.class);
        Student student = studentDao.findById(2);
        System.out.println(student);
         session.commit();
         session.close();

    } catch (IOException e) {
        e.printStackTrace();
    }
}
@Test
public void insert(){
    try {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = factory.openSession();
        StudentDao studentDao = session.getMapper(StudentDao.class);
        Student student = new Student();
        student.setName("素颜");
        student.setAge((byte)18);
        student.setBirthday(new Date(3456,3,3,8,8,8));
        student.setInfo("许嵩");
        int delete = studentDao.insert(student);
        System.out.println("受影响的行数"+delete);
        session.commit();
        session.close();

    } catch (IOException e) {
        e.printStackTrace();
    }
}
@Test
    public void delete(){
    try {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = factory.openSession();
        StudentDao studentDao = session.getMapper(StudentDao.class);
        int delete = studentDao.delete(3);
        System.out.println("受影响的行数"+delete);
        session.commit();
        session.close();

    } catch (IOException e) {
        e.printStackTrace();
    }
}
@Test
    public void update(){
    try {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = factory.openSession();
        StudentDao studentDao = session.getMapper(StudentDao.class);
        Student student = new Student();
        student.setId(4);
        student.setBirthday(new Date(3456,8,4,5,6));
        int update = studentDao.update(student);
        System.out.println("受影响的行数"+update);
        session.commit();
        session.close();

    } catch (IOException e) {
        e.printStackTrace();
    }
}
@Test
    public void findKeyword(){
    try {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = factory.openSession();
        StudentDao studentDao = session.getMapper(StudentDao.class);
        List<Student> students = studentDao.findByKeyword("%喜%");
        for (Student student : students) {
            System.out.println(student);
        }
        session.commit();
        session.close();


    } catch (IOException e) {
        e.printStackTrace();
    }
}
    @Test
    public void GetAutoIncrement(){
        try {
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession session = factory.openSession();
            StudentDao studentDao = session.getMapper(StudentDao.class);
            Student student = new Student();
            student.setName("留香");
            student.setAge((byte)18);
            student.setGender("男");
            student.setBirthday(new Date(3456,3,3,8,8,8));
            student.setInfo("许嵩");
            int delete = studentDao.getAutoIncrement(student);
            System.out.println("受影响的行数"+delete);
            System.out.println("自增长的id"+student.getId());
            session.commit();
            session.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
