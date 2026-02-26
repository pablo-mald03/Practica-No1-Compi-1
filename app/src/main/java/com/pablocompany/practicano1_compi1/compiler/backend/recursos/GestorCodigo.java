package com.pablocompany.practicano1_compi1.compiler.backend.recursos;

import com.pablocompany.practicano1_compi1.compiler.backend.clases.NodoDiagrama;
import com.pablocompany.practicano1_compi1.compiler.backend.clases.ReporteEstructuraControl;
import com.pablocompany.practicano1_compi1.compiler.backend.clases.ReportesOperadores;
import com.pablocompany.practicano1_compi1.compiler.models.NodoExpresion;
import com.pablocompany.practicano1_compi1.compiler.models.NodoInstruccion;
import com.pablocompany.practicano1_compi1.compiler.models.NodoPrograma;
import com.pablocompany.practicano1_compi1.compiler.models.NodoSimple;
import com.pablocompany.practicano1_compi1.compiler.models.configuracion.NodoConfigDefault;
import com.pablocompany.practicano1_compi1.compiler.models.enumsprogam.TipoConfiguracion;
import com.pablocompany.practicano1_compi1.compiler.models.enumsprogam.TipoFigura;
import com.pablocompany.practicano1_compi1.compiler.models.configuracion.NodoConfiguracion;
import com.pablocompany.practicano1_compi1.compiler.models.enumsprogam.TipoLetra;
import com.pablocompany.practicano1_compi1.compiler.models.estructuras.NodoBloque;
import com.pablocompany.practicano1_compi1.compiler.models.estructuras.NodoMientras;
import com.pablocompany.practicano1_compi1.compiler.models.estructuras.NodoSi;
import com.pablocompany.practicano1_compi1.compiler.models.estrucutrassimples.*;
import com.pablocompany.practicano1_compi1.compiler.models.operadores.logicos.NodoAnd;
import com.pablocompany.practicano1_compi1.compiler.models.operadores.logicos.NodoNot;
import com.pablocompany.practicano1_compi1.compiler.models.operadores.logicos.NodoOr;
import com.pablocompany.practicano1_compi1.compiler.models.operadores.matematicos.NodoDivision;
import com.pablocompany.practicano1_compi1.compiler.models.operadores.matematicos.NodoMultiplicacion;
import com.pablocompany.practicano1_compi1.compiler.models.operadores.matematicos.NodoResta;
import com.pablocompany.practicano1_compi1.compiler.models.operadores.matematicos.NodoSuma;
import com.pablocompany.practicano1_compi1.compiler.models.operadores.relacionales.NodoDiferente;
import com.pablocompany.practicano1_compi1.compiler.models.operadores.relacionales.NodoIgual;
import com.pablocompany.practicano1_compi1.compiler.models.operadores.relacionales.NodoMayor;
import com.pablocompany.practicano1_compi1.compiler.models.operadores.relacionales.NodoMayorIgual;
import com.pablocompany.practicano1_compi1.compiler.models.operadores.relacionales.NodoMenor;
import com.pablocompany.practicano1_compi1.compiler.models.operadores.relacionales.NodoMenorIgual;

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
    List<ReportesOperadores> listaOperadoresMatematicos;


    //-------LISTAS DE REPORTES PRINCIPALES---------
    List<ReporteEstructuraControl> listaEstructurasControl;

    private GestorConfiguracion configuracion;

    //Constructor de la clase que permite inicializar el ast
    public GestorCodigo(NodoPrograma ast) {
        this.listaDiagrama = new ArrayList<>(500);
        this.listaEstructurasControl = new ArrayList<>(500);
        this.listaOperadoresMatematicos = new ArrayList<>(500);
        this.ast = ast;
        this.listaInstrucciones = ast.getInstrucciones();
        this.listaConfiguraciones = ast.getConfiguraciones();
    }

    //Metodo principal que permite convertir el codigo devuelto por el parser a codigo para poder generar las vistas
    public void procesarCodigo() {

        //Codigo quemado de inicio y fin de programa
        int colorLetraPrograma = android.graphics.Color.rgb(RGB_FONDO_LETRA[0], RGB_FONDO_LETRA[1], RGB_FONDO_LETRA[2]);
        int colorFondoPrograma = android.graphics.Color.rgb(RGB_FONDO_PROGRAMA[0], RGB_FONDO_PROGRAMA[1], RGB_FONDO_PROGRAMA[2]);


        NodoDiagrama inicio = new NodoDiagrama(0, -1, -1, "INICIO", TipoConfiguracion.INICIO);
        inicio.setFigura(TipoFigura.RECTANGULO_REDONDEADO);
        inicio.setColorFondo(colorFondoPrograma);
        inicio.setColorTexto(colorLetraPrograma);
        inicio.setSizeLetra(50);
        inicio.setTipoLetra(TipoLetra.TIMES_NEW_ROMAN);
        listaDiagrama.add(inicio);

        procesarInstrucciones();

        NodoDiagrama fin = new NodoDiagrama(0, -1, -1, "FIN", TipoConfiguracion.FIN);
        fin.setFigura(TipoFigura.RECTANGULO_REDONDEADO);
        fin.setColorFondo(colorFondoPrograma);
        fin.setColorTexto(colorLetraPrograma);
        fin.setTipoLetra(TipoLetra.TIMES_NEW_ROMAN);
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
        darEstilos();
        armarEstructuraControl();
        armarOperadoresMatematicos();
    }

    /*-----------------REGION DE METODOS QUE PERMITE --------------------*/
    //Metodo que permite generar el reporte de estrucutras de control
    private void armarEstructuraControl() {
        for (int i = 0; i < this.listaInstrucciones.size(); i++) {
            NodoInstruccion nodo = this.listaInstrucciones.get(i);
            if (nodo instanceof NodoSi) {
                NodoSi nodoSi = (NodoSi) nodo;
                this.listaEstructurasControl.add(new ReporteEstructuraControl("SI", String.valueOf(nodoSi.getCondicion().getLinea()), nodoSi.getString()));
            }
            if (nodo instanceof NodoMientras) {
                NodoMientras nodoMientras = (NodoMientras) nodo;
                this.listaEstructurasControl.add(new ReporteEstructuraControl("MIENTRAS", String.valueOf(nodoMientras.getCondicion().getLinea()), nodoMientras.getString()));
            }
        }
    }

    //Metodo que permite generar el reporte de operadores matematicos
    private void armarOperadoresMatematicos() {
        for (int i = 0; i < this.listaInstrucciones.size(); i++) {
            NodoInstruccion nodo = this.listaInstrucciones.get(i);
            if (nodo instanceof NodoSi) {
                NodoSi nodoSi = (NodoSi) nodo;
                NodoExpresion nodoExpresion = nodoSi.getCondicion();
                this.evaluarCondicion(nodoExpresion);
                NodoBloque bloqueNodo = nodoSi.getBloque();
                this.agregarOperador(bloqueNodo);
            }
            if (nodo instanceof NodoMientras) {
                NodoMientras nodoMientras = (NodoMientras) nodo;
                NodoExpresion nodoExpresion = nodoMientras.getCondicion();
                this.evaluarCondicion(nodoExpresion);
                NodoBloque bloque = nodoMientras.getBloque();
                this.agregarOperador(bloque);
            }
            if (nodo instanceof NodoBloque) {
                NodoBloque nodoBloque = (NodoBloque) nodo;
                this.agregarOperador(nodoBloque);
            }
        }
    }

    /*===METODO INTERMEDIO PARA EVALUAR LAS EXPRESIONES QUE ESTAN DENTRO DE UNA CONDICION DE UNA ESTRUCTURA DE CONTROL====*/
    private void evaluarCondicion(NodoExpresion condicion) {

        if (condicion instanceof NodoAnd) {
            NodoAnd nodoAnd = (NodoAnd) condicion;
            this.obtenerInformacionNodo(nodoAnd.getIzquierda());
            this.obtenerInformacionNodo(nodoAnd.getDerecha());
            return;
        }
        if (condicion instanceof NodoOr) {
            NodoOr nodoOr = (NodoOr) condicion;
            this.obtenerInformacionNodo(nodoOr.getIzquierda());
            this.obtenerInformacionNodo(nodoOr.getDerecha());
            return;
        }
        if (condicion instanceof NodoNot) {
            NodoNot nodoNot = (NodoNot) condicion;
            this.obtenerInformacionNodo(nodoNot.getExpresion());
            return;
        }
        if (condicion instanceof NodoIgual) {
            NodoIgual nodoIgual = (NodoIgual) condicion;
            this.obtenerInformacionNodo(nodoIgual.getIzquierda());
            this.obtenerInformacionNodo(nodoIgual.getDerecha());
            return;
        }
        if (condicion instanceof NodoMayor) {
            NodoMayor nodoMayor = (NodoMayor) condicion;
            this.obtenerInformacionNodo(nodoMayor.getIzquierda());
            this.obtenerInformacionNodo(nodoMayor.getDerecha());
            return;
        }
        if (condicion instanceof NodoMenor) {
            NodoMenor nodoMenor = (NodoMenor) condicion;
            this.obtenerInformacionNodo(nodoMenor.getIzquierda());
            this.obtenerInformacionNodo(nodoMenor.getDerecha());
            return;
        }
        if (condicion instanceof NodoMayorIgual) {
            NodoMayorIgual nodoMayorIgual = (NodoMayorIgual) condicion;
            this.obtenerInformacionNodo(nodoMayorIgual.getIzquierda());
            this.obtenerInformacionNodo(nodoMayorIgual.getDerecha());
            return;
        }
        if (condicion instanceof NodoMenorIgual) {
            NodoMenorIgual nodoMenorIgual = (NodoMenorIgual) condicion;
            this.obtenerInformacionNodo(nodoMenorIgual.getIzquierda());
            this.obtenerInformacionNodo(nodoMenorIgual.getDerecha());
            return;
        }
        if (condicion instanceof NodoDiferente) {
            NodoDiferente nodoDiferente = (NodoDiferente) condicion;
            this.obtenerInformacionNodo(nodoDiferente.getIzquierda());
            this.obtenerInformacionNodo(nodoDiferente.getDerecha());
        }

    }

    /*===METODO INTERMEDIO PARA EVALUAR LAS EXPRESIONES QUE ESTAN DENTRO DE UNA CONDICION DE UNA ESTRUCTURA DE CONTROL====*/

    //Metodo que sirve para poder ir agregando los operadores encontrados
    private void agregarOperador(NodoBloque nodoBloque) {
        for (int i = 0; i < nodoBloque.getInstrucciones().size(); i++) {
            NodoInstruccion nodo = nodoBloque.getInstrucciones().get(i);
            if (nodo instanceof NodoAsignacion) {
                NodoAsignacion nodoAsignacion = (NodoAsignacion) nodo;
                this.obtenerInformacionNodo(nodoAsignacion.getExpresion());
                return;
            }
            if (nodo instanceof NodoDeclaracion) {
                NodoDeclaracion nodoDeclaracion = (NodoDeclaracion) nodo;
                this.obtenerInformacionNodo(nodoDeclaracion.getExpresion());
                return;
            }
            if (nodo instanceof NodoMostrar) {
                NodoMostrar nodoMostrar = (NodoMostrar) nodo;
                this.obtenerInformacionNodo(nodoMostrar.getExpresion());
            }
        }
    }

    //Submetodo delegado para poder obtener la informacion de los nodos
    private void obtenerInformacionNodo(NodoExpresion expresion) {
        if (expresion instanceof NodoSuma) {
            NodoSuma nodoSuma = (NodoSuma) expresion;
            this.listaOperadoresMatematicos.add(new ReportesOperadores("SUMA", nodoSuma.getLinea(), nodoSuma.getColumna(), nodoSuma.getString()));
            return;
        }
        if (expresion instanceof NodoResta) {
            NodoResta nodoResta = (NodoResta) expresion;
            this.listaOperadoresMatematicos.add(new ReportesOperadores("RESTA", nodoResta.getLinea(), nodoResta.getColumna(), nodoResta.getString()));
            return;
        }
        if (expresion instanceof NodoMultiplicacion) {
            NodoMultiplicacion nodoMultiplicacion = (NodoMultiplicacion) expresion;
            this.listaOperadoresMatematicos.add(new ReportesOperadores("MULTIPLICACION", nodoMultiplicacion.getLinea(), nodoMultiplicacion.getColumna(), nodoMultiplicacion.getString()));
            return;
        }
        if (expresion instanceof NodoDivision) {
            NodoDivision nodoDivision = (NodoDivision) expresion;
            this.listaOperadoresMatematicos.add(new ReportesOperadores("DIVISION", nodoDivision.getLinea(), nodoDivision.getColumna(), nodoDivision.getString()));
        }

    }
    /*-----------------FIN DE LA REGION DE METODOS QUE PERMITE --------------------*/

    /*METODO UTILIZADO PARA DAR LA CONFIGURACION PERSONALIZADA*/
    private void darEstilos() {
        this.configuracion = new GestorConfiguracion(this.listaConfiguraciones);
        this.listaDiagrama = configuracion.setEstilos(this.listaDiagrama);
    }

    /*METODO DELEGADO PARA PODER INSTANCIAR LAS FIGURAS DEL DIAGRAMA*/
    void instanciarFigura(NodoInstruccion nodo) {

        if (nodo instanceof NodoSi) {
            NodoSi nodoSi = (NodoSi) nodo;
            NodoBloque bloque = nodoSi.getBloque();
            this.listaDiagrama.add(new NodoDiagrama(0, nodoSi.getIndiceGlobal(), nodoSi.getIndiceInterno(), nodoSi.getString(), TipoConfiguracion.INSTRUCCION_SI));
            this.listaDiagrama.add(new NodoDiagrama(1, bloque.getIndiceGlobal(), bloque.getIndiceInterno(), bloque.getBloqueString(), TipoConfiguracion.INSTRUCCION_BLOQUE));
            return;
        } else if (nodo instanceof NodoMientras) {
            NodoMientras nodoMientras = (NodoMientras) nodo;
            NodoBloque bloque = nodoMientras.getBloque();

            this.listaDiagrama.add(new NodoDiagrama(0, nodoMientras.getIndiceGlobal(), nodoMientras.getIndiceInterno(), nodoMientras.getString(), TipoConfiguracion.INSTRUCCION_MIENTRAS));

            this.listaDiagrama.add(new NodoDiagrama(1, bloque.getIndiceGlobal(), bloque.getIndiceInterno(), bloque.getBloqueString(), TipoConfiguracion.INSTRUCCION_BLOQUE));
            return;
        } else if (nodo instanceof NodoBloque) {
            NodoBloque nodoBloque = (NodoBloque) nodo;
            this.listaDiagrama.add(new NodoDiagrama(0, nodoBloque.getIndiceGlobal(), nodoBloque.getIndiceInterno(), nodoBloque.getBloqueString(), TipoConfiguracion.INSTRUCCION_BLOQUE));
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

    public List<ReporteEstructuraControl> getListaEstructurasControl() {
        return listaEstructurasControl;
    }

    public List<ReportesOperadores> getListaOperadoresMatematicos() {
        return listaOperadoresMatematicos;
    }
}