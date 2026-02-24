package com.pablocompany.practicano1_compi1.compiler.models.estructuras;

import com.pablocompany.practicano1_compi1.compiler.models.EntornoValores;
import com.pablocompany.practicano1_compi1.compiler.models.NodoExpresion;
import com.pablocompany.practicano1_compi1.compiler.models.NodoInstruccion;

public class NodoDeclaracion extends NodoInstruccion {

    private String nombre;
    private NodoExpresion expresion;

    public NodoDeclaracion(String nombre, NodoExpresion expresion){
        this.nombre = nombre;
        this.expresion = expresion;
    }

    @Override
    public void ejecutar(EntornoValores entorno){
        double valor = expresion.evaluar(entorno);
        entorno.setVariable(nombre, valor);
    }
}
