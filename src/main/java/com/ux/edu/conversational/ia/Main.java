package com.ux.edu.conversational.ia;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AgenteConversacional agente = new AgenteConversacional();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Selecciona el modelo de IA:");
        System.out.println("1. Phi3 (phi3:mini)");
        System.out.println("2. Llama3");
        System.out.println("3. Mistral");
        System.out.println("4. Gemma2");
        System.out.print("Opción: ");
        int opcion = scanner.nextInt();
        scanner.nextLine(); // consume newline

        IAStrategy estrategia;
        switch (opcion) {
            case 1:
                estrategia = new Phi3Strategy();
                break;
            case 2:
                estrategia = new Llama3Strategy();
                break;
            case 3:
                estrategia = new MistralStrategy();
                break;
            case 4:
                estrategia = new GemmaStrategy();
                break;
            default:
                System.out.println("Opción inválida, usando Phi3 por defecto.");
                estrategia = new Phi3Strategy();
        }

        agente.setModelo(estrategia);

        System.out.print("Ingresa tu pregunta: ");
        String entrada = scanner.nextLine();

        PromptConfig config = new PromptConfig("Asistente IA", "Responde de manera útil y precisa.", entrada);

        System.out.println("Enviando pregunta...");
        agente.interactuar(config);
    }
}