package com.pablocompany.practicano1_compi1.compiler.backend.recursos;

import com.pablocompany.practicano1_compi1.compiler.backend.clases.NodoDiagrama;
import com.pablocompany.practicano1_compi1.compiler.models.NodoInstruccion;
import com.pablocompany.practicano1_compi1.compiler.models.NodoPrograma;
import com.pablocompany.practicano1_compi1.compiler.models.NodoSimple;
import com.pablocompany.practicano1_compi1.compiler.models.enumsprogam.TipoFigura;
import com.pablocompany.practicano1_compi1.compiler.models.configuracion.NodoConfiguracion;
import com.pablocompany.practicano1_compi1.compiler.models.estructuras.NodoBloque;
import com.pablocompany.practicano1_compi1.compiler.models.estructuras.NodoMientras;
import com.pablocompany.practicano1_compi1.compiler.models.estructuras.NodoSi;
import com.pablocompany.practicano1_compi1.compiler.models.estrucutrassimples.*;

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


        NodoDiagrama inicio = new NodoDiagrama(0, -1, -1, "INICIO");
        inicio.setFigura(TipoFigura.RECTANGULO_REDONDEADO);
        inicio.setColorFondo(colorFondoPrograma);
        inicio.setColorTexto(colorLetraPrograma);
        inicio.setSizeLetra(50);
        listaDiagrama.add(inicio);

        procesarInstrucciones();

        NodoDiagrama fin = new NodoDiagrama(0, -1, -1, "FIN");
        fin.setFigura(TipoFigura.RECTANGULO_REDONDEADO);
        fin.setColorFondo(colorFondoPrograma);
        fin.setColorTexto(colorLetraPrograma);
        fin.setSizeLetra(50);
        listaDiagrama.add(fin);
    }

    //==========Metodos para poder repartir todas las instrucciones procesadas en el parser=========
    /*Metodo principal delegado para procesar las instrucciones obtenidas del ast (parser)*/
    private void procesarInstrucciones() {

        /*Metodo encargado de terminar de empaquetar todo*/
        empaquetarDatos();
        this.ast.setInstrucciones(this.listaInstrucciones);
        this.ast.indexarInstrucciones();

        this.listaInstrucciones = this.ast.getInstrucciones();

        for (int i = 0; i < this.listaInstrucciones.size(); i++) {
            NodoInstruccion nodo = this.listaInstrucciones.get(i);
            instanciarFigura(nodo);
        }

        //PENDIENTE FORMA DE ESTRAER COLORES
        /*int[] rgb = nodoColor.evaluar(entorno);

        int color = android.graphics.Color.rgb(
                rgb[0],
                rgb[1],
                rgb[2]
        );*/

    }

    /*METODO DELEGADO PARA PODER INSTANCIAR LAS FIGURAS DEL DIAGRAMA*/
    void instanciarFigura(NodoInstruccion nodo) {

        if(nodo instanceof NodoSi){
            NodoSi nodoSi = (NodoSi) nodo;
            NodoBloque bloque = nodoSi.getBloque();
            this.listaDiagrama.add(new NodoDiagrama(0,nodoSi.getIndiceGlobal(),nodoSi.getIndiceInterno(),nodoSi.getString()));
            this.listaDiagrama.add(new NodoDiagrama(1,bloque.getIndiceGlobal(),bloque.getIndiceInterno(),bloque.getBloqueString()));
            return;
        }
        else if(nodo instanceof NodoMientras){
            NodoMientras nodoMientras = (NodoMientras) nodo;
            NodoBloque bloque = nodoMientras.getBloque();

            this.listaDiagrama.add(new NodoDiagrama(0,nodoMientras.getIndiceGlobal(),nodoMientras.getIndiceInterno(),nodoMientras.getString()));

            this.listaDiagrama.add(new NodoDiagrama(1,bloque.getIndiceGlobal(),bloque.getIndiceInterno(),bloque.getBloqueString()));
            return;
        }
        else if(nodo instanceof NodoBloque){
            NodoBloque nodoBloque = (NodoBloque) nodo;
            this.listaDiagrama.add(new NodoDiagrama(0,nodoBloque.getIndiceGlobal(),nodoBloque.getIndiceInterno(),nodoBloque.getBloqueString()));
        }
    }

    /*Metodo delegado para poder limpiar todo lo que genero el parser*/
    public void empaquetarDatos() {

        List<NodoInstruccion> listaLimpiada = new ArrayList<>();


        for (int i = 0; i < this.listaInstrucciones.size(); i++) {
            NodoInstruccion nodo = this.listaInstrucciones.get(i);

            if (nodo instanceof NodoSimple) {

                List<NodoInstruccion> listaAux = new ArrayList<>();

                for (int j = i; j < this.listaInstrucciones.size(); j++) {

                    NodoInstruccion nodoAux = this.listaInstrucciones.get(j);
                    if (!(nodoAux instanceof NodoSimple)) {
                        break;
                    }
                    listaAux.add(nodoAux);
                    i = j;
                }
                NodoBloque nodoBloque = new NodoBloque(listaAux);
                listaLimpiada.add(nodoBloque);
            } else {
                listaLimpiada.add(nodo);
            }

        }

        this.listaInstrucciones = listaLimpiada;
    }

    //==========Fin del apartado de Metodos para poder repartir todas las instrucciones procesadas en el parser=========


    /*==========Metodos getters para poder obtener las listas por independiente==========*/
    public List<NodoDiagrama> getListaDiagrama() {
        return listaDiagrama;
    }

}



