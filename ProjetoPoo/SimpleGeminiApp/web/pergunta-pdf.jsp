<%-- 
    Document   : pergunta-pdf
    Created on : 16 de mai. de 2025, 12:45:01
    Author     : milla195
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>
<!DOCTYPE html>
<html>
<head>
    <title>Perguntar sobre PDF</title>
    <link rel="stylesheet" href="style.css"/>
</head>
<body>
    <h2>Faça uma pergunta sobre o conteúdo do PDF</h2>

    <form action="PerguntaPDFServlet" method="post">
        <label for="pergunta">Pergunta:</label><br>
        <input type="text" id="pergunta" name="pergunta" size="80" required><br><br>
        <button type="submit">Enviar</button>
    </form>

    <br/>

    <c:if test="${not empty respostaPDF}">
        <h3>Resposta da IA:</h3>
        <p>${respostaPDF}</p>
    </c:if>

    <br/>
    <a href="resultado.jsp">Voltar</a>
</body>
</html>
