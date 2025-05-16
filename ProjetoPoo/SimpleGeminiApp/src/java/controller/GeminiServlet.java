package controller;

import com.google.gson.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;

public class GeminiServlet extends HttpServlet {
    private static final String API_KEY = "AIzaSyA-xNbUAj18cLFGuowbMvPpAy88IXeE_os"; 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pergunta = request.getParameter("pergunta");
        String textoRedacao = request.getParameter("textoRedacao");

        String textoPdf = request.getParameter("textoPdf");
String perguntaSobrePdf = request.getParameter("perguntaSobrePdf");

String resposta;

if (textoRedacao != null && !textoRedacao.isEmpty()) {
    resposta = chamarGeminiCorreção(textoRedacao);
} else if (pergunta != null && !pergunta.isEmpty()) {
    resposta = chamarGeminiPergunta(pergunta);
} else if (textoPdf != null && perguntaSobrePdf != null &&
           !textoPdf.isEmpty() && !perguntaSobrePdf.isEmpty()) {
    String prompt = "Com base no seguinte texto extraído de um PDF:\n\n"
                  + textoPdf + "\n\nResponda à pergunta:\n" + perguntaSobrePdf;
    resposta = chamarGeminiPergunta(prompt);
} else {
    resposta = "Nenhuma entrada fornecida.";
}


     
        request.setAttribute("resposta", resposta);
        String origem = request.getHeader("referer");
if (origem != null && origem.contains("resultado.jsp")) {
    request.setAttribute("texto", textoPdf); // para manter o conteúdo na tela
    request.getRequestDispatcher("resultado.jsp").forward(request, response);
} else {
    request.getRequestDispatcher("respostaGemini.jsp").forward(request, response);
}

    }

    private String chamarGeminiCorreção(String textoRedacao) throws IOException {
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

    private String chamarGeminiPergunta(String pergunta) throws IOException {
        URL url = new URL("https://generativelanguage.googleapis.com/v1beta/models/gemini-2.0-flash:generateContent?key=" + API_KEY);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setDoOutput(true);
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", "application/json");

        JsonObject requestBody = new JsonObject();
        JsonArray contents = new JsonArray();

     
        JsonObject part = new JsonObject();
        part.addProperty("text", pergunta);

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