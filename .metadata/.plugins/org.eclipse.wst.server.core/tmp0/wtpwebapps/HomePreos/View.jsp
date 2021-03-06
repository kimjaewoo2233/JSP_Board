<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://unpkg.com/swiper@6.8.4/swiper-bundle.min.css" />
</head>
<body>
		<table border="1" width="90%">
			<colgroup>
				<col width="15%"/><col width="35%"/>
				<col width="15%"/><col width="*"/>
			</colgroup>
			<tr>
				<td>번호</td><td>${ dto.idx }</td>
				<td>작성자</td><td>${dto.name }</td>
			</tr>
			<tr>
				<td>작성자</td><td>${dto.postdate }</td>
				<td>조회수</td><td>${dto.visitcount }</td>
			</tr>
			<tr>
				<td>제목</td>
				<td colspan="3">${dto.visitcount }</td>
			</tr>
			<tr>
				<td>내용</td>
				<td colspan="3" height="100">${dto.content }</td>
			</tr>
			
			<!-- 첨부 파일 -->
			<tr>
				<td>첨붚파일</td>
				<td>
					<c:if test="${ not empty dto.ofile }">
							<a href="/HomePreos/dowload.do?ofile=${dto.ofile }&sfile=${dto.sfile}&idx=${dto.idx}">${dto.ofile }</a>
					</c:if>
				</td>
				<td>다운로드 수</td>
				<td>${dto.downcount }</td>
			</tr>
			
			<tr>
				<td	colspan="4" align="center">
					<button type="button">수정하기(기능넣어야함)</button>
						<button type="button">수정하기(기능넣어야함)</button>
							<button type="button">수정하기(기능넣어야함)</button>
				</td>
			</tr>
			
		</table>
		

</body>
</html>