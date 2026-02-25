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
    /*===METODOS GETTER===*/

    //Permite obtener el indice de aplicacion del estilo
    public int getIndice() {
        return Integer.parseInt(this.nivel.getString());
    }

    //Permite tomar el color de la configuracion
    public int [] getColorConfig(){
        return  this.color.evaluar();
    }
    //Metodo que permite obtener a que instruccion se le va a aplicar
    public TipoConfiguracion getTipoConfig(){
        return  this.tipo;
    }



    @Override
    public void aplicar() {


    }
}
