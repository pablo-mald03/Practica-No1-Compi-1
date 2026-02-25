package com.pablocompany.practicano1_compi1.compiler.models.operadores.logicos;

import com.pablocompany.practicano1_compi1.compiler.models.EntornoValores;
import com.pablocompany.practicano1_compi1.compiler.models.NodoExpresion;

public class NodoAnd extends NodoExpresion {
    private NodoExpresion izquierda;
    private NodoExpresion derecha;
    public NodoAnd(NodoExpresion izq, NodoExpresion der, int linea, int columna) {
        super(linea,columna);
        izquierda = izq;
        derecha = der;
    }
    @Override
    public double evaluar(EntornoValores entorno) {
        return 0;
    }

    //Metodo que retorna su valor como string
    @Override
    public String getString() {
        return this.izquierda.getString() + " && " + this.derecha.getString();
    }
}
