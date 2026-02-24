package com.pablocompany.practicano1_compi1.compiler.models.estructuras;

import com.pablocompany.practicano1_compi1.compiler.models.EntornoValores;
import com.pablocompany.practicano1_compi1.compiler.models.NodoExpresion;
import com.pablocompany.practicano1_compi1.compiler.models.NodoInstruccion;

/*P*/
public class NodoMostrar extends NodoInstruccion {

    private NodoExpresion expresion;

    public NodoMostrar(NodoExpresion expresion){
        this.expresion = expresion;
    }

    @Override
    public void ejecutar(EntornoValores entorno){
        double valor = expresion.evaluar(entorno);
    }
    /*P*/
}
