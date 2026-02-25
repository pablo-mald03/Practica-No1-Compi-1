package com.pablocompany.practicano1_compi1.compiler.models.operadores.relacionales;

import com.pablocompany.practicano1_compi1.compiler.models.EntornoValores;
import com.pablocompany.practicano1_compi1.compiler.models.NodoExpresion;

//Clase que representa el operador realacional menor que
public class NodoMenor extends NodoExpresion {
    private NodoExpresion izquierda, derecha;
    public NodoMenor(NodoExpresion izq, NodoExpresion der, int fila,int columna) {
        super(fila,columna);
        izquierda = izq;
        derecha = der;
    }

    @Override
    public double evaluar(EntornoValores entorno) {
        return izquierda.evaluar(entorno) < derecha.evaluar(entorno) ? 1 : 0;
    }

    //METODO QUE RETORNA SU VALOR CONDICIONAL
    @Override
    public String getString() {
        return "(" + izquierda.toString() + " < " + derecha.toString() + ")";
    }
}
