package com.pablocompany.practicano1_compi1.compiler.models;

import java.util.List;

public class NodoSi extends  NodoInstruccion{
    private NodoExpresion condicion;
    private List<NodoInstruccion> instrucciones;

    public NodoSi(NodoExpresion condicion, List<NodoInstruccion> instrucciones) {
        this.condicion = condicion;
        this.instrucciones = instrucciones;
    }

    @Override
    public void ejecutar(EntornoValores entorno) {

        double valorCondicion = condicion.evaluar(entorno);

        // Asumimos 1 = true, 0 = false
        if (valorCondicion != 0) {
            for (NodoInstruccion instruccion : instrucciones) {
                instruccion.ejecutar(entorno);
            }
        }
    }
}
