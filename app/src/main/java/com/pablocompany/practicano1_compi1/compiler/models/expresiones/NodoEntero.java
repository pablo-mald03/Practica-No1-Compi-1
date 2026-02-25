package com.pablocompany.practicano1_compi1.compiler.models.expresiones;

import com.pablocompany.practicano1_compi1.compiler.models.EntornoValores;
import com.pablocompany.practicano1_compi1.compiler.models.NodoExpresion;

//Clase que representa un valor entero
public class NodoEntero extends NodoExpresion {

    private int valor;

    public NodoEntero(int valor, int fila, int columna) {
        super(fila, columna);
        this.valor = valor;
    }

    @Override
    public double evaluar(EntornoValores entorno) {
        return valor;
    }

    @Override
    public String getString() {
        return String.valueOf(valor);
    }
}
