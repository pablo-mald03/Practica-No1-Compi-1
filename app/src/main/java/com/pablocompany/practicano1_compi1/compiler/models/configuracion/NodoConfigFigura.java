package com.pablocompany.practicano1_compi1.compiler.models.configuracion;

import com.pablocompany.practicano1_compi1.compiler.models.NodoExpresion;
import com.pablocompany.practicano1_compi1.compiler.models.enumsprogam.TipoConfiguracion;
import com.pablocompany.practicano1_compi1.compiler.models.enumsprogam.TipoFigura;

//Clase que permite cambiar la configuracion de la figura
public class NodoConfigFigura extends NodoConfiguracion {

    private TipoConfiguracion tipo;
    private TipoFigura figura;
    private NodoExpresion nivel;

    public NodoConfigFigura(TipoConfiguracion tipo, String figura, NodoExpresion nivel) {
        this.figura = TipoFigura.valueOf(figura);
        this.nivel = nivel;
        this.tipo = tipo;
    }

    /*==========APARTADO DE METODOS GETTER==========*/
    //Metodo que permite obtener a que instruccion se le va a aplicar
    public TipoConfiguracion getTipoConfig() {
        return tipo;
    }

    //Metodo que permite retornar el indice de aplicacion del estilo
    public int getIndice() {
        return this.nivel.getValorEntero();
    }
    //Metodo que permite obtener el tipo de letra
    public TipoFigura getTipoFigura() {
        return this.figura;
    }

    @Override
    public void aplicar() {

    }
}
