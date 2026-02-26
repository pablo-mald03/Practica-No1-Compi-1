package com.pablocompany.practicano1_compi1.compiler.models;

public abstract class NodoExpresion {

    protected int linea;
    protected int columna;

    public NodoExpresion(int linea, int columna) {
        this.linea = linea;
        this.columna = columna;
    }

    public int getLinea() {
        return linea;
    }
    public int getColumna() {
        return columna;
    }


    public abstract String getString();

    //Metodos que permiten obtener los valors de las expresiones
    public abstract int getValorEntero();

    public abstract double getValorDecimal();
}
