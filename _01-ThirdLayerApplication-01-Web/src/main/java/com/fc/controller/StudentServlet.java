package com.fc.controller;

import com.fc.entity.Student;
import com.fc.service.StudentService;
import com.fc.service.impl.StudentServiceImpl;
import com.fc.vo.PageInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
//表示层【跟前端进行交互】
@WebServlet("/query")
//调用业务层对象【BO】
public class StudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取当前页
        String parameter = req.getParameter("pageNo");

        // 如果没有传递当前页，默认就是第一页
        int pageNo = 1;

        if (parameter != null) {
            pageNo = Integer.parseInt(parameter);
        }

        // 规定好每页显示多少条数据
        int pageSize = 5;

        StudentService studentService = new StudentServiceImpl();

//        StudentService studentService = new StudentService();
//通过业务层对象获取分页[业务层是中间层 Studentservice]
        PageInfo<Student> pageInfo =studentService.getPageInfo(pageNo, pageSize);

        req.setAttribute("pageInfo", pageInfo);

        System.out.println(pageInfo);

        req.getRequestDispatcher("query.jsp").forward(req, resp);
    }
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        //获取运行器
//        QueryRunner queryRunner = new QueryRunner();
////        获取链接
//        Connection connection = DruidUtil.getConnection();
////        sql语句
//        String sql="select * from Student";
//        List<Student> query=null;
////        查询准备
//        try {
//            query = queryRunner.query(connection, sql, new BeanListHandler<>(Student.class));
//        } catch (SQLException throwable) {
//            throwable.printStackTrace();
//        }
////        获取参数
//        req.setAttribute("list",query);
////        转发页面   用转发是因为需要携带参数
//        req.getRequestDispatcher("query.jsp").forward(req,resp);
//    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
