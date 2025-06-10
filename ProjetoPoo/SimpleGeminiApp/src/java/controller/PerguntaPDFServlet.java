/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;
import service.GeminiClient;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/PerguntaPDFServlet")
public class PerguntaPDFServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        // Obtém o conteúdo do PDF previamente armazenado na sessão
        String conteudoPDF = (String) session.getAttribute("conteudoPDF");
        
        // Captura a pergunta enviada pelo formulário
        String pergunta = request.getParameter("pergunta");

        String resposta = "Não foi possível gerar resposta.";

        if (conteudoPDF != null && pergunta != null && !pergunta.trim().isEmpty()) {
            // Monta o prompt combinando conteúdo do PDF + pergunta do usuário
            String prompt = "Com base no seguinte conteúdo do PDF:\n\n" + conteudoPDF +
                            "\n\nResponda à pergunta:\n" + pergunta;
            resposta = GeminiClient.enviarPrompt(prompt); // Envia o prompt para o serviço da IA (classe GeminiClient)
        }

        request.setAttribute("respostaPDF", resposta); // Define a resposta como atributo para ser exibido na JSP
        request.getRequestDispatcher("pergunta-pdf.jsp").forward(request, response); // Encaminha para a página que exibirá a resposta
    }
}
