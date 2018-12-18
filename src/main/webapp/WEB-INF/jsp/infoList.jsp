<%@ page language="java" import="java.util.*"  import="java.lang.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML>
<html lang="en" class="no-js">
<head>
<title>消息列表</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!-- CSS -->
<link rel="stylesheet" href="<%=basePath%>nasa/css/reset.css">
<link rel="stylesheet" href="<%=basePath%>nasa/css/supersized.css">
<link rel="stylesheet" href="<%=basePath%>nasa/css/style.css">
</head>

<body>

	<input id="basePath" type="hidden" value="<%=basePath%>" />

    <div class="container">
        <!-- 标题 -->
        <div class="row">
            <div class="col-md-12">
                <h1>消息列表</h1>
            </div>
        </div>

        <!-- 表格  -->
        <div class="row">
            <div class="col-md-12">
                <table class="table table-hover">
                    <tr>
                        <th>消息标题</th>
                        <th>时间</th>
                        <th>操作</th>
                    </tr>
                    <c:forEach items="${listInfo}" var="info">
                        <tr>
                        <td>${info.title}</td>
                        <td><fmt:formatDate value="${info.date}"
								pattern="yyyy-MM-dd" /></td>
                            <td>
                                <a type="button"  href="<%=basePath%>/info/queryById?id=${info.id}" class="btn btn-info btn-sm">
                                <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
                                    编辑</a>
                                <a type="button"  href="<%=basePath%>/info/delete?id=${info.id}" class="btn btn-danger btn-sm">
                                <span class="glyphicon glyphicon-trash" aria-hidden="true" ></span>
                                    删除</a>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>

  </div>
    <script src="<%=basePath%>nasa/js/jquery-1.8.2.min.js"></script>
	<script src="<%=basePath%>nasa/js/supersized.3.2.7.min.js"></script>
	<script src="<%=basePath%>nasa/js/supersized-init.js"></script>
	<script src="<%=basePath%>nasa/js/scripts.js"></script>
  
</body>
</html>
