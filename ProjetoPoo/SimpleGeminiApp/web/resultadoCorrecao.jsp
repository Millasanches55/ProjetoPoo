<%-- 
    Document   : resultadoCorrecao
    Created on : 6 de mai. de 2025, 15:26:17
    Author     : Fatec
--%>
<%@include file="WEB-INF/jspf/menu.jspf" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Resultado da Correção</title>
</head>
<body>
    <h2>Correção da sua Redação:</h2>
    <pre>${correcao}</pre>
    <br><br>
    <a href="index.jsp">Voltar e enviar outra redação</a>
</body>
</html>
