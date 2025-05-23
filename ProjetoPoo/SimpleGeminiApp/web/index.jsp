<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Gemini IA Pergunta</title>
    <link rel="stylesheet" href="style.css?v=2"/>
</head>
<body>
    
    <%@include file='WEB-INF/jspf/header.jspf'%>
     
    <section>
        <h2>Olá, bem-vindo! &#128075</h2>
        
        <div id='pergunta-redacao-index'>
            <div>
                <h3>Faça uma pergunta para a IA:</h3>
                <form action="GeminiServlet" method="post" class="form-index">
                    <textarea name="pergunta" rows="10" cols="50" placeholder="Faça sua pergunta..." required></textarea><br><br>
                    <input type="submit" value="Perguntar" class="botao">
                </form>
            </div>
            
            <hr>
            
            <div>
                <h3>Envie uma Redação para Correção:</h3>
                <form action="CorrecaoServlet" method="post" class="form-index">
                    <textarea name="textoRedacao" rows="10" cols="50" placeholder="Cole sua redação aqui..." required></textarea><br><br>
                    <input type="submit" value="Corrigir Redação" class="botao">
                </form>
            </div>
        </div>
        <h3>Envie um PDF</h3>
        <div id='opcoes-index'>
            <a class="botao" style="margin: auto;" href="upload.jsp">Enviar PDF para resumo e criação de flashcards</a>
            <!-- Você pode adicionar mais links aqui no futuro -->
        </div>
    </section>
</body>
</html>
