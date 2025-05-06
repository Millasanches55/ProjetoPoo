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
    private static final String API_KEY = "AIzaSyA-xNbUAj18cLFGuowbMvPpAy88IXeE_os";
    
    public static String gerarResumo(String textoOriginal) throws IOException {
        String prompt = "Resuma o seguinte conteúdo de forma clara e objetiva:\n\n" + textoOriginal;
        URL url = new URL("https://generativelanguage.googleapis.com/v1beta/models/gemini-2.0-flash:generateContent?key=" + API_KEY);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
    conn.setDoOutput(true);
    conn.setRequestMethod("POST");
    conn.setRequestProperty("Content-Type", "application/json");
    
    JsonObject requestBody = new JsonObject();
        
        
    }

    }
    
}
