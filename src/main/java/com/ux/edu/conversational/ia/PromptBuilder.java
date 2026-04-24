package com.ux.edu.conversational.ia;

import java.util.ArrayList;
import java.util.List;

public class PromptBuilder {
    private String instruccionesSistema;
    private String entradaUsuario;
    private List<String> ejemplos = new ArrayList<>();

    public PromptBuilder setInstrucciones(String instrucciones) {
        this.instruccionesSistema = instrucciones;
        return this;
    }

    public PromptBuilder agregarEjemplo(String entrada, String salida) {
        this.ejemplos.add("Input: " + entrada + "\nOutput: " + salida);
        return this;
    }

    public PromptBuilder setEntradaUsuario(String entrada) {
        this.entradaUsuario = entrada;
        return this;
    }

    public String build() {
        StringBuilder sb = new StringBuilder();
        sb.append("### SYSTEM INSTRUCTIONS ###\n")
                .append(instruccionesSistema).append("\n\n");

        if (!ejemplos.isEmpty()) {
            sb.append("### EXAMPLES (Few-Shot) ###\n");
            ejemplos.forEach(ex -> sb.append(ex).append("\n---\n"));
        }

        sb.append("\n### USER INPUT ###\n")
                .append(entradaUsuario);

        return sb.toString();
    }
}
