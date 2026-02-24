package com.pablocompany.practicano1_compi1.compiler.models.configuracion;

import com.pablocompany.practicano1_compi1.compiler.models.EntornoValores;
import com.pablocompany.practicano1_compi1.compiler.models.NodoColor;
import com.pablocompany.practicano1_compi1.compiler.models.NodoExpresion;
import com.pablocompany.practicano1_compi1.compiler.models.TipoConfiguracion;

//Clase delegada para cambiar el fondo de la figura
public class NodoConfigFondo extends NodoConfiguracion {

    private TipoConfiguracion tipo;
    private NodoColor color;
    private NodoExpresion indice;
    /*P*/
    public NodoConfigFondo(TipoConfiguracion tipo, NodoColor color, NodoExpresion indice) {
        this.tipo = tipo ;
        this.color = color;
        this.indice = indice;
    }

    /*==========APARTADO DE METODOS GETTER==========*/
    public NodoColor getColor() {
        return color;
    }

    public NodoExpresion getIndice() {
        return indice;
    }

    public TipoConfiguracion getTipo() {
        return tipo;
    }

    /*==========APARTADO DE METODOS GETTER==========*/

    @Override
    public void aplicar(EntornoValores entorno) {
       /* int[] rgb = color.evaluar(entorno);
        int intensidad = (int) indice.evaluar(entorno);
*/
    }
}
