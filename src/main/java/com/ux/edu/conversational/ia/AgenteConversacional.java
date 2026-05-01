package com.ux.edu.conversational.ia;

public class AgenteConversacional {
    private InteligenciaArtificialStrategy modelo;

    // El corazón del patrón: inyección de la estrategia
    public void setModelo(InteligenciaArtificialStrategy nuevoModelo) {
        this.modelo = nuevoModelo;
        System.out.println("Cambiando cerebro a: " + nuevoModelo.getNombreModelo());
    }

    public InteligenciaArtificialStrategy getModelo() {
        return this.modelo;
    }

    public void interactuar(String mensaje) {
        if (modelo == null) {
            System.out.println("Error: No hay un modelo configurado.");
            return;
        }
        String respuesta = modelo.generarRespuesta(mensaje);
        System.out.println("IA responde: " + respuesta);
    }
}