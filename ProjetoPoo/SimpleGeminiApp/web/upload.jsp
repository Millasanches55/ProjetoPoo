<%-- 
    Document   : upload
    Created on : 6 de mai. de 2025, 15:19:15
    Author     : Fatec
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="style.css?v=2"/>
        <title>Upload de PDF</title>
    </head>
    <body>
        <script src="https://unpkg.com/boxicons@2.1.4/dist/boxicons.js"></script>
        <%@include file='WEB-INF/jspf/header.jspf'%>
        
        <section id="section-upload">
            <br>
            <a href="index.jsp" class="botao">
                <box-icon color="white" name='arrow-back'></box-icon> Voltar
            </a>
            
            
            <h2>Enviar PDF para Extração de Texto</h2>
            <form action="UploadServlet" method="post" enctype="multipart/form-data">
                <input type="file" name="arquivo" accept=".pdf" required />
                <input class="botao" type="submit" value="Enviar">
            </form>
        </section>
        <script src="https://unpkg.com/boxicons@2.1.4/dist/boxicons.js"></script>
    </body>
</html>

