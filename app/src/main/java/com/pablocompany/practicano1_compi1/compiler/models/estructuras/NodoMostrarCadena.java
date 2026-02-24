package com.pablocompany.practicano1_compi1.compiler.models.estructuras;

import com.pablocompany.practicano1_compi1.compiler.models.EntornoValores;
import com.pablocompany.practicano1_compi1.compiler.models.NodoInstruccion;

public class NodoMostrarCadena extends NodoInstruccion {

    private String expresion;

    public NodoMostrarCadena(String expresion){
        this.expresion = expresion;
    }

    @Override
    public void ejecutar(EntornoValores entorno){

        //double valor = expresion.evaluar(entorno);
    }

}