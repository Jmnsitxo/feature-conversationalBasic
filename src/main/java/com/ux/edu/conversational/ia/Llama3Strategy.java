package com.ux.edu.conversational.ia;

public class Llama3Strategy implements IAStrategy {
    @Override
    public String generarRespuesta(PromptConfig config) {
        // Implementación de Few-Shot Prompting
        String promptEstructurado = new PromptBuilder()
                .setInstrucciones("Eres un experto en física cuántica. Responde de forma técnica pero breve.")
                .agregarEjemplo("¿Qué es un fotón?", "Es la partícula elemental responsable de las manifestaciones cuánticas del fenómeno electromagnético.")
                .setEntradaUsuario(config.getEntrada())
                .build();

        return "[Llama3-Ollama (Structured)]: " + promptEstructurado;
    }

    @Override
    public String getNombreModelo() { return "Llama3-Advanced"; }
}