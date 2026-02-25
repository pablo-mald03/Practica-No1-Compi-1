package com.pablocompany.practicano1_compi1.compiler.models.operadores.logicos;

import com.pablocompany.practicano1_compi1.compiler.models.EntornoValores;
import com.pablocompany.practicano1_compi1.compiler.models.NodoExpresion;

public class NodoNot extends NodoExpresion {
    private NodoExpresion expr;
    public NodoNot(NodoExpresion e, int linea, int columna) {
        super(linea, columna);
        expr = e;
    }
    @Override
    public double evaluar(EntornoValores entorno) {
        return 0;
    }

    //Metodo que retorna su valor como string
    @Override
    public String getString() {
        return "!" + this.expr.getString();
    }
}
