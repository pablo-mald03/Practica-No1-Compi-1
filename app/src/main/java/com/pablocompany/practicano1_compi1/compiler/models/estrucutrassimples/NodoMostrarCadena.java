package com.pablocompany.practicano1_compi1.compiler.models.estrucutrassimples;

import com.pablocompany.practicano1_compi1.compiler.models.EntornoValores;
import com.pablocompany.practicano1_compi1.compiler.models.NodoInstruccion;
import com.pablocompany.practicano1_compi1.compiler.models.NodoSimple;
import com.pablocompany.practicano1_compi1.compiler.models.datos.Indexador;

public class NodoMostrarCadena extends NodoSimple {

    private String expresion;

    public NodoMostrarCadena(String expresion) {
        this.expresion = expresion;
    }

    @Override
    public void ejecutar(EntornoValores entorno) {

        //double valor = expresion.evaluar(entorno);
    }

    @Override
    public String getString() {
        return "MOSTRAR " + "\" " + this.expresion  + " \"";
    }
}