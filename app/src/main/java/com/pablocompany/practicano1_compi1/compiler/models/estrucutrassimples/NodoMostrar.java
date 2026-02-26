package com.pablocompany.practicano1_compi1.compiler.models.estrucutrassimples;

import com.pablocompany.practicano1_compi1.compiler.models.NodoExpresion;
import com.pablocompany.practicano1_compi1.compiler.models.NodoSimple;

/*P*/
public class NodoMostrar extends NodoSimple {

    private NodoExpresion expresion;

    public NodoMostrar(NodoExpresion expresion) {
        this.expresion = expresion;
    }

    //Metodo que permite obtener el texto que hay dentro
    @Override
    public String getString() {
        return "MOSTRAR " + this.expresion.getString();
    }

    //Metodo que retonra la expresion dentro de la instruccion
    public NodoExpresion getExpresion(){
        return this.expresion;
    }

    /*P*/
}
