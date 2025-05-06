<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Gemini IA Pergunta</title>
</head>
<body>
    <h3>Escolha uma opção:</h3>
    <ul>
        <li><a href="upload.jsp">Enviar PDF para resumo e criação de flashcards</a></li>
        <!-- Você pode adicionar mais links aqui no futuro -->
    </ul>
    
    <h2>Faça uma pergunta para a IA:</h2>
    <form action="GeminiServlet" method="post">
        <input type="text" name="pergunta" placeholder="Faça sua pergunta" required />
        <button type="submit">Perguntar</button>
    </form>
    
    <hr>
    
    <h2>Enviar Redação para Correção</h2>
    <form action="CorrecaoServlet" method="post">
        <textarea name="textoRedacao" rows="10" cols="50" placeholder="Cole sua redação aqui..."></textarea><br><br>
        <input type="submit" value="Corrigir Redação">
    </form>
    
</body>
</html>