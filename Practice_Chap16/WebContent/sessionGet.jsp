<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		//지금은 하나하나 Name을 주고 Value를 얻어서 출력하는 경우이다.
		//session의 getAttribute()는 변환타입이 object타입이다.
		//속성값 얻기
		Object obj1 = session.getAttribute("mySessionName");

		//강제 타입 변환
		String mySessionName = (String) obj1;
		out.println("mySessionName : " + mySessionName + "<br>");
		Object obj2 = session.getAttribute("jsh");

		//Integer타입으로 강제 타입 변환
		Integer jsh = (Integer) obj2;
		out.println("jsh : " + jsh + "<br>");

		out.println("==========================================<br><br>");

		String sName;
		String sValue;
		//getAttributeNames()의 반환값은 열거<E> 제네릭타입이다.
		//여기서는 String만 받도록 제네릭타입을 설정하였다.
		//getAttributeNames()은 세션의 모든 Name을 다 얻어오는 것이다.
		Enumeration<String> e = session.getAttributeNames();
		//데이터가 있느냐?
		while (e.hasMoreElements()) {
			sName = e.nextElement(); //있으면 가져와라
			sValue = session.getAttribute(sName).toString();
			out.println("sName : " + sName + "<br>");
			out.println("sValue : " + sValue + "<br>");
		}
		out.println("==========================================<br><br>");
		//sessionID는 웹브라우져 하나당 생기는 유니크한 값이다.
		// 물론 서버에서 생성해준다. 유니크한 sessionInit의 sessionID를 얻는다.
		String sessionID = session.getId();
		out.println("sessionID : " + sessionID + "<br>");
		//session의 유효시간을 얻어 출력해본다.
		//기본값으로 30분이 설정되어 있고 출력해보면 1800초가 찍힐 것이다.
		//web.xml파일을 노트패드로 열어서 session부분의 값을 변경하면 된다.
		int sessionInterval = session.getMaxInactiveInterval();
		out.println("sessionInterval : " + sessionInterval + "<br>");
		out.println("==========================================<br><br>");

		//mySessionName세션의 특정한 값을 삭제함
		session.removeAttribute("mySessonName");
		Enumeration<String> e1 = session.getAttributeNames();

		//session데이터가 jsh만 남아 있을 것이다.
		while (e1.hasMoreElements()) {
			sName = e1.nextElement(); //있으면 가져와라
			sValue = session.getAttribute(sName).toString();
			out.println("sName : " + sName + "<br>");
			out.println("sValue : " + sValue + "<br>");
		}
		out.println("==========================================<br><br>");
		//session의 모든 데이터값을 지운다.
		session.invalidate();
		//유효한 세선id가 있느냐
		if (request.isRequestedSessionIdValid()) {
			out.println("session valid");
		}
		//없으면 출력
		else {
			out.println("session invalid");
		}
	%>
</body>
</html>