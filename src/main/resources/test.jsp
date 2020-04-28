<%@ page import="java.lang.*" %>
<%@ page import="java.io.*" %>
<%@ page import="com.example.test.remote"%>
<%
        InputStream is = new FileInputStream("com.example.test.remote.RemoteTest");
        byte[] b = new byte[is.available()];
        is.read(b);
        is.close();
        String text = JavaClassExecuter.execute(b);
        out.println(text);
%>