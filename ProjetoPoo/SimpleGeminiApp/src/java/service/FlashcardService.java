/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

/**
 *
 * @author Fatec
 */

import com.google.gson.*;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;


public class FlashcardService {
    private static final String API_KEY = "AIzaSyA-xNbUAj18cLFGuowbMvPpAy88IXeE_os"; 
    private static final String API_URL = "https://generativelanguage.googleapis.com/v1beta/models/gemini-2.0-flash:generateContent?key=" + API_KEY;
    
    // Método responsável por gerar flashcards com base em um texto
    public static String gerarFlashcards(String texto) throws IOException {
    String prompt = "Gere flashcards de estudo (pergunta e resposta) a partir do seguinte conteúdo:\n" + texto;
    // Montagem manual do corpo JSON da requisição para a API do Gemini
    String jsonInput = String.format(
    "{\n" +
    "  \"contents\": [{\n" +
    "    \"parts\": [{\n" +
    "      \"text\": \"%s\"\n" +
    "    }]\n" +
    "  }]\n" +
    "}", prompt
);

    // Configura conexão HTTP para envio do prompt
    HttpURLConnection conn = (HttpURLConnection) new URL(API_URL).openConnection();
    conn.setRequestMethod("POST");
conn.setRequestProperty("Content-Type", "application/json");
conn.setDoOutput(true);

try (OutputStream os = conn.getOutputStream()) {
            os.write(jsonInput.getBytes());
        }


// Lê a resposta da API e extrai o conteúdo gerado (texto dos flashcards)
try (BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()))){
    JsonObject respostaJson = JsonParser.parseReader(br).getAsJsonObject();
            JsonArray candidates = respostaJson.getAsJsonArray("candidates");
            // Verifica se há retorno e extrai o primeiro conteúdo gerado
            if (candidates != null && candidates.size() > 0) {
                return candidates.get(0).getAsJsonObject()
                        .getAsJsonObject("content")
                        .getAsJsonArray("parts")
                        .get(0).getAsJsonObject()
                        .get("text").getAsString();
            } else {
                return "Nenhum flashcard gerado.";
            }
        }
    }
}
   
