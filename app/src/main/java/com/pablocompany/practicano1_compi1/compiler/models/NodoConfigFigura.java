package com.pablocompany.practicano1_compi1.compiler.models;

public class NodoConfigFigura extends  NodoConfiguracion{

    private TipoConfiguracion tipo;
    private TipoFigura figura;
    private NodoExpresion nivel;

    public NodoConfigFigura(TipoConfiguracion tipo, String figura, NodoExpresion nivel) {
        this.figura = TipoFigura.valueOf(figura);
        this.nivel = nivel;
        this.tipo = tipo;
    }

    @Override
    public void aplicar(EntornoValores entorno) {

    }
}
