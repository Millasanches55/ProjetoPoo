<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Gemini IA Pergunta</title>
    <link rel="stylesheet" href="style.css"/>
</head>
<body>
    
    <header>
        <h1>Resumos, Respostas e Correções com o Gemini</h1>
    </header>
    
    <hr>
    
    <section id='conteudo-index'>
        <h2>Olá, bem-vindo!</h2>
        
        <div id='pergunta-redacao-index'>
            <div>
                <h3>Faça uma pergunta para a IA:</h3>
                <form action="GeminiServlet" method="post">
                    <textarea name="pergunta" rows="10" cols="50" placeholder="Faça sua pergunta..." required></textarea><br><br>
                    <button type="submit">Perguntar</button>
                </form>
            </div>
            
            <hr>
            
            <div>
                <h3>Envie uma Redação para Correção:</h3>
                <form action="CorrecaoServlet" method="post">
                    <textarea name="textoRedacao" rows="10" cols="50" placeholder="Cole sua redação aqui..."></textarea><br><br>
                    <input type="submit" value="Corrigir Redação">
                </form>
            </div>
        </div>
        <h3>Ou escolha uma opção:</h3>
        <div id='opcoes-index'>
            <a href="upload.jsp">Enviar PDF para resumo e criação de flashcards</a>
            <!-- Você pode adicionar mais links aqui no futuro -->
        </div>
    </section>
</body>
</html>