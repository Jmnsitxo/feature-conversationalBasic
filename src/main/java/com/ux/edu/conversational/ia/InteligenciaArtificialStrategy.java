package com.ux.edu.conversational.ia;

public interface InteligenciaArtificialStrategy {
    String generarRespuesta(String prompt);
    String getNombreModelo();
}
