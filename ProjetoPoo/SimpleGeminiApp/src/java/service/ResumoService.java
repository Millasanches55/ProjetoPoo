/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import com.google.gson.*;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

/**
 *
 * @author Fatec
 */
public class ResumoService {
    
    
    public static String gerarResumo(String textoOriginal) throws IOException {
        String prompt = "Resuma o seguinte conteúdo de forma clara e objetiva:\n\n" + textoOriginal;
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
    JsonArray partsArray = new JsonArray();
    partsArray.add(part);
    content.add("parts", partsArray);
    contents.add(content);
    requestBody.add("contents", contents);
    
    try (OutputStream os = conn.getOutputStream()) {
        byte[] input = requestBody.toString().getBytes(StandardCharsets.UTF_8);
        os.write(input, 0, input.length);
    }
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
   
