<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>map으로 가져온 데이터 출력</title>
</head>
<body>
	<h3>학생 조회 결과</h3>
	<c:if test="${not empty student}">
	<ul>
		<li>번호:  ${student.STUDENT_NO }</li>
		<li>이름:  ${student.STUDENT_NAME }</li>
		<li>전화번호:  ${student.STUDENT_TEL }</li>
		<li>이메일:  ${student.STUDENT_EMAIL }</li>
		<li>주소:  ${student.STUDENT_ADDR }</li>
		<li>등록일:  ${student.REG_DATE }</li>
	</ul>
	</c:if>
	${students }
</body>
</html>