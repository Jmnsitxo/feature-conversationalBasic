package com.ux.edu.conversational.ia;

public class GemmaStrategy implements IAStrategy {

    @Override
    public String generarRespuesta(PromptConfig config) {
        // Lógica de conexión con Ollama usando el modelo "gemma2"
        return "Respuesta desde Gemma2: " + config.getEntrada();
    }

    @Override
    public String getNombreModelo() {
        return "gemma2";
    }
}
