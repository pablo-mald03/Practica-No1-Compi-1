package com.pablocompany.practicano1_compi1.compiler.models.configuracion;

import com.pablocompany.practicano1_compi1.compiler.models.NodoColor;
import com.pablocompany.practicano1_compi1.compiler.models.NodoExpresion;
import com.pablocompany.practicano1_compi1.compiler.models.enumsprogam.TipoConfiguracion;

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

    /*=====GETTERS ESPECIALES QUE PERMITEN OBTENER EL VALOR DEL NODO===========*/
    public NodoExpresion getExpresionIndice() {
        return indice;
    }
    //Metodo que retorna el nodo del color
    public NodoColor getNodoColor() {
        return color;
    }
    /*=====GETTERS ESPECIALES QUE PERMITEN OBTENER EL VALOR DEL NODO===========*/

    /*==========APARTADO DE METODOS GETTER==========*/

    //Permite obtener el indice de aplicacion del estilo
    public int getIndice() {
        return this.indice.getValorEntero();
    }

    //Permite tomar el color de la configuracion
    public int [] getColorConfig(){
        return  this.color.evaluar();
    }

    //Metodo que permite obtener a que instruccion se le va a aplicar
    public TipoConfiguracion getTipoConfig() {
        return tipo;
    }

    /*==========APARTADO DE METODOS GETTER==========*/

    @Override
    public void aplicar() {

    }
}
