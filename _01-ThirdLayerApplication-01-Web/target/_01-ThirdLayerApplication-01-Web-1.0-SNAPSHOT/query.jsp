<%--
  Created by IntelliJ IDEA.
  User: 刘萍
  Date: 2022/3/3
  Time: 18:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>分页查询</title>
</head>
<body>
<table width="700px"  align="center" border="1px">
    <caption><h3>学生信息表</h3></caption>
    <tr>
        <th>学号</th>
        <th>姓名</th>
        <th>年龄</th>
        <th>性别</th>
        <th>信息</th>
        <th>操作</th>
    </tr>

    <c:if test="${not empty pageInfo.list}">
        <c:forEach var="student" items="${pageInfo.list}">
            <tr align="center">
                <td>${student.id}</td>
                <td>${student.name}</td>
                <td>${student.age}</td>
                <td>${student.gender}</td>
                <td>${student.info}</td>
                <td>
                    <a href="select?id=${student.id}">修改</a>
                    <a id="id${student.id}" onmouseover="over(${student.id})" onmouseout="out(${student.id})"
                       onclick="del(${student.id})">删除</a>
                </td>
            </tr>
        </c:forEach>
    </c:if>
    <tr>
        <td align="center" colspan="6">
            <a href="update.jsp">添加学生</a>
        </td>
    </tr>
</table>

<form action="query" method="get">
    <table align="center">
        <tr>
            <td>
                <c:if test="${1 == pageInfo.pageNo}">
                    <a disabled style="color: red">首页</a>
                </c:if>
                <c:if test="${1 != pageInfo.pageNo}">
                    <a href="query?pageNo=1">首页</a>
                </c:if>
            </td>
            <td>


                <c:if test="${1 == pageInfo.pageNo}">
                    <a disabled style="color: red">上一页</a>
                </c:if>

                <c:if test="${1 != pageInfo.pageNo}">
                    <a href="query?pageNo=${pageInfo.pageNo - 1}">上一页</a>
                </c:if>

            </td>
            <c:forEach var="pageNo" varStatus="pageStatus" begin="1" end="${pageInfo.pageCount}">
                <td>
                    <c:if test="${pageNo == pageInfo.pageNo}">
                        <input disabled type="submit" name="pageNo" value="${pageNo}">
                    </c:if>

                    <c:if test="${pageNo != pageInfo.pageNo}">
                        <input type="submit" name="pageNo" value="${pageNo}">
                    </c:if>
                </td>
            </c:forEach>
            <td>
                <%--如果当前页为最后一页--%>
                <c:if test="${pageInfo.pageCount == pageInfo.pageNo}">
                    <a disabled style="color: red">下一页</a>
                </c:if>
                <c:if test="${pageInfo.pageCount != pageInfo.pageNo}">
                    <a href="query?pageNo=${pageInfo.pageNo + 1}">下一页</a>
                </c:if>

            </td>
            <td>
                <c:if test="${pageInfo.pageCount == pageInfo.pageNo}">
                    <a disabled style="color: red">尾页</a>
                </c:if>
                <c:if test="${pageInfo.pageCount != pageInfo.pageNo}">
                    <a href="query?pageNo=${pageInfo.pageCount}">尾页</a>
                </c:if>
            </td>
            <td>共${pageInfo.totalCount}条内容，共${pageInfo.pageCount}页</td>
        </tr>
    </table>
</form>
</body>
<script>
    function del(id) {
        if (confirm('是否确认删除') === true) {
            window.location.href = 'delete?id=' + id;
        }
    }

    function over(id) {
        var a = document.getElementById('id' + id);
        a.style.color = 'red';
        a.style.color = 'pointer';
    }

    function out(id) {
        var a = document.getElementById('id' + id);
        a.style.color = 'black';
    }

</script>
</html>
