<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학생 정보 조회</title>
</head>
<body>
	<h2>학생 검색 결과</h2>
	<div>
		<h4>전체 학생 수 : <c:out value="${studentCount }"/></h4>
		
	</div>
	<table>
		<tr>
			<th>학생번호</th>
			<th>이름</th>
			<th>전화번호</th>
			<th>이메일</th>
			<th>주소</th>
			<th>등록일</th>
		</tr>
		
		<tbody>
			<c:if test="${not empty student }">
				<tr>
					<td><c:out value="${student.studentNo }"/></td>
					<td><c:out value="${student.studentName }"/></td>
					<td><c:out value="${student.studentTel }"/></td>
					<td><c:out value="${student.studentEmail }"/></td>
					<td><c:out value="${student.studentAddress }"/></td>
					<td><c:out value="${student.regDate }"/></td>
				</tr>
			</c:if>
			<c:if test="${not empty students }">
			<c:forEach var="s" items="${students }">
				<tr>
					<td><c:out value="${s.studentNo }"/></td>
					<td><c:out value="${s.studentName }"/></td>
					<td><c:out value="${s.studentTel }"/></td>
					<td><c:out value="${s.studentEmail }"/></td>
					<td><c:out value="${s.studentAddress }"/></td>
					<td><c:out value="${s.regDate }"/></td>
				</tr>
			</c:forEach>
			</c:if>
		</tbody>
	</table>
	<div>
		${pageBar }
	</div>
	
	
</body>
</html>