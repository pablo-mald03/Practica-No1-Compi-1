package com.pablocompany.practicano1_compi1.compiler.models.estructuras;

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

    //Retorna la condicion de la estructura
    public NodoExpresion getCondicion() {
        return condicion;
    }


    //Metodo que permite indexar a las estructuras
    @Override
    public void indexar(Indexador ctx) {
        ctx.registrarEstructura(this);
        if (this.bloque != null) {
            this.bloque.indexar(ctx);
        }
    }

    //METODO QUE RETORNA SU VALOR CONDICIONAL
    @Override
    public String getString() {
        return this.condicion.getString();
    }

    //Metodo que permite obtener el bloque de codigo que esta tiene dentro
    @Override
    public String getBloqueString() {
        StringBuilder bloqueTexto = new StringBuilder();
        for (NodoInstruccion ins : this.bloque.getInstrucciones()) {
            bloqueTexto.append(ins.getString());
            bloqueTexto.append("\n");
        }
        return bloqueTexto.toString();
    }
}
