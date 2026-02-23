package com.pablocompany.practicano1_compi1.compiler.models.expresiones;

import com.pablocompany.practicano1_compi1.compiler.models.EntornoValores;
import com.pablocompany.practicano1_compi1.compiler.models.NodoExpresion;

public class NodoDecimal extends NodoExpresion {
    private double valor;

    public NodoDecimal(double valor){
        this.valor = valor;
    }

    @Override
    public double evaluar(EntornoValores entorno) {
        return valor;
    }
}
