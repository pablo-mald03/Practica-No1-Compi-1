package com.pablocompany.practicano1_compi1.compiler.models;

public class ErrorAnalisis {
    private String lexema;
    private int linea;
    private int columna;
    private String tipo;
    private String descripcion;

    public ErrorAnalisis(String lexema, int linea, int columna, String tipo, String descripcion) {
        this.lexema = lexema;
        this.linea = linea;
        this.columna = columna;
        this.tipo = tipo;
        this.descripcion = descripcion;
    }

    public String getLexema() {
        return this.lexema;
    }

    public void setLexema(String lexema) {
        this.lexema = lexema;
    }

    public int getLinea() {
        return this.linea;
    }

    public void setLinea(int linea) {
        this.linea = linea;
    }

    public int getColumna() {
        return this.columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    public String getTipo() {
        return this.tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
