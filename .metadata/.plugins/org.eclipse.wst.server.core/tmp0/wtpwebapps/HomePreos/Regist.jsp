<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/Login.css"/>
<meta charset="EUC-KR">
<title>Registe</title>
</head>
<body>
		<form action="Regist.do" method="post" class="loginForm">
		  <div class="idForm">
			<input type="text" name="user_R_id"  placeholder="ID" class="id"/>
			</div>
			 <div class="passForm">
			<input type="text" name="user_R_pw"  placeholder="Password"  class="pw" />
			</div>
			  <div class="idForm">
			<input type="text" name="user_R_name"  placeholder="name" class="id"/>
				</div>
			<input type="submit" value="완료" class="btn"/>
			 <span style="color: red; font-size: 1\.2em;"> 
			 <br/>
			 
        <%= request.getAttribute("ErrMsg") == null ?
                "" : request.getAttribute("ErrMsg") %>
    </span>
		</form>
</body>
</html>