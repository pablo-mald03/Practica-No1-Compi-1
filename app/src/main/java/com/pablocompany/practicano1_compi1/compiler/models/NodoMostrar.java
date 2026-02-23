package com.pablocompany.practicano1_compi1.compiler.models;

public class NodoMostrar extends NodoInstruccion{

    private NodoExpresion expresion;

    public NodoMostrar(NodoExpresion expresion){
        this.expresion = expresion;
    }

    @Override
    public void ejecutar(EntornoValores entorno){
        double valor = expresion.evaluar(entorno);
    }

}
