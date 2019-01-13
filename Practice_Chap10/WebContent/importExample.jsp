<!-- 페이지 지시자로 속성들을 지시하고 있다. jsp를 지원하는 언어는 현존하는 언어 중 자바밖에 없다. -->
<%-- 페이지 지시자의 형식 : <%@ page 속성1="값1", 속성2="값2" ... %> --%>
<!-- 
속성의 종류와 사용법 									기본값 					설명
- language				, language="java"				java					스크립트 요소에서 사용할 언어 설정
- extends				, extends="클래스명"			없음					상속받을 클래스를 설정
- import 				, import="패키지.클래스명" 		없음					import할 패키지.클래스 설정
- session 				, session="true"				true					HttpSession 사용 여부를 설정
- buffer 				, buffer="16kb"					8kb						JSP페이지의 출력버퍼크기 설정
- autoFlush				, autoflush="true"				true					출력 버퍼가 다 찼을 경우 처리방법 설정
- isThreadSafe			, isThreadSafe="true"			true					다중 스레드 동시 실행 여부를 설정
- info					, info="페이지 설명"			없음					페이지 설명
- errorPage 			, errorPage="에러페이지.jsp"	없음					에러 페이지로 사용할 페이지 설정
- contentType			, contentType="text/html"		ISO-8859-1				JSP페이지가 생성할 문서의 타입 설정
- isErrorPage			, isErrorPage="false"			false					현재 페이지를 에러 페이지로 지정할지 설정
- pageEncoding			, pageEncoding="UTF-8"			ISO-8859-1				현재 페이지의 문자 인코딩 타입 설정
 -->

<!-- 페이지 지시자를 주목하고 import 속성도 잘 확인해보자. -->
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>import 속성 테스트</title>
</head>
<body>
	<h1>현재 시간은 <%=new SimpleDateFormat().format(new Date()) %>입니다.</h1>
</body>
</html>