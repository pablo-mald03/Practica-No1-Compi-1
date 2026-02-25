package com.pablocompany.practicano1_compi1.compiler.backend.recursos;

import com.pablocompany.practicano1_compi1.compiler.backend.clases.NodoDiagrama;
import com.pablocompany.practicano1_compi1.compiler.models.NodoInstruccion;
import com.pablocompany.practicano1_compi1.compiler.models.NodoPrograma;
import com.pablocompany.practicano1_compi1.compiler.models.enumsprogam.TipoFigura;
import com.pablocompany.practicano1_compi1.compiler.models.configuracion.NodoConfiguracion;

import java.util.ArrayList;
import java.util.List;

//Clase padre que permite convertir cada una de las instrucciones para poder generar las vistas en el diagrama de flujo
public class GestorCodigo {

    private final int RGB_FONDO_LETRA[] = {0, 0, 0};
    private final int RGB_FONDO_PROGRAMA[] = {5, 164, 181};
    NodoPrograma ast;
    List<NodoDiagrama> listaDiagrama;

    List<NodoInstruccion> listaInstrucciones;
    List<NodoConfiguracion> listaConfiguraciones;

    //Constructor de la clase que permite inicializar el ast
    public GestorCodigo(NodoPrograma ast) {
        this.listaDiagrama = new ArrayList<>(500);
        this.ast = ast;
        this.listaInstrucciones = ast.getInstrucciones();
        this.listaConfiguraciones = ast.getConfiguraciones();
    }

    //Metodo principal que permite convertir el codigo devuelto por el parser a codigo para poder generar las vistas
    public void procesarCodigo() {

        //Codigo quemado de inicio y fin de programa
        int colorLetraPrograma = android.graphics.Color.rgb(RGB_FONDO_LETRA[0], RGB_FONDO_LETRA[1], RGB_FONDO_LETRA[2]);
        int colorFondoPrograma = android.graphics.Color.rgb(RGB_FONDO_PROGRAMA[0], RGB_FONDO_PROGRAMA[1], RGB_FONDO_PROGRAMA[2]);


        NodoDiagrama inicio = new NodoDiagrama(0, 1, 1);
        inicio.setFigura(TipoFigura.RECTANGULO_REDONDEADO);
        inicio.setTexto("INICIO");
        inicio.setColorFondo(colorFondoPrograma);
        inicio.setColorTexto(colorLetraPrograma);
        inicio.setSizeLetra(48);
        listaDiagrama.add(inicio);

        procesarInstrucciones();

        NodoDiagrama fin = new NodoDiagrama(0, 2, 1);
        fin.setFigura(TipoFigura.RECTANGULO_REDONDEADO);
        fin.setTexto("FIN");
        fin.setColorFondo(colorFondoPrograma);
        fin.setColorTexto(colorLetraPrograma);
        fin.setSizeLetra(48);
        listaDiagrama.add(fin);
    }

    //==========Metodos para poder repartir todas las instrucciones procesadas en el parser=========
    /*Metodo principal delegado para procesar las instrucciones obtenidas del ast (parser)*/
    private void procesarInstrucciones() {



        //PENDIENTE FORMA DE ESTRAER COLORES
        /*int[] rgb = nodoColor.evaluar(entorno);

        int color = android.graphics.Color.rgb(
                rgb[0],
                rgb[1],
                rgb[2]
        );*/

    }
    //==========Fin del apartado de Metodos para poder repartir todas las instrucciones procesadas en el parser=========


    /*==========Metodos getters para poder obtener las listas por independiente==========*/
    public List<NodoDiagrama> getListaDiagrama() {
        return listaDiagrama;
    }

}



