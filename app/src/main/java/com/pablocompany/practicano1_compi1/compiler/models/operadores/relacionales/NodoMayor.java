package com.pablocompany.practicano1_compi1.compiler.models.operadores.relacionales;

import com.pablocompany.practicano1_compi1.compiler.models.EntornoValores;
import com.pablocompany.practicano1_compi1.compiler.models.NodoExpresion;

public class NodoMayor extends NodoExpresion {
    private NodoExpresion izquierda;
    private NodoExpresion derecha;
    public NodoMayor(NodoExpresion izq, NodoExpresion der, int fila, int columna)
    {
        super(fila,columna);
        izquierda = izq;
        derecha = der;
    }

    @Override
    public double evaluar(EntornoValores entorno) {
        return izquierda.evaluar(entorno) > derecha.evaluar(entorno) ? 1 : 0;
    }
}
