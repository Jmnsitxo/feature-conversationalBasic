package com.ux.edu.conversational.ia;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class Phi3Strategy implements IAStrategy {

    @Override
    public String getNombreModelo() {
        return "phi3:mini";
    }

    @Override
    public String generarRespuesta(PromptConfig config) {
        // Build the prompt from config
        String prompt = "Rol: " + config.getRol() + "\nInstrucciones: " + config.getInstrucciones() + "\nEntrada: " + config.getEntrada();
        
        try {
            URL url = new URL("http://localhost:11434/api/generate");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);

            String promptLimpio = prompt.replace("\n", " ")
                    .replace("\r", " ")
                    .replace("\"", "\\\"");

            String jsonInput = "{"
                    + "\"model\": \"phi3:mini\","
                    + "\"prompt\": \"" + promptLimpio + "\","
                    + "\"stream\": false"
                    + "}";

            try (OutputStream os = conn.getOutputStream()) {
                byte[] input = jsonInput.getBytes(StandardCharsets.UTF_8);
                os.write(input, 0, input.length);
            }

            int status = conn.getResponseCode();
            InputStream is = (status >= 200 && status < 300) ? conn.getInputStream() : conn.getErrorStream();

            try (BufferedReader br = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8))) {
                StringBuilder response = new StringBuilder();
                String line;
                while ((line = br.readLine()) != null) {
                    response.append(line);
                }
                return response.toString();
            }

        } catch (Exception e) {
            return "Error de conexión: " + e.getMessage();
        }
    }
}