package com.pablocompany.practicano1_compi1.compiler.models.expresiones;

import com.pablocompany.practicano1_compi1.compiler.models.NodoExpresion;

//Clase que representa un valor decimal
public class NodoDecimal extends NodoExpresion {
    private double valor;

    public NodoDecimal(double valor, int fila, int columna) {
        super(fila, columna);
        this.valor = valor;
    }

    @Override
    public String getString() {
        return String.valueOf(valor);
    }

    //Metodos que permiten obtener su valor procesado
    @Override
    public int getValorEntero() {
        return (int)this.valor;
    }

    @Override
    public double getValorDecimal() {
        return this.valor;
    }
}
