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

public class BindTest {
    @Test
    public void testInsert(){
        try {
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession session = factory.openSession();
            StudentDao studentDao = session.getMapper(StudentDao.class);
            Student student = new Student();
            student.setName("同样");
            student.setAge((byte) 12);
            student.setGender("男");
            student.setInfo("同样的微笑挂在你同样的嘴角");
            student.setBirthday(new Date(2134,12,12,1,34,2));
            int affectedRows = studentDao.insert(student);

            session.commit();
            session.close();

            System.out.println("受影响的行数"+affectedRows);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void test(){
        try {
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession session = factory.openSession();
            StudentDao studentDao = session.getMapper(StudentDao.class);
            HashMap<String, Object> map = new HashMap<>();
            map.put("id",1);
            map.put("gender","男");
            Student student = studentDao.findByIdAndGender(map);
            System.out.println(student);
            session.commit();
            session.close();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
@Test
    public void FindByIdAndName(){
    try {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = factory.openSession();
        StudentDao studentDao = session.getMapper(StudentDao.class);
        studentDao.findById(2);
        Student student = studentDao.findByIdAndName(1, "易烊千玺");
        System.out.println(student);

        session.commit();
        session.close();


    } catch (IOException e) {
        e.printStackTrace();
    }
}
    @Test
    public void FindByIdAndAge(){
        try {
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession session = factory.openSession();
            StudentDao studentDao = session.getMapper(StudentDao.class);
            Student student = studentDao.findByIdAndAge(1, 22);
            System.out.println(student);

            session.commit();
            session.close();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void FindByNameAndAge(){
        try {
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession session = factory.openSession();
            StudentDao studentDao = session.getMapper(StudentDao.class);
            Student student = studentDao.findByNameAndAge("易烊千玺", 22);
            System.out.println(student);

            session.commit();
            session.close();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
