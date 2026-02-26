package com.pablocompany.practicano1_compi1.compiler.models.operadores.relacionales;

import com.pablocompany.practicano1_compi1.compiler.models.NodoExpresion;

//Clase que representa el operador realacional Mayor que
public class NodoMayor extends NodoExpresion {
    private NodoExpresion izquierda;
    private NodoExpresion derecha;
    public NodoMayor(NodoExpresion izq, NodoExpresion der, int fila, int columna)
    {
        super(fila,columna);
        izquierda = izq;
        derecha = der;
    }

    /*===Metodos getters utilizados para poder obtener las expresiones en reportes===*/
    public NodoExpresion getDerecha() {
        return derecha;
    }

    public NodoExpresion getIzquierda() {
        return izquierda;
    }
    /*===Metodos getters utilizados para poder obtener las expresiones en reportes===*/

    //METODO QUE RETORNA SU VALOR CONDICIONAL
    @Override
    public String getString() {
        return "(" + izquierda.getString() + " > " + derecha.getString() + ")";
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
