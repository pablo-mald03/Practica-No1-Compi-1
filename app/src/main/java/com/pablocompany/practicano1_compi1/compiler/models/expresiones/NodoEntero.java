package com.pablocompany.practicano1_compi1.compiler.models.expresiones;

import com.pablocompany.practicano1_compi1.compiler.models.EntornoValores;
import com.pablocompany.practicano1_compi1.compiler.models.NodoExpresion;

public class NodoEntero extends NodoExpresion {

    private int valor;

    public NodoEntero(int valor){
        this.valor = valor;
    }
    @Override
    public double evaluar(EntornoValores entorno) {
        return valor;
    }
}
