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
	
	<h2>DB에 저장된 데이터 조회하기</h2>
	<p>SELECT문으로 가져온 데이터를 DTO객체에 저장시켜서 반환</p>
	<p>mybatis : SELECT문의 결과를 지정한 객체에 저장해서 반환</p>
	
	<h3>저장된 학생 수 조회</h3>
	<h4>
		<a href="${path }/student/studentCount.do">
			학생 수 조회
		</a>
	</h4>	
	<h3>학생 번호로 조회</h3>
	<form action="${path }/student/searchNo.do">
		<input type="number" name="no"/>
		<input type="submit" value="검색">
	</form>
	
	<h3>저장된 전체 학생 조회</h3>
	<h4>
		<a href="${path }/student/searchAll.do">
			전체 학생 조회
		</a>
	</h4>
	<h3>이름으로 학생 조회</h3>
	<form action="${path }/student/searchByName.do">
		<input type="text" name="name"/>
		<input type="submit" value="검색">
	</form>
	
	<h3>DTO를 생성하지 않고 데이터 가져와 출력하기</h3>
	<p>Map클래스를 이용해서 데이터를 가져올 수 있다.</p>
	<h4>
		<a href="${path }/student/searchByNoMap.do?no=1">
			1번 학생 조회
		</a>
	</h4>
	<h4>
		<a href="${path }/student/searchAllMap.do">
			Map 전체 학생 조회
		</a>
	</h4>
	<h5>
		Map으로 insert
	</h5>
	<form action="${path }/student/insertMap.do">
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
		
	<h3>mybatis에서 페이징 처리하기</h3>
	<h4>
		<a href="${path }/student/pageStudent.do">
			페이징 처리하기
		</a>
	</h4>
	
	
</body>
</html>