/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import service.PdfExtractor;
import service.ResumoService;
import service.FlashcardService;
import javax.servlet.*;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.*;

import java.io.*;

@MultipartConfig
public class UploadServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Obtém o arquivo PDF enviado pelo formulário
        Part filePart = request.getPart("arquivo");
        // Cria um arquivo temporário para armazenar o upload
        File tempFile = File.createTempFile("upload", ".pdf");

        
        // Copia o conteúdo do arquivo enviado para o arquivo temporário
        try (InputStream input = filePart.getInputStream(); FileOutputStream output = new FileOutputStream(tempFile)) {
    byte[] buffer = new byte[1024];
    int bytesRead;
    while ((bytesRead = input.read(buffer)) != -1) {
        output.write(buffer, 0, bytesRead);
    }
}


       // Extrai o texto do PDF utilizando a classe de serviço PdfExtractor
        String textoExtraido = PdfExtractor.extrairTexto(tempFile);

      // Gera um resumo do texto com IA
        String resumoGerado = ResumoService.gerarResumo(textoExtraido);

       // Gera flashcards a partir do texto
        String flashcardsGerados = FlashcardService.gerarFlashcards(textoExtraido);

       // Armazena os resultados
        request.getSession().setAttribute("texto", textoExtraido);
request.getSession().setAttribute("resumo", resumoGerado);
request.getSession().setAttribute("flashcards", flashcardsGerados);
request.getSession().setAttribute("conteudoPDF", textoExtraido);

        

      request.getSession().setAttribute("conteudoPDF", textoExtraido);

      // Encaminha para a página de resultado
        request.getRequestDispatcher("resultado.jsp").forward(request, response);
    }
}