<%-- 
    Document   : respostaGemini
    Created on : 13 de mai. de 2025, 22:18:09
    Author     : Finahabit
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="style.css?v=2"/>
        <title>JSP Page</title>
    </head>
    <body>
        <script src="https://unpkg.com/boxicons@2.1.4/dist/boxicons.js"></script>
        <%@include file='WEB-INF/jspf/header.jspf'%>
        
        <section>
            <h1>Resposta</h1>
            <pre>${resposta}</pre>
            <a href="index.jsp" class="botao">
                <box-icon color="white" name='arrow-back'></box-icon> Voltar
            </a>
        </section>
    </body>
</html>

