package com.pablocompany.practicano1_compi1.compiler.models.configuracion;

import com.pablocompany.practicano1_compi1.compiler.models.NodoExpresion;
import com.pablocompany.practicano1_compi1.compiler.models.enumsprogam.TipoConfiguracion;

/*Clase que permite cambiar el size de la letra de una instruccion*/
public class NodoConfigSizeLetra extends NodoConfiguracion {


    private NodoExpresion size;
    private NodoExpresion indice;

    private TipoConfiguracion tipo;
    /*P*/

    public NodoConfigSizeLetra(TipoConfiguracion tipo, NodoExpresion size, NodoExpresion indice) {
        this.indice = indice;
        this.size = size;
        this.tipo = tipo;

    }
    /*==========APARTADO DE METODOS GETTER==========*/

    //Metodo que permite obtener el indice donde se aplica el color
    public int getIndice() {
        return this.indice.getValorEntero();
    }

    //Metodo que permite obtener el size de la letra
    public double getSize() {
        return this.size.getValorDecimal();
    }

    //Metodo que permite obtener a que configuracion se va a aplicar
    public TipoConfiguracion getTipoConfig()
    {
        return this.tipo;
    }

    @Override
    public void aplicar() {
    }
}