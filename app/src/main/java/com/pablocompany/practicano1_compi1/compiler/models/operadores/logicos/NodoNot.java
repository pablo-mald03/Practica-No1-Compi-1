package com.pablocompany.practicano1_compi1.compiler.models.operadores.logicos;

import com.pablocompany.practicano1_compi1.compiler.models.EntornoValores;
import com.pablocompany.practicano1_compi1.compiler.models.NodoExpresion;

public class NodoNot extends NodoExpresion {
    private NodoExpresion expr;
    public NodoNot(NodoExpresion e) { expr = e; }
    @Override
    public double evaluar(EntornoValores entorno) {
        return expr.evaluar(entorno) == 0 ? 1 : 0;
    }
}
