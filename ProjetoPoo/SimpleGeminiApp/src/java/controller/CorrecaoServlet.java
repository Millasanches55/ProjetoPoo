/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

// Importações necessárias
import com.google.gson.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;

 // Chave de API da Gemini (Google AI Studio)
public class CorrecaoServlet extends HttpServlet {
    private static final String API_KEY = "AIzaSyA-xNbUAj18cLFGuowbMvPpAy88IXeE_os";  

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
// Obtém o texto da redação enviado pelo formulário HTML
        String textoRedacao = request.getParameter("textoRedacao");
        
 // Chama o método que envia o texto para a API do Gemini e recebe a resposta
        String correcaoRedacao = chamarGemini(textoRedacao);
        
    // Armazena a resposta no request para ser acessada no JSP
        request.setAttribute("correcao", correcaoRedacao);
        // Encaminha a requisição para a página resultadoCorrecao.jsp
        request.getRequestDispatcher("resultadoCorrecao.jsp").forward(request, response);
    }
// Método que se comunica com a API do Gemini e retorna a correção da redação
    private String chamarGemini(String textoRedacao) throws IOException {
       // Cria a URL com API do Gemini
        URL url = new URL("https://generativelanguage.googleapis.com/v1beta/models/gemini-2.0-flash:generateContent?key=" + API_KEY);
        
       // Abre uma conexão HTTP
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setDoOutput(true); // Indica que haverá envio de dados no corpo (POST)
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", "application/json"); // Define tipo de dado enviado

        JsonObject requestBody = new JsonObject();
        JsonArray contents = new JsonArray();
        
      // A mensagem de instrução que será enviada à IA
        JsonObject part = new JsonObject();
        part.addProperty("text", "Corrija e comente a seguinte redação, indicando erros e explicando melhorias: " + textoRedacao);
        
        JsonObject content = new JsonObject();
        content.add("parts", new JsonArray());
        content.getAsJsonArray("parts").add(part);
        contents.add(content); // Adiciona o conteúdo completo à lista
        requestBody.add("contents", contents);

        // Envia o corpo da requisição para a API
        try (OutputStream os = conn.getOutputStream()) {
            byte[] input = requestBody.toString().getBytes(StandardCharsets.UTF_8);
            os.write(input, 0, input.length);
        }

        // Lê e processa a resposta da API
        try (BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), StandardCharsets.UTF_8))) {
            JsonObject responseJson = JsonParser.parseReader(br).getAsJsonObject();
            // Extrai o texto da resposta JSON
            String resposta = responseJson
                .getAsJsonArray("candidates")
                .get(0).getAsJsonObject()
                .getAsJsonObject("content")
                .getAsJsonArray("parts")
                .get(0).getAsJsonObject()
                .get("text").getAsString();
            // Retorna a resposta textual (correção da redação)
            return resposta;
        }
    }
}
