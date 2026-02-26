package com.pablocompany.practicano1_compi1.compiler.models.estrucutrassimples;

import com.pablocompany.practicano1_compi1.compiler.models.NodoExpresion;
import com.pablocompany.practicano1_compi1.compiler.models.NodoSimple;

/*P*/
public class NodoAsignacion extends NodoSimple {
    private String id;
    private NodoExpresion expresion;

    public NodoAsignacion(String id, NodoExpresion expresion){
        this.id = id;
        this.expresion = expresion;
    }


    @Override
    public String getString() {
        return this.id +" = "+ expresion.getString();
    }

}/*P*/
