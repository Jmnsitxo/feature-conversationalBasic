package com.ux.edu.conversational.ia;

public class AgenteConversacional {
    private IAStrategy modelo;

    public void setModelo(IAStrategy nuevoModelo) {
        this.modelo = nuevoModelo;
        System.out.println("Cambiando cerebro a: " + nuevoModelo.getNombreModelo());
    }

    public IAStrategy getModelo() {
        return this.modelo;
    }

    public void interactuar(PromptConfig config) {
        if (modelo == null) {
            System.out.println("Error: No hay un modelo configurado.");
            return;
        }
        String respuesta = modelo.generarRespuesta(config);
        System.out.println("IA responde: " + respuesta);
    }
}