<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LoginPage</title>
<link rel="stylesheet" type="text/css" href="css/Login.css"/>
<script>
function validateForm(form){
	if(!form.use_id.value){
		alert("아이디를 입력하세요");
		return false;
	}
	if(form.user_pw.value){
		alert("패스워드를 입력하세요")
		return false;
	}
}

</script>
<!--브라우저 스타일 초기화-->
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/reset-css@5.0.1/reset.min.css" />
  <!--Google Fonts - 나눔고딕-->
  <link rel="preconnect" href="https://fonts.gstatic.com" />
  <link href="https://fonts.googleapis.com/css2?family=Nanum+Gothic:wght@400;700&display=swap" rel="stylesheet" />
</head>
<body>
	<jsp:include  page="./Link.jsp"/>
	 <section class="notice">
	<c:choose>
		<c:when test="${empty user_id }">
			<form action="LoginProcess.do" method="post" name="loginFrm"
				onsubmit = "return validateForm(this)" class="loginForm">
					<div class="idForm">
			 <input type="text" name="user_id"  class="id" placeholder="Id"/>
					</div>
					<div class="passForm">
			<input type="text" name="user_pw" class="pw" placeholder="passward"/>
					</div>
				<input type="submit" value="로그인" class="btn"/>
			<div class="bottomText">
		        Don't you have ID? <a href="./Regist.jsp">sign up</a>
		      </div>
			</form>
		</c:when>
		<c:otherwise>
			${user_name} 님 반갑습니다.
			<a href="/HomePreos/List.do">게시판 보러가기</a>
		</c:otherwise>
	</c:choose>
		 <span style="color: red; font-size: 1\.2em;"> 
        <%= request.getAttribute("LoginErrMsg") == null ?
                "" : request.getAttribute("LoginErrMsg") %>
    </span>
   
	<!-- 		<div class="promotion">
				<div class="swiper-wrapper">
					<div class="swiper-slide">
						<img src="./image/slide.jpg" alt="test"/>
						<a href="javascript:void(0)" class="btnr">자세히보기</a>
					</div>
					<div class="swiper-slide">
						<img src="../images/slide.png" alt="test"/>
						<a href="javascript:void(0)" class="btnr">자세히보기</a>
					</div>
					<div class="swiper-slide">
						<img src="./images/slide.png" alt="test"/>
						<a href="javascript:void(0)" class="btnr">자세히보기</a>
					</div>
					<div class="swiper-slide">
						<img src="./images/slide.png" alt="test"/>
						<a href="javascript:void(0)" class="btnr">자세히보기</a>
					</div>
					<div class="swiper-slide">
						<img src="../images/slide.png" alt="test"/>
						<a href="javascript:void(0)" class="btnr">자세히보기</a>
					</div>
				</div>
			</div>  -->
		</section>
</body>
</html>