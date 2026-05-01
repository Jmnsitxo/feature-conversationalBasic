package com.ux.edu.conversational.ia;

public class Main {
    public static void main(String[] args) {
        // 1. Instanciar el agente
        AgenteConversacional agente = new AgenteConversacional();

        // 2. Configurar el modelo (Estrategia)
        // Usamos Phi-3 por ser el más ligero para 8GB de RAM
        agente.setModelo(new Phi3Strategy());

        // 3. Ejecutar consulta
        System.out.println("Enviando pregunta...");
        agente.interactuar("Hola, ¿quién eres?");
    }
}