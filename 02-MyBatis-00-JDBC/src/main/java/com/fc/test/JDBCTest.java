package com.fc.test;

import com.fc.entity.Student;
import org.junit.Test;

import java.sql.*;
import java.util.ArrayList;

public class JDBCTest {
    //查询
    @Test
    public  void testQuery(){
        //加载驱动
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //准备参数
            String url="jdbc:mysql://localhost:3306/rx2003?useSSL=false&useUnicode=true";
            String username="root";
            String password="root";
            String sql="select * from student";
            //获取链接
            Connection connection=DriverManager.getConnection(url,username,password);
            //获取预处理搬运工对象
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            //包装成结果集   拿到结果集对象
            ResultSet resultSet=preparedStatement.executeQuery();
            //结果可能有多个,所以要用 集合 泛型输出
            ArrayList<Student> students=new ArrayList<>();
            //遍历结果输出
            while (resultSet.next()){
                Student student=new Student();
                student.setId(resultSet.getInt("id"));
                student.setName(resultSet.getString("name"));
                student.setAge(resultSet.getInt("age"));
                student.setGender(resultSet.getString("gender"));
                student.setInfo(resultSet.getString("info"));
                students.add(student);
            }
            for (Student student : students) {
                System.out.println(student);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    //添加
    @Test
    public void testAdd(){
        //加载驱动
//        自己的叫?     jdbc    druid
        try {
            Class.forName("com.mysql.jdbc.Driver");
//准备参数
            String url = "jdbc:mysql://localhost:3306/rx2003?useSSL=false&useUnicode=true";
            String username="root";
            String password="root";
            String sql="insert into student(id, name, age, gender, info) values(?,?,?,?,?)";
            //获取链接
            Connection connection=DriverManager.getConnection(url,username,password);
            //获取与处理的搬运工对象
            PreparedStatement prepareStatement=connection.prepareStatement(sql);
            prepareStatement.setObject(1,"0301");
            prepareStatement.setObject(2,"瑶");
            prepareStatement.setObject(3,"22");
            prepareStatement.setObject(4,"女");
            prepareStatement.setObject(5,"0321");
            //获取受影响的行数
            int affectedRows=prepareStatement.executeUpdate();
            System.out.println("受影响的行数"+affectedRows);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
