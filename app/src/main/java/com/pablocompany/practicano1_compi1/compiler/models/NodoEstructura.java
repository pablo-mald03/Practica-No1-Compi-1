package com.pablocompany.practicano1_compi1.compiler.models;

import com.pablocompany.practicano1_compi1.compiler.models.datos.Indexador;

import java.util.List;

//Segunda clase jerarquica que permite ordenar las instrucciones que componen a los bloques de codigo
public abstract class NodoEstructura extends NodoInstruccion{

    //Lista de todas las instrucciones que estan dentro del bloque del codigo
    protected List<NodoInstruccion> instrucciones;

    public NodoEstructura(List<NodoInstruccion> instrucciones) {
        this.instrucciones = instrucciones;
    }

    //Metodo que permite indexar los bloques (tanto por indice general como por tipo)
    @Override
    public void indexar(Indexador index) {
        index.registrarEstructura(this);
    }
}
