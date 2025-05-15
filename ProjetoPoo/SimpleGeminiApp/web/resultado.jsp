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
<form action="PerguntaPdfServlet" method="post">
    <input type="hidden" name="texto" value="${texto}">
    <input type="text" name="pergunta" placeholder="Digite sua pergunta..." required style="width: 60%;">
    <button type="submit" class="botao">Perguntar</button>
</form>

<c:if test="${not empty respostaPergunta}">
    <hr>
    <h2>Resposta da IA:</h2>
    <pre>${respostaPergunta}</pre>
</c:if>

