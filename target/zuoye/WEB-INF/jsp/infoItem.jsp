<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>消息详情</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="<%=basePath%>nasa/css/reset.css">
<link rel="stylesheet" href="<%=basePath%>nasa/css/supersized.css">
<link rel="stylesheet" href="<%=basePath%>nasa/css/style.css">
<script type="text/javascript">
	function diag() {
		alert("删除成功")
	}
</script>
<script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.js"></script>
<script type="text/javascript">
	function getData(){
		$.ajax({
			url:"<%=basePath%>/info/updateById",
			type:"post",
			datatype:"json",
			data:JSON.stringify({
				"content": $('#content').val(),
				"title": $("#title").val(), 
				"date": new Date($("#date").val()),
				"id": $('#id').val()
			}),
			contentType: 'application/json',
			success:function(){
					alert("已保存！");
					window.location.href="<%=basePath%>/info/queryAll";

			}
		})
	}


</script>

</head>
<body>
<input id="basePath" type="hidden" value="<%=basePath%>" />
	<h1>消息详情</h1>


	<div id="infoItem">
		<div class="input_info">
				<input type="hidden" id="id" name="id" value="${info.id}"><br/>
			标题：<input type="text" id="title" name="title" value="${info.title}" /><br/>
			日期：<input type="text" id="date" name="date" value="<fmt:formatDate value="${info.date}" pattern="yyyy-MM-dd" />" /><br/>
			<input type="text" id="content" name="content"
				style="width: 400px; height: 200px;" value="${info.content}" /><br/>
		</div>

		<!--操作按钮-->
		<div class="button_info clearfix">

			<input type="submit" value="保存" class="btn_save"
				onclick="getData()" /> 
			<input type="button" value="删除"
				class="btn_delete" onclick="diag(); location.href='<%=basePath%>/info/delete?id=${info.id}'"/>
		</div>
	</div>
	<!-- Javascript -->
	<script src="<%=basePath%>nasa/js/jquery-1.8.2.min.js"></script>
	<script src="<%=basePath%>nasa/js/supersized.3.2.7.min.js"></script>
	<script src="<%=basePath%>nasa/js/supersized-init.js"></script>
	<script src="<%=basePath%>nasa/js/scripts.js"></script>
</body>
</html>