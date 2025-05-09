/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import service.PdfExtractor;
import service.ResumoService;
import service.FlashcardService;
import jakarta.servlet.*;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.*;

import java.io.*;

@MultipartConfig
public class UploadServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Part filePart = request.getPart("arquivo");
        File tempFile = File.createTempFile("upload", ".pdf");

        try (InputStream input = filePart.getInputStream(); FileOutputStream output = new FileOutputStream(tempFile)) {
            input.transferTo(output);
        }

       
        String textoExtraido = PdfExtractor.extrairTexto(tempFile);

   
        String resumoGerado = ResumoService.gerarResumo(textoExtraido);

       
        String flashcardsGerados = FlashcardService.gerarFlashcards(textoExtraido);

    
        request.setAttribute("texto", textoExtraido);
        request.setAttribute("resumo", resumoGerado);
        request.setAttribute("flashcards", flashcardsGerados);

      
        request.getRequestDispatcher("resultado.jsp").forward(request, response);
    }
}