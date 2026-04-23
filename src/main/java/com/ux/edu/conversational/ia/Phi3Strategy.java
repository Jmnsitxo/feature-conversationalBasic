package com.ux.edu.conversational.ia;
git
    public class Phi3Strategy implements InteligenciaArtificialStrategy {
        @Override
        public String generarRespuesta(String prompt) {
            return "[Phi3-Microsoft]: Procesando de forma ligera y eficiente: " + prompt;
        }
        @Override
        public String getNombreModelo() { return "Phi3"; }
    }