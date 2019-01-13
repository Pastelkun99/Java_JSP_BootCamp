<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	String pagefile = request.getParameter("page");
	if (pagefile == null) {
		pagefile = "newitem";
	}
%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
table {
	margin: auto;
	width: 1024px;
	height: 768px;
	color: gray;
	border: 2px red;
}
</style>
<meta charset="UTF-8">
<title>templete 테스트</title>
</head>
<body>
	<table border="1">
		<tr>
			<!-- top부분을 표식한다 -->
			<td height="15%" width="20" align="center">쇼핑몰 로고</td>
			<td height="15%" colspan="2" align="right"><jsp:include
					page="top.jsp"></jsp:include></td>
		</tr>

		<tr>
			<!-- left부분을 표식한다 -->
			<td width="20%" align="right" valign="top"><br> <jsp:include
					page="left.jsp"></jsp:include></td>

			<!-- center부분을 표식한다. -->
			<td colspan="2" align="center"><jsp:include
					page='<%=pagefile + ".jsp"%>'></jsp:include></td>
		</tr>

		<tr>
			<!-- bottom부분을 표식한다. -->
			<td width="100%" height="10%" colspan="3" align="center"><jsp:include
					page="bottom.jsp"></jsp:include></td>
		</tr>


	</table>
</body>
</html>