package com.pablocompany.practicano1_compi1.compiler.models.estructuras;

import com.pablocompany.practicano1_compi1.compiler.models.NodoEstructura;
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


    //Metodo que permite indexar a las estructuras
    @Override
    public void indexar(Indexador ctx) {
        ctx.registrarEstructura(this);
    }

    //Metodo que permite obtener el bloque de codigo que esta tiene dentro
    @Override
    public String getBloqueString() {
        StringBuilder bloqueTexto = new StringBuilder();
        for (NodoInstruccion ins : this.instrucciones) {
            bloqueTexto.append(ins.getString());
            bloqueTexto.append("\n");
        }
        return bloqueTexto.toString();
    }

    @Override
    public String getString() {

        return "BLOQUE DE CODIGO";
    }

}
