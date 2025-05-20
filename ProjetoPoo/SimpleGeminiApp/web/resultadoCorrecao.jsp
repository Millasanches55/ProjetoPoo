<%-- 
    Document   : resultadoCorrecao
    Created on : 6 de mai. de 2025, 15:26:17
    Author     : Fatec
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="style.css?v=2"/>
        <title>Resultado da Correção</title>
    </head>
    <body>
        <script src="https://unpkg.com/boxicons@2.1.4/dist/boxicons.js"></script>
        <%@include file='WEB-INF/jspf/header.jspf'%>
        
        <section>
            <h1>Correção da sua Redação</h1>
            <pre>${correcao}</pre>
            <br>
            <a href="index.jsp" class="botao">
                <box-icon color="white" name='arrow-back'></box-icon> Voltar
            </a>
        </section>
    </body>
</html>


