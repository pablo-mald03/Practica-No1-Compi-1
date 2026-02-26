package com.pablocompany.practicano1_compi1.compiler.backend.clases;

//Clase que permite crear un reporte de las estructuras de control
public class ReporteEstructuraControl {

    private String objeto;
    private String linea;
    private String condicion;

    public ReporteEstructuraControl( String objeto, String linea, String condicion) {
        this.condicion = condicion;
        this.linea = linea;
        this.objeto = objeto;
    }

    public String getCondicion() {
        return condicion;
    }

    public String getLinea() {
        return linea;
    }

    public String getObjeto() {
        return objeto;
    }
}
