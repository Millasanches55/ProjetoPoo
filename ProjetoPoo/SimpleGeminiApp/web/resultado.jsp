<%-- 
    Document   : resultado
    Created on : 6 de mai. de 2025, 15:18:53
    Author     : Fatec
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>
<!DOCTYPE html>
<html>
<head>
    <link href="style.css" rel="stylesheet"/>
    <title>Texto Extraído</title>
</head>
<body>
    <script src="https://unpkg.com/boxicons@2.1.4/dist/boxicons.js"></script>
    <%@include file='WEB-INF/jspf/header.jspf'%>
    
    <h2>Conteúdo do PDF:</h2>
    <pre>${sessionScope.texto}</pre>
    <hr>

    <h2>Resumo Gerado:</h2>
    <pre>${sessionScope.resumo}</pre>

    <h2>Flashcards Gerados:</h2>
    <pre>${sessionScope.flashcards}</pre>

    <form action="pergunta-pdf.jsp" method="post">
        <button type="submit">Fazer Pergunta sobre o PDF</button>
    </form>
    <a href="index.jsp" class="botao">
        <box-icon color="white" name='arrow-back'></box-icon> Voltar
    </a>
</body>
</html>

    

















