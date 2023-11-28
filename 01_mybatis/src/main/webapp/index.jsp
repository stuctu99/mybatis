<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>연결 확인</h2>
	<h3><a href="${path }/connecttest.do">DB연결</a></h3>
	<h2>mybatis활용하기</h2>
	<h3>
		<a href="${path }/student/insertStudent.do">
			학생 추가
		</a>
	</h3>
	<h2>이름을 입력받아 저장하기</h2>
	
	<form action="${path }/student/insertName.do">
		<input type="text" name="name"/>
		<input type="submit" value="학생저장"/>
	</form>
	
	<h3>학생 전체 데이터를 입력받아 저장하는 기능 구현</h3>
	<!-- /student/insertStudentObject.do	 -->
	
	<form action="${path }/student/insertStudentObject.do">
		이름
		<input type="text" name="name">
		전화번호
		<input type="text" name="phone">
		이메일
		<input type="text" name="email">
		주소
		<input type="text" name="address">
		<input type="submit" value="학생저장"/>
	</form>
	
	<h3>학생 수정하기</h3>
	<!-- student/updateStudent.do -->
	<form action="${path }/student/updateStudent.do">
		학생 번호
		<input type="text" name="studentNo">
		수정할 이름
		<input type="text" name="name">
		수정할 번호
		<input type="text" name="phone">
		<input type="submit" value="학생수정"/>
	</form>
	
	
	<h3>학생 정보 삭제하기</h3>
	<!-- student/deleteStudent.do -->
	<form action="${path }/student/deleteStudent.do">
		학생 번호
		<input type="text" name="studentNo">
			<input type="submit" value="학생삭제"/>
	</form>
</body>
</html>