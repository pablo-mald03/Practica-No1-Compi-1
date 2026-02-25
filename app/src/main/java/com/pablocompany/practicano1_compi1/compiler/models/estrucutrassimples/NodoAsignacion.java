package com.pablocompany.practicano1_compi1.compiler.models.estrucutrassimples;

import com.pablocompany.practicano1_compi1.compiler.models.EntornoValores;
import com.pablocompany.practicano1_compi1.compiler.models.NodoExpresion;
import com.pablocompany.practicano1_compi1.compiler.models.NodoInstruccion;
import com.pablocompany.practicano1_compi1.compiler.models.NodoSimple;
import com.pablocompany.practicano1_compi1.compiler.models.datos.Indexador;

/*P*/
public class NodoAsignacion extends NodoSimple {
    private String id;
    private NodoExpresion expresion;

    public NodoAsignacion(String id, NodoExpresion expresion){
        this.id = id;
        this.expresion = expresion;
    }

    @Override
    public void ejecutar(EntornoValores entorno){
        /*double valor = expresion.evaluar(entorno);
        entorno.setVariable(id, valor);*/
    }

    @Override
    public String getString() {
        return this.id + expresion.toString();
    }

}/*P*/
