package com.pablocompany.practicano1_compi1.compiler.models.configuracion;

import com.pablocompany.practicano1_compi1.compiler.models.EntornoValores;
import com.pablocompany.practicano1_compi1.compiler.models.NodoExpresion;
import com.pablocompany.practicano1_compi1.compiler.models.TipoConfiguracion;
import com.pablocompany.practicano1_compi1.compiler.models.TipoFigura;

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

    @Override
    public void aplicar(EntornoValores entorno) {

    }
}
