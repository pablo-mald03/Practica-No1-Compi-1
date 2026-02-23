package com.pablocompany.practicano1_compi1.compiler.models;

public class NodoVariable extends NodoExpresion{

    private String nombre;

    public NodoVariable(String nombre){
        this.nombre = nombre;
    }

    @Override
    public double evaluar(EntornoValores entorno){
        return entorno.getVariable(nombre);
    }
}
