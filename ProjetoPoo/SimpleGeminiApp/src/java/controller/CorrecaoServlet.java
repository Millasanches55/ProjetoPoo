/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import com.google.gson.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;


public class CorrecaoServlet extends HttpServlet {
    private static final String API_KEY = "AIzaSyA-xNbUAj18cLFGuowbMvPpAy88IXeE_os";  

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String textoRedacao = request.getParameter("textoRedacao");
        

        String correcaoRedacao = chamarGemini(textoRedacao);
        
    
        request.setAttribute("correcao", correcaoRedacao);
        request.getRequestDispatcher("resultadoCorrecao.jsp").forward(request, response);
    }

    private String chamarGemini(String textoRedacao) throws IOException {
       
        URL url = new URL("https://generativelanguage.googleapis.com/v1beta/models/gemini-2.0-flash:generateContent?key=" + API_KEY);
        
       
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setDoOutput(true);
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", "application/json");

        JsonObject requestBody = new JsonObject();
        JsonArray contents = new JsonArray();
        
      
        JsonObject part = new JsonObject();
        part.addProperty("text", "Corrija e comente a seguinte redação, indicando erros e explicando melhorias: " + textoRedacao);
        
        JsonObject content = new JsonObject();
        content.add("parts", new JsonArray());
        content.getAsJsonArray("parts").add(part);
        contents.add(content);
        requestBody.add("contents", contents);

        try (OutputStream os = conn.getOutputStream()) {
            byte[] input = requestBody.toString().getBytes(StandardCharsets.UTF_8);
            os.write(input, 0, input.length);
        }

        try (BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), StandardCharsets.UTF_8))) {
            JsonObject responseJson = JsonParser.parseReader(br).getAsJsonObject();
            String resposta = responseJson
                .getAsJsonArray("candidates")
                .get(0).getAsJsonObject()
                .getAsJsonObject("content")
                .getAsJsonArray("parts")
                .get(0).getAsJsonObject()
                .get("text").getAsString();
            return resposta;
        }
    }
}
