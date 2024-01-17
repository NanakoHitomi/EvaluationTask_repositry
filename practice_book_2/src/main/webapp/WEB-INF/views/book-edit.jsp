<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.bean.BookBean" %>
<%@ page import="java.util.Date" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>書籍更新</title>
</head>
<body>
<h1>書籍更新</h1>



<form action = "BookEditServlet" method = "post">

<%
    BookBean book = (BookBean)request.getAttribute("book");
%>

<label>JANコード：</label><input type="text" name="janCd" value="<%=book.getJanCd() %>"><br>
	
	<label>ISBNコード:</label><input type="text" name="isbnCd" value="<%=book.getIsbnCd() %>"><br>
	
	<label>書籍名:</label><input type="text" name="bookNm" value="<%=book.getBookNm() %>"><br>
	
	<label>フリガナ:</label><input type="text" name="bookKana" value="<%=book.getBookKana() %>"><br>
	
	<label>価格:</label><input type="text" name="price" value="<%=book.getPrice() %>"><br>
	
	<label>発行日:</label><%=book.getIssueDate() %><br>
	
	<button type="submit">更新する</button>
	 <button class="btn"><a href="BookDeleteServlet?janCd=<%= book.getJanCd() %>">削除</a></button>
	<p><a href="ListServlet">戻る</a></p>
</form>

</body>
</html>