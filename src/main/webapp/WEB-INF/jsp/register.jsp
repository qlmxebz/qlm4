<!DOCTYPE html>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html lang="en" class="no-js">
<head>
<meta charset="utf-8">
<title>用户注册</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<!-- CSS -->
<link rel="stylesheet" href="<%=basePath%>nasa/css/reset.css">
<link rel="stylesheet" href="<%=basePath%>nasa/css/supersized.css">
<link rel="stylesheet" href="<%=basePath%>nasa/css/style.css">
<script type="text/javascript">
<!--注册表 -->
	function disable() {
		document.getElementById("btnRegister").disabled = true
		$(".info_inner button").attr("style", "background:#c0c0c0");
	}
	function enable() {
		document.getElementById("btnRegister").disabled = false
		$(".info_inner button").attr("style", "background:#2abba3");
	}
	//手机验证码部分

    var countdown=60;
    var global=0;
    function settime(obj) {

    if (countdown == 0) {
        obj.removeAttribute("disabled");
        obj.value="免费获取验证码";
        countdown = 60;
        return;
    } else {
        obj.setAttribute("disabled", true);
        obj.value="重新发送(" + countdown + ")";
        countdown--;
    }
    setTimeout(function() {
            settime(obj) }
        ,1000)
    }
    function randomNum(){
    var t='';
    for(var i=0;i<4;i++){
        t+=Math.floor(Math.random()*10);

    }
    global=t;
    alert("手机验证码为"+global);
    return global;
}

    function compare() {
        var clientTelCode = $("#tel_code").val();
        if (clientTelCode != global) {
            alert("验证码输入错误,请在六十秒后重新获取");
            $("#telcodeError").html();
            event.preventDefault();
            return false;
        }
    }
</script>


</head>

<body>
	<input id="basePath" type="hidden" value="<%=basePath%>" />
	<div class="page-container">
		<h1>注册</h1>
		<form  action="<%=basePath%>/user/register" method="post">
			<input type="text" id="telephone" name="telephone" class="telephone"
				placeholder="请输入手机号" pattern="^1(3|4|5|7|8)\d{9}$"
				required="required">
			<input type="password" id="password"
				name="password" class="password" pattern="[A-Za-z0-9]{6,12}"
				required="required" placeholder="请输入密码"> <label class="left">
			<!--验证码部分-->
			  <input type="text" name="tel_code" id="tel_code"
					 placeholder="请输入验证码">
			<input type="button" id="btn2" value="免费获取验证码" onclick="settime(this);randomNum()" >
			<div id="telcodeError" style="display:inline;color:red;"></div>

				<input type="checkbox"
				onclick="if (this.checked) {enable()} else {disable()}"
				class="left mt4" style="margin-right: 20px;" />我已阅读同意
			</label> <a href="#" class="left">《用户注册协议》</a>
			<button id="btnRegister" type="submit"   onclick="compare()" disabled="disabled">注册</button>
			<div id="login-error" style="color: #F00">${requestScope.message}</div>
		</form>
	</div>

	<!-- Javascript -->
	<script src="<%=basePath%>nasa/js/jquery-1.8.2.min.js"></script>
	<script src="<%=basePath%>nasa/js/supersized.3.2.7.min.js"></script>
	<script src="<%=basePath%>nasa/js/supersized-init.js"></script>
	<script src="<%=basePath%>nasa/js/scripts.js"></script>



</body>

</html>


