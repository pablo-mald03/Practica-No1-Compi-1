package com.pablocompany.practicano1_compi1.compiler.models.operadores.relacionales;

import com.pablocompany.practicano1_compi1.compiler.models.NodoExpresion;

//Clase que representa el operador realacional diferente
public class NodoDiferente extends NodoExpresion {
    private NodoExpresion izquierda, derecha;
    public NodoDiferente(NodoExpresion izq, NodoExpresion der, int fila, int columna) {
        super(fila,columna);
        izquierda = izq;
        derecha = der;
    }
    //METODO QUE RETORNA SU VALOR CONDICIONAL
    @Override
    public String getString() {
        return "(" + izquierda.getString() + " != " + derecha.getString() + ")";
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
