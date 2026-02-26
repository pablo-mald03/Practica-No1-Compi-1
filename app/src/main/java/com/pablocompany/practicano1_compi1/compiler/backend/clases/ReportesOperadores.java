package com.pablocompany.practicano1_compi1.compiler.backend.clases;

//Clase delegada para poder mostrar los reportes de ocurrencias matematicas
public class ReportesOperadores {

    //Atributos
    private String operador;
    private int linea;
    private int columna;
    private String ocurrencia;

    public ReportesOperadores(String operador, int columna, int linea, String ocurrencia) {
        this.ocurrencia = ocurrencia;
        this.columna = columna;
        this.linea = linea;
        this.operador = operador;
    }

    //Metodos getter y setters
    public String getOcurrencia() {
        return ocurrencia;
    }

    public int getColumna() {
        return columna;
    }

    public int getLinea() {
        return linea;
    }

    public String getOperador() {
        return operador;
    }
}
