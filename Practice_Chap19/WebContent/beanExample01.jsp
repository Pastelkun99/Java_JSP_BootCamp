<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- JSP액션태그중, useBean을 이용하여 아래와 같이 설정한다.
    id는 자바에서의 참조변수와 같은 역할을 한다고 보면된다. 아울러
    class 속성은 student의 원본 클래스의 경로를 패키지명 포함해서 기술해줘야 한다.
    scope에서 page로 했단 것은 이 페이지에서만 사용하겠다는 것이다.
    이렇게 해주면 자바에서 new연산자로 객체(인스턴스)를 생성한 것과 동일한 개념이 된다. -->
    
    <jsp:useBean id="student" class="sec01_exam.Student" scope="page"></jsp:useBean>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JAVA Bean 예제</title>
</head>
<body>
	<h1>빈에 데이터 값들을 저장하였습니다.</h1><br/>
	
	<!-- 속성에 "*"는 빈 객체의 속성 값을 기본으로 지정하는 것이다. -->
	<jsp:setProperty property="*" name="student"/>
	
	<!-- jsp액션태그중 setProperty를 이용해서 name에는 bean의 id값,
	property는 빈의 속성, value는 신은혁으로 set하고 있다.
	중요한 것은 액션태그인 setProperty가 student클래스의 setter메서드를 호출하는 태그라는 것이다. -->
	
	<jsp:setProperty property="name" name="student" value="신은혁"/>
	<jsp:setProperty property="age" name="student" value="11"/>
	<jsp:setProperty property="grade" name="student" value="4"/>
	<jsp:setProperty property="studentNum" name="student" value="7"/>
	
	<h1>빈에서 가져온 데이터 값들입니다.</h1><br/>
	<!-- jsp액션태그중 getProperty를 이용해서 name에는 bean의 id값, property는 빈의 속성 name에 있는 값 신은혁을 가져온다.
	또한, html태그 중 font태그를 이용해 보기좋게 하였다. size는 글자 크기, face는 글꼴, color는 색깔을 의미한다. -->
	<font size="7" face="" color="blue">
		<!-- 여기서도 역시 getproperty액션태그는 student클래스의 getter를 호출하는 태그이다. -->
		이름 : <jsp:getProperty property="name" name="student"/><br/>
		나이 : <jsp:getProperty property="age" name="student"/><br/>
		학년 : <jsp:getProperty property="grade" name="student"/><br/>
		번호 : <jsp:getProperty property="studentNum" name="student"/><br/>
	</font>
</body>
</html>