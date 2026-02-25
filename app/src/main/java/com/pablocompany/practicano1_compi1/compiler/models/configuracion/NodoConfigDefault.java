package com.pablocompany.practicano1_compi1.compiler.models.configuracion;

import com.pablocompany.practicano1_compi1.compiler.models.EntornoValores;
import com.pablocompany.practicano1_compi1.compiler.models.NodoExpresion;

//Clse que permite establecer como predeterminada la configuracion de una instruccion
public class NodoConfigDefault extends NodoConfiguracion {
    private NodoExpresion valor;

    public NodoConfigDefault(NodoExpresion valor) {
        this.valor = valor;
    }

    //Permite obtener el indice de aplicacion del estilo
    public int getIndice() {
        return Integer.parseInt(this.valor.getString());
    }
    @Override
    public void aplicar() {

    }
}
