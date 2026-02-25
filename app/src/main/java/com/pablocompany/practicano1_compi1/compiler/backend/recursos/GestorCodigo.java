package com.pablocompany.practicano1_compi1.compiler.backend.recursos;

import androidx.compose.ui.graphics.Color;

import com.pablocompany.practicano1_compi1.compiler.backend.clases.NodoDiagrama;
import com.pablocompany.practicano1_compi1.compiler.models.NodoInstruccion;
import com.pablocompany.practicano1_compi1.compiler.models.NodoPrograma;
import com.pablocompany.practicano1_compi1.compiler.models.TipoFigura;
import com.pablocompany.practicano1_compi1.compiler.models.configuracion.NodoConfiguracion;

import java.util.ArrayList;
import java.util.List;

//Clase padre que permite convertir cada una de las instrucciones para poder generar las vistas en el diagrama de flujo
public class GestorCodigo {

    NodoPrograma ast;
    List<NodoDiagrama> listaDiagrama;

    List<NodoInstruccion> listaInstrucciones;
    List<NodoConfiguracion> listaConfiguraciones;


    public GestorCodigo(NodoPrograma ast) {
        this.listaDiagrama = new ArrayList<>(500);
        this.ast = ast;
        this.listaInstrucciones = ast.getInstrucciones();
        this.listaConfiguraciones = ast.getConfiguraciones();
    }

    //Metodo principal que permite convertir el codigo devuelto por el parser a codigo para poder generar las vistas
    public void procesarCodigo(NodoPrograma ast) {

        //PENDIENTE FORMA DE ESTRAER COLORES
        /*int[] rgb = nodoColor.evaluar(entorno);

        int color = android.graphics.Color.rgb(
                rgb[0],
                rgb[1],
                rgb[2]
        );*/

        int rgb [] = {244, 67, 54};

        int color = android.graphics.Color.rgb(
                rgb[0],
                rgb[1],
                rgb[2]);

        int rgb2 [] = {33, 150, 243};

        int color2 = android.graphics.Color.rgb(
                rgb2[0],
                rgb2[1],
                rgb2[2]);


        NodoDiagrama inicio = new NodoDiagrama(0,1,1);
        inicio.setFigura(TipoFigura.RECTANGULO_REDONDEADO);
        inicio.setTexto("INICIO");
        inicio.setColorFondo(color2);
        inicio.setColorTexto(color);
        inicio.setSizeLetra(48);


        listaDiagrama.add(inicio);


        NodoDiagrama fin = new NodoDiagrama(0,2,1);
        fin.setFigura(TipoFigura.RECTANGULO_REDONDEADO);
        fin.setTexto("FIN");
        fin.setColorFondo(color2);
        fin.setColorTexto(color);
        fin.setSizeLetra(48);

        listaDiagrama.add(fin);

    }




    /*==========Metodos getters para poder obtener las listas por independiente==========*/
    public List<NodoDiagrama> getListaDiagrama() {
        return listaDiagrama;
    }

}



