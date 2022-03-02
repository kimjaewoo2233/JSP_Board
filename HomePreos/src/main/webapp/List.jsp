<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/table.css"/>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% request.setCharacterEncoding("utf-8"); %>
	<form bethod="get">
	<table  width="90%" class="tableC" align="center";>
		<tr>
		<td align="center">
			<select name="searchField">
				<option value="title">제목</option>
				<option value="content">내용</option>
			</select>
			<input type="text" name="searchWord"/>
			<input type="submit" value="검색하기"/>
		</td>
		</tr>
	</table>
	</form>
	 <table  width="90%" class="tableC" align="center";>
        <tr >
            <th width="10%">
            번호
            </th>
            <th width="*" align="center">제목</th>
            <th width="15%">작성자</th>
            <th width="10%">조회수</th>
            <th width="15%">작성일</th>
            <th width="8%">첨부</th>
        </tr>
        <c:choose>
        	<c:when test="${ empty boardLists }">
        		<tr class="row">
        			<td colspan="6" align="center">
        				등록된 게시물이 없습니다.
        			</td>
        		</tr>
        	</c:when>
        	<c:otherwise>
        		<c:forEach items="${boardLists}" var="row" varStatus="loop">
        			<tr align="center"  class="row">
        				<td align="center">
        						${loop.count }
        				</td>
        				<td>
        								<a href="./view.do?idx=${row.idx }">
    									 ${ row.title }
      									 </a>
        				</td>
        				 <td>${ row.name }</td>  <!-- 작성자 -->
    				     <td>${ row.visitcount }</td>  <!-- 조회수 -->
     				     <td>${ row.postdate }</td>  <!-- 작성일 -->
        				<td>
        					<c:if test="${ not empty row.ofile }">
        						<a href="./download.do?ofile=${ row.ofile }&sfile=${row.sfile}&idx=${ row.idx }">[Down]</a>
        					</c:if>
        				</td>
        			</tr>
        		</c:forEach>
        	</c:otherwise>
        </c:choose>
        </table>
		<c:if test="${ not empty user_id }">
			        
			        
			        <table width="90%" class="tableCe" align="center";>
			        	<tr align="center">
			        		<td>
			        			<button type="button" class="btn" onclick="location.href='./write.do';">글쓰기</button>
			        			
			        		</td>
			        	</tr>
			        </table>
		</c:if>
</body>
</html>