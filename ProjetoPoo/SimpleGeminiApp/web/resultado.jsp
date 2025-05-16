<%-- 
    Document   : resultado
    Created on : 6 de mai. de 2025, 15:18:53
    Author     : Fatec
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Texto Extraído</title>
    </head>
    <body>
         <h2>Conteúdo do PDF:</h2>
    <pre>${texto}</pre>
   <hr>
    
    <h2>Resumo Gerado:</h2>
    <pre>${resumo}</pre>
    
    <h2>Flashcards Gerados:</h2>
<pre>${flashcards}</pre>
</body>
</html>
<hr>
<h2>Faça uma pergunta sobre o conteúdo do PDF:</h2>
<form action="GeminiServlet" method="post">
    <input type="hidden" name="textoPdf" value="${texto}">
    <input type="text" name="perguntaSobrePdf" placeholder="Digite sua pergunta..." style="width: 60%;" required>
    <button type="submit">Perguntar</button>
</form>

<% if (request.getAttribute("resposta") != null) { %>
    <hr>
    <h2>Resposta da IA:</h2>
    <pre><%= request.getAttribute("resposta") %></pre>
<% } %>







