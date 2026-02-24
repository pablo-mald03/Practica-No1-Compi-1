package com.pablocompany.practicano1_compi1.compiler.models.estructuras;

import com.pablocompany.practicano1_compi1.compiler.models.EntornoValores;
import com.pablocompany.practicano1_compi1.compiler.models.NodoExpresion;
import com.pablocompany.practicano1_compi1.compiler.models.NodoInstruccion;

/*P*/
public class NodoAsignacion extends NodoInstruccion {
    private String id;
    private NodoExpresion expresion;

    public NodoAsignacion(String id, NodoExpresion expresion){
        this.id = id;
        this.expresion = expresion;
    }

    @Override
    public void ejecutar(EntornoValores entorno){
        double valor = expresion.evaluar(entorno);
        entorno.setVariable(id, valor);
    }
}/*P*/
