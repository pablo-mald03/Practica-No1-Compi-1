package com.pablocompany.practicano1_compi1.compiler.models.operadores.logicos;

import com.pablocompany.practicano1_compi1.compiler.models.EntornoValores;
import com.pablocompany.practicano1_compi1.compiler.models.NodoExpresion;

public class NodoAnd extends NodoExpresion {
    private NodoExpresion izquierda, derecha;
    public NodoAnd(NodoExpresion izq, NodoExpresion der, int linea, int columna) {
        super(linea,columna);
        izquierda = izq;
        derecha = der;
    }
    @Override
    public double evaluar(EntornoValores entorno) {
        return (izquierda.evaluar(entorno) != 0 && derecha.evaluar(entorno) != 0) ? 1 : 0;
    }
}
