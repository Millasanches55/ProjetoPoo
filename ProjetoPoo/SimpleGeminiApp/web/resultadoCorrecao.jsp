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
        <link rel="stylesheet" href="style.css"/>
        <title>Resultado da Correção</title>
    </head>
    <body>
        <section>
            <h1>Correção da sua Redação</h1>
            <pre style="white-space: pre-wrap; background-color: #f4f4f4; padding: 1em; border-radius: 8px;">${correcao}</pre>
            <br>
            <a href="index.jsp" style="display: inline-block; margin-top: 20px; text-decoration: none; background-color: #007BFF; color: white; padding: 10px 15px; border-radius: 5px;">Voltar e enviar outra redação</a>
        </section>
    </body>
</html>

