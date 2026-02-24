package com.pablocompany.practicano1_compi1.compiler.models;
/*P*/
public class NodoAsignacion extends NodoInstruccion{
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
