<%@ page pageEncoding="UTF-8"
    contentType="text/html;charset=Windows-31J"
    %>

    <%--JSTL 1.1.2 core タグライブラリ--%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>top/wings.</title>
</head>
<body>
    <style>
        #img1{
            height: 50px;
            width: 50px;
        }
    </style>
    <img src="img/bird_densyobato.png" id="img1">
    <h1>wings.</h1>
    入力
    <form method="get">
        <input type="text" placeholder="名前">
        <br>
        <input type="text" placeholder="コメント内容">
        <br>
        <input type="button" name="submit" value="書き込む">
    </form>
    
    出力
    
</body>
</html>