package com.pablocompany.practicano1_compi1.compiler.models.estrucutrassimples;

import com.pablocompany.practicano1_compi1.compiler.models.EntornoValores;
import com.pablocompany.practicano1_compi1.compiler.models.NodoExpresion;
import com.pablocompany.practicano1_compi1.compiler.models.NodoInstruccion;
import com.pablocompany.practicano1_compi1.compiler.models.NodoSimple;
import com.pablocompany.practicano1_compi1.compiler.models.datos.Indexador;

public class NodoDeclaracion extends NodoSimple {

    private String nombre;
    private NodoExpresion expresion;

    public NodoDeclaracion(String nombre, NodoExpresion expresion){
        this.nombre = nombre;
        this.expresion = expresion;
    }

    @Override
    public void ejecutar(EntornoValores entorno){

    }
    //Metodo que permite obtener el texto que hay dentro
    @Override
    public String getString() {
        return  "VAR "+ this.nombre +" = "+ expresion.getString();
    }


}
