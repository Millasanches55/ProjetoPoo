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
    
    
    public static String gerarFlashcards(String texto) throws IOException {
    String prompt = "Gere flashcards de estudo (pergunta e resposta) a partir do seguinte conteúdo:\n" + texto;
    String jsonInput = """
        {
            "contents": [{
                "parts": [{
                    "text": "%s"
                }]
            }]
        }
        """.formatted(prompt);
    HttpURLConnection conn = (HttpURLConnection) new URL(API_URL).openConnection();
    conn.setRequestMethod("POST");
conn.setRequestProperty("Content-Type", "application/json");
conn.setDoOutput(true);
