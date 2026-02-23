package com.pablocompany.practicano1_compi1.compiler.models;

public class NodoDivision extends  NodoExpresion{
    private NodoExpresion izquierda;
    private NodoExpresion derecha;

    public NodoDivision(NodoExpresion izquierda, NodoExpresion derecha){
        this.izquierda = izquierda;
        this.derecha = derecha;
    }

    @Override
    public double evaluar(EntornoValores entorno){
        return izquierda.evaluar(entorno) / derecha.evaluar(entorno);
    }

}
