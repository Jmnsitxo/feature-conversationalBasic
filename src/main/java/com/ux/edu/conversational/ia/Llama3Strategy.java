package com.ux.edu.conversational.ia;


public class Llama3Strategy implements InteligenciaArtificialStrategy {

    @Override

    public String generarRespuesta(String prompt) {

        return "[Llama3-Ollama]: Analizando con 8B parámetros... " + prompt;

    }

    @Override

    public String getNombreModelo() { return "Llama3"; }

}