package com.pablocompany.practicano1_compi1.compiler.models.configuracion;

import com.pablocompany.practicano1_compi1.compiler.models.EntornoValores;
import com.pablocompany.practicano1_compi1.compiler.models.NodoColor;
import com.pablocompany.practicano1_compi1.compiler.models.NodoExpresion;
import com.pablocompany.practicano1_compi1.compiler.models.enumsprogam.TipoConfiguracion;

//Clase que permite cambiar el color de una instruccion
/*P*/
public class NodoConfigColor extends NodoConfiguracion {

    private TipoConfiguracion tipo;
    private NodoColor color;
    private NodoExpresion nivel;
    /*P*/
    public NodoConfigColor(TipoConfiguracion tipo, NodoColor color, NodoExpresion nivel) {
        this.tipo = tipo ;
        this.color = color;
        this.nivel = nivel;
    }

    @Override
    public void aplicar(EntornoValores entorno) {
        int[] rgb = color.evaluar(entorno);
        int intensidad = (int) nivel.evaluar(entorno);

    }
}
