<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新規書籍追加</title>
</head>
<body>
<h1>書籍を追加</h1>
<form action="newbook" method = "POST">
<label for = janCd>janコード</label>
<input type = "text" id="janCd" name = "janCd"><br>

<label for = isbnCd>isbnコード</label>
<input type = "text" id="isbnCd" name = "isbnCd"><br>

<label for = bookNm>書籍名</label>
<input type = "text" id="bookNm" name = "bookNm"><br>

<label for = bookKana>書籍名フリガナ</label>
<input type = "text" id="bookKana" name = "bookKana"><br>

<label for = price>価格</label>
<input type = "text" id="price" name = "price"><br>




<input type = "submit" value = "保存">
<p><a href="ListServlet">戻る</a></p>
</form>
</body>
</html>