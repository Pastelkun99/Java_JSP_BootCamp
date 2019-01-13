<%@page import="java.net.URLEncoder"%>
<%@page import="java.io.FileInputStream"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%
 	// 클라이언트에서 다운로드를 클릭한 파일의 이름을 얻고 있다.
 	String fileName = request.getParameter("file_name");
 	String savePath = "upload";	// 서버에 파일이 업로드된 폴더명을 지정
 	// getServletContext()는 아파치 서버에 다운로드 받을 곳의 실제 주소를 리턴함
 	ServletContext context = getServletContext();
 	System.out.println("context : " + context);
 	
 	// upload폴더의 실제 물리적인 경로를 얻어오는 부분이다.
 	String sDownloadPath = context.getRealPath(savePath);
 	System.out.println("sDownloadPath : " + sDownloadPath);
 	String sFilePath = sDownloadPath + "\\" + fileName;
 	System.out.println("다운로드 받을 파일이 있는 물리적인 주소 : " + sFilePath);
 	
 	// 다운로드 받을 byte[]생성하고 FileInputStream객체를 얻고 있다.
 	byte b[] = new byte[4096];
 	FileInputStream in = new FileInputStream(sFilePath);
 	
 	/* 여기서 아파치 서버에서 다운로드 한 파일의 확장자들은 브라우저가 무엇인지 모른다.
 	마임타입이라는 것은 클라이언트에게 전송되는 문서의 다양성을 알려주기 위한 메커니즘인데,
 	확장자는 별 의미가 없다. 따라서 각 문서와 함께 올바른 MIME타입을 전송하도록 서버가 정확히
 	설정해주는 것이 필요하다. 브라우저들은 리소스를 내려받을때 해야 할 기본동작이 무엇인지 결정하기 위해
 	대개 이 MIME타입을 사용한다.
 	MIME타입은 대소문자를 구분하지는 않으나 전통적으로 소문자로 사용한다.
 	아래는 개별 MIME타입을 의미한다. 참고하도록 하자.
 	https://developer.mozilla.org/en-US/docs/Web/HTTP/Basics_of_HTTP/MIME_types/Complete_list_of_MIME_types */
 	
 	// 요약
 	
 		/* text/plain, text/html : 텍스트를 포함하는 모든 문서를 나타내며 이론상으로는 인간이 읽을 수 있어야 한다.
 		image/jpeg, image/png : 모든 종류의 이미지를 나타낸다. (animated gif) 애니메이션되는 이미지가 이미지 타입에 포함되나,
 								비디오 타입은 아니다.
 		audio/mpeg, audio/ogg, audio/* : 모든 종류의 오디오 파일들을 나타낸다.
 		application/octet-stream : 모든 종류의 이진 데이터를 나타낸다. */
 		
 	String sMimeType = getServletContext().getMimeType(sFilePath);
 	System.out.println("getServletContext : " + getServletContext().toString());
 	System.out.println("sMimeType >>> " + sMimeType);
 	if(sMimeType == null) {
 		sMimeType = "application/octet-stream";
 	}
 	
 	// 응답할떄 contexttype을 위에서 얻은 mimetype을 지정한다.
 	response.setContentType(sMimeType);
 	
 	// 클라이언트가 요청한 브라우저가 인터넷 익스플로러인지 아닌지 확인함
 	String agent = request.getHeader("User-Agent");
 	boolean ieBrowser = (agent.indexOf("MSIE") > -1) || (agent.indexOf("Trident") > -1);
 	// 인터넷 익스플로저면
 	if(ieBrowser) {
 		fileName = URLEncoder.encode(fileName, "UTF-8");
 	}
 	// 다른 브라우저라면
 	else {
 		fileName = new String(fileName.getBytes("UTF-8"));
 	}
 	
 	// 응답할때 header정보에 content-disposition을 attachment로 설정해야
 	// 모든 파일에 대해서 다운로드 박스가 실행된다.
 	response.setHeader("Content-Disposition", "attachment; filename=" + fileName);
 	
 	// 내장 객체인 out이 존재하므로 out2로 출력 스트림을 얻는다.
 	ServletOutputStream out2 = response.getOutputStream();
 	int numRead;
 	// 다운로드할 파일을 읽어서 출력하고 있다.
 	while((numRead = in.read(b, 0, b.length)) != -1) {
 		out2.write(b, 0, numRead);
 	}
 	out2.flush();
 	out2.close();
 	in.close();
 	%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>