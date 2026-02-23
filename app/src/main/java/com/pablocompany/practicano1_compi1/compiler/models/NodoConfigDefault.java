package com.pablocompany.practicano1_compi1.compiler.models;

public class NodoConfigDefault extends NodoConfiguracion {
    private NodoExpresion valor;

    @Override
    public void aplicar(EntornoValores entorno) {
        int nivel = (int) valor.evaluar(entorno);
        //entorno.setDefaultNivel(nivel);
    }
}
