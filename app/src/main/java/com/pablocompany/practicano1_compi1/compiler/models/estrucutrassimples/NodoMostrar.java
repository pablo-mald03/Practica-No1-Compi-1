package com.pablocompany.practicano1_compi1.compiler.models.estrucutrassimples;

import com.pablocompany.practicano1_compi1.compiler.models.EntornoValores;
import com.pablocompany.practicano1_compi1.compiler.models.NodoExpresion;
import com.pablocompany.practicano1_compi1.compiler.models.NodoInstruccion;
import com.pablocompany.practicano1_compi1.compiler.models.NodoSimple;
import com.pablocompany.practicano1_compi1.compiler.models.datos.Indexador;

/*P*/
public class NodoMostrar extends NodoSimple {

    private NodoExpresion expresion;

    public NodoMostrar(NodoExpresion expresion) {
        this.expresion = expresion;
    }

    @Override
    public void ejecutar(EntornoValores entorno) {
        double valor = expresion.evaluar(entorno);
    }

    //Metodo que permite obtener el texto que hay dentro
    @Override
    public String getString() {
        return "MOSTRAR " + this.expresion.getString();
    }
    /*P*/
}
