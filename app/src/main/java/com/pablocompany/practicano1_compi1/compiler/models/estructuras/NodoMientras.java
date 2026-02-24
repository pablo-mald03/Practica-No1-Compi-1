package com.pablocompany.practicano1_compi1.compiler.models.estructuras;

import com.pablocompany.practicano1_compi1.compiler.models.EntornoValores;
import com.pablocompany.practicano1_compi1.compiler.models.NodoEstructura;
import com.pablocompany.practicano1_compi1.compiler.models.NodoExpresion;
import com.pablocompany.practicano1_compi1.compiler.models.NodoInstruccion;
import com.pablocompany.practicano1_compi1.compiler.models.datos.Indexador;

import java.util.List;

//Representa al ciclo mientrs en una estructura de control
public class NodoMientras extends NodoEstructura {

    private NodoExpresion condicion;

    public NodoMientras(NodoExpresion condicion, List<NodoInstruccion> instrucciones) {
        super(instrucciones);
        this.condicion = condicion;
    }

    //Metodo getter de la condicion
    public NodoExpresion getCondicion() {
        return condicion;
    }

    @Override
    public void ejecutar(EntornoValores entorno) {

        /*double valorCondicion = condicion.evaluar(entorno);

        if (valorCondicion != 0) {
            for (NodoInstruccion instruccion : instrucciones) {
                instruccion.ejecutar(entorno);
            }
        }*/
    }

    @Override
    public void indexar(Indexador ctx) {
        ctx.registrarEstructura(this);
    }
}
