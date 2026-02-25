package com.pablocompany.practicano1_compi1.compiler.models.estructuras;

import com.pablocompany.practicano1_compi1.compiler.models.EntornoValores;
import com.pablocompany.practicano1_compi1.compiler.models.NodoEstructura;
import com.pablocompany.practicano1_compi1.compiler.models.NodoExpresion;
import com.pablocompany.practicano1_compi1.compiler.models.NodoInstruccion;
import com.pablocompany.practicano1_compi1.compiler.models.datos.Indexador;

import java.util.List;

//Representa los bloques de codigo fuera de estructuras de control
public class NodoBloque extends NodoEstructura {

    //Lista de todas las instrucciones que estan dentro del bloque del codigo
    protected List<NodoInstruccion> instrucciones;

    //Constructor
    public NodoBloque(List<NodoInstruccion> instrucciones) {
        this.instrucciones = instrucciones;
    }

    //Retorna la lista de todas las instrucciones
    public List<NodoInstruccion> getInstrucciones() {
        return instrucciones;
    }

    @Override
    public void ejecutar(EntornoValores entorno) {
        //EN ANALISIS AUN
       /* for (NodoInstruccion ins : instrucciones) {
            ins.ejecutar(entorno);
        }*/
    }

    //Metodo que permite indexar a las estructuras
    @Override
    public void indexar(Indexador ctx) {
        ctx.registrarEstructura(this);
    }

}
