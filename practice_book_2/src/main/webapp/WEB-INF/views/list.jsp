<%@page import="model.bean.BookBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>書籍一覧</title>
</head>
<body>
<h1>書籍一覧</h1>

<span><strong>JANコード</strong></span>
	<span><strong>書籍名</strong></span></br>
	
<%
List<BookBean> list = (List<BookBean>)request.getAttribute("bookList");
for(BookBean book : list) {
%>

<span><%= book.getJanCd() %></span>
	<span><a href='BookEditServlet?janCd=<%= book.getJanCd() %>'><%= book.getBookNm() %></a></span><br>
	
<% } %>

<p><a href="newbook">新規書籍</a></p>
</body>
</html>