<%@ page pageEncoding="UTF-8"
    contentType="text/html;charset=Windows-31J"
    %>

    <%--JSTL 1.1.2 core タグライブラリ--%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        
        <title>スレ</title>
    </head>
    <body>
        <style>
            #img1{
                height: 50px;
                width: 50px;
            }
        </style>
        <img src="img/bird_densyobato.png" id="img1">
        <h1></h1>
        

        出力
        <br>
        <c:forEach var="test" items="${list}">
            ${test.comment_id}<br>
            ${test.name}<br>
            ${test.comment}<br>
            <br>
        </c:forEach>
        <br>
        入力
        <form method="post" action="CommentServlet">
            <input type="text" name="name" placeholder="名前">
            <br>
            <input type="text" name="comment" placeholder="コメント内容">
            <br>
            <input type="submit" value="書き込む">
        </form>

    </body>
</html>