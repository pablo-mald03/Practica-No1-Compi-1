package com.pablocompany.practicano1_compi1.compiler.models;

import com.pablocompany.practicano1_compi1.compiler.models.datos.Indexador;

//Atributos en comun que permiten manejar los indices POR INSTRUCCION
public abstract class NodoInstruccion {
    //El uso de clases abstractas describen la gran jerarquia de clases que existen y que tienen codigo dentro
    //Inicio de la jerarquia
    protected int indiceGlobal;
    protected int indiceInterno;

    public void setIndices(int global, int interno) {
        this.indiceGlobal = global;
        this.indiceInterno = interno;
    }

    //====Region de getters y setters====
    public int getIndiceGlobal() {
        return this.indiceGlobal;
    }

    public int getIndiceInterno() {
        return this.indiceInterno;
    }


    //Metodo que permite indexar una a una cada instruccion
    public abstract void indexar(Indexador index);
    //Metodo que permite obtener todos los datos almacenados en las jerarquias
    public abstract String getString();

}
