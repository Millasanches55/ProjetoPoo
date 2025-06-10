/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import com.google.gson.*;
import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;

public class GeminiClient {
    private static final String API_KEY = "AIzaSyA-xNbUAj18cLFGuowbMvPpAy88IXeE_os";

    public static String enviarPrompt(String prompt) throws IOException {
        URL url = new URL("https://generativelanguage.googleapis.com/v1beta/models/gemini-2.0-flash:generateContent?key=" + API_KEY);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setDoOutput(true);
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", "application/json");

        JsonObject requestBody = new JsonObject();
        JsonArray contents = new JsonArray();

        JsonObject part = new JsonObject();
        part.addProperty("text", prompt);

        JsonObject content = new JsonObject();
        content.add("parts", new JsonArray());
        content.getAsJsonArray("parts").add(part);
        contents.add(content);
        requestBody.add("contents", contents);

        try (OutputStream os = conn.getOutputStream()) {
            byte[] input = requestBody.toString().getBytes(StandardCharsets.UTF_8);
            os.write(input, 0, input.length);
        }

        
        // Lê a resposta da API e extrai o texto gerado pela IA
        try (BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), StandardCharsets.UTF_8))) {
            JsonObject responseJson = JsonParser.parseReader(br).getAsJsonObject();
            return responseJson
                .getAsJsonArray("candidates")
                .get(0).getAsJsonObject()
                .getAsJsonObject("content")
                .getAsJsonArray("parts")
                .get(0).getAsJsonObject()
                .get("text").getAsString();
        }
    }
}
