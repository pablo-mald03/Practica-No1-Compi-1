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
        /*double valor = expresion.evaluar(entorno);
        entorno.setVariable(nombre, valor);*/
    }
    @Override
    public String getString() {
        return this.nombre + expresion.toString();
    }


}
