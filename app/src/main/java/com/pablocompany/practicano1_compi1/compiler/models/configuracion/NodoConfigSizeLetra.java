package com.pablocompany.practicano1_compi1.compiler.models.configuracion;

import com.pablocompany.practicano1_compi1.compiler.models.EntornoValores;
import com.pablocompany.practicano1_compi1.compiler.models.NodoColor;
import com.pablocompany.practicano1_compi1.compiler.models.NodoExpresion;
import com.pablocompany.practicano1_compi1.compiler.models.TipoConfiguracion;

/*Clase que permite cambiar el size de la letra de una instruccion*/
public class NodoConfigSizeLetra extends NodoConfiguracion {


    private NodoExpresion size;
    private NodoExpresion indice;

    private TipoConfiguracion tipo;
    /*P*/

    public NodoConfigSizeLetra( TipoConfiguracion tipo, NodoExpresion size, NodoExpresion indice) {
        this.indice = indice;
        this.size = size;
        this.tipo = tipo;

    }
    /*==========APARTADO DE METODOS GETTER==========*/

    public NodoExpresion getIndice() {
        return this.indice;
    }

    public NodoExpresion getSize() {
        return this.size;
    }

    public TipoConfiguracion getTipo() {
        return this.tipo;
    }

    @Override
    public void aplicar(EntornoValores entorno) {
       /* int[] rgb = color.evaluar(entorno);
        int intensidad = (int) indice.evaluar(entorno);
*/
    }
}