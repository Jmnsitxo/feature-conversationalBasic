package com.ux.edu.conversational.ia;

public class Llama3Strategy implements InteligenciaArtificialStrategy {
    @Override
    public String generarRespuesta(String prompt) {
        // Implementación de Few-Shot Prompting
        String promptEstructurado = new PromptBuilder()
                .setInstrucciones("Eres un experto en física cuántica. Responde de forma técnica pero breve.")
                .agregarEjemplo("¿Qué es un fotón?", "Es la partícula elemental responsable de las manifestaciones cuánticas del fenómeno electromagnético.")
                .setEntradaUsuario(prompt)
                .build();

        return "[Llama3-Ollama (Structured)]: " + promptEstructurado;
    }

    @Override
    public String getNombreModelo() { return "Llama3-Advanced"; }
}