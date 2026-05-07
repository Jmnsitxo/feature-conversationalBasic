package com.ux.edu.conversational.ia;

public class MistralStrategy implements IAStrategy {

    @Override

    public String generarRespuesta(PromptConfig config) {

        return "[Mistral-Ollama]: Respuesta rápida generada para: " + config.getEntrada();

    }

    @Override

    public String getNombreModelo() { return "Mistral"; }

}