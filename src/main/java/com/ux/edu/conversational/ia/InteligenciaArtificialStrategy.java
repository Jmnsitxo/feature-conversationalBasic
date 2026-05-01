package com.ux.edu.conversational.ia;

public interface InteligenciaArtificialStrategy {
    String getNombreModelo();
    String generarRespuesta(String prompt);
}