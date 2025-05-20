<%-- 
    Document   : flashcards
    Created on : 6 de mai. de 2025, 14:34:08
    Author     : Fatec
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Flashcards Gerados</title>
        <link rel="stylesheet" href="style.css"/>
    </head>
    <body>
        <script src="https://unpkg.com/boxicons@2.1.4/dist/boxicons.js"></script>
        <%@include file='WEB-INF/jspf/header.jspf'%>
        <section>
            <h2>Flashcards Gerados com IA</h2>
            <pre>${flashcards}</pre>
            <a href="index.jsp" class="botao">
            <box-icon color="white" name='arrow-back'></box-icon> Voltar
            </a>
        </section>
    </body>
</html>
