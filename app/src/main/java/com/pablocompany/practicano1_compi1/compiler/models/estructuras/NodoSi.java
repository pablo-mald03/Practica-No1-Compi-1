package com.pablocompany.practicano1_compi1.compiler.models.estructuras;

import com.pablocompany.practicano1_compi1.compiler.models.EntornoValores;
import com.pablocompany.practicano1_compi1.compiler.models.NodoEstructura;
import com.pablocompany.practicano1_compi1.compiler.models.NodoExpresion;
import com.pablocompany.practicano1_compi1.compiler.models.NodoInstruccion;
import com.pablocompany.practicano1_compi1.compiler.models.datos.Indexador;

import java.util.List;

/*P*/
//Clase que representa la estructura de control si
public class NodoSi extends NodoEstructura {
    private NodoExpresion condicion;

    //Representa bloques de codigo dentro de la estructura
    private NodoBloque bloque;

    //Constructor
    public NodoSi(NodoExpresion condicion, NodoBloque bloque) {
        this.condicion = condicion;
        this.bloque = bloque;
    }

    //Retorna el bloque de instrucciones que vienen dentro
    public NodoBloque getBloque() {
        return bloque;
    }

    @Override
    public void ejecutar(EntornoValores entorno) {
        //EN ANALISIS AUN
       /* double valorCondicion = condicion.evaluar(entorno);

        if (valorCondicion != 0) {
            for (NodoInstruccion instruccion : instrucciones) {
                instruccion.ejecutar(entorno);
            }
        }*/
    }

    //Metodo que permite indexar a las estructuras
    @Override
    public void indexar(Indexador ctx) {
        ctx.registrarEstructura(this);
        this.bloque.indexar(ctx);
    }
}
