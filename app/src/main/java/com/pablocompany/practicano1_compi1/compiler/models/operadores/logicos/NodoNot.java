package com.pablocompany.practicano1_compi1.compiler.models.operadores.logicos;

import com.pablocompany.practicano1_compi1.compiler.models.NodoExpresion;

public class NodoNot extends NodoExpresion {
    private NodoExpresion expr;
    public NodoNot(NodoExpresion e, int linea, int columna) {
        super(linea, columna);
        expr = e;
    }

    /*===Metodos getters utilizados para poder obtener las expresiones===*/
    public NodoExpresion getExpresion() {
        return this.expr;
    }
    /*===Metodos getters utilizados para poder obtener las expresiones===*/

    //Metodo que retorna su valor como string
    @Override
    public String getString() {
        return "!" + this.expr.getString();
    }
    //Metodos que permiten obtener los valores numericos procesados de las instrucciones
    @Override
    public int getValorEntero() {
        return 0;
    }

    @Override
    public double getValorDecimal() {
        return 0;
    }
}
