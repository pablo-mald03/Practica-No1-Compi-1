package com.pablocompany.practicano1_compi1.compiler.models.configuracion;

import com.pablocompany.practicano1_compi1.compiler.models.EntornoValores;
import com.pablocompany.practicano1_compi1.compiler.models.NodoExpresion;

//Clse que permite establecer como predeterminada la configuracion de una instruccion
public class NodoConfigDefault extends NodoConfiguracion {
    private NodoExpresion valor;

    public NodoConfigDefault(NodoExpresion valor) {
        this.valor = valor;
    }

    @Override
    public void aplicar(EntornoValores entorno) {
        int nivel = (int) valor.evaluar(entorno);
        //entorno.setDefaultNivel(nivel);
    }
}
