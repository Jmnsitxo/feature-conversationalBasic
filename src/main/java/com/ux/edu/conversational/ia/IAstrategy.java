package com.ux.edu.conversational.ia;


public interface IAStrategy {

    String generarRespuesta(PromptConfig config);

    String getNombreModelo();

}
