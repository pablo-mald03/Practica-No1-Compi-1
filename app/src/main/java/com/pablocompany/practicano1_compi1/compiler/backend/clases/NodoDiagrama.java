package com.pablocompany.practicano1_compi1.compiler.backend.clases;

import com.pablocompany.practicano1_compi1.compiler.models.enumsprogam.TipoFigura;
import com.pablocompany.practicano1_compi1.compiler.models.enumsprogam.TipoLetra;


//Esta clase permite retornar a frontend todas las caracterisitcas e instrucciones que tiene que seguir cada figura que se va a crear
public class NodoDiagrama {

    /*Atributos*/
    private String texto;
    private TipoFigura figura;
    private int colorFondo;
    private int colorTexto;
    private TipoLetra tipoLetra;
    private double sizeLetra;
    private int nivel;
    private int indice;
    private int subIndice;

    public NodoDiagrama(int nivel, int indice, int subIndice, String texto) {
        this.nivel = nivel;
        this.indice = indice;
        this.subIndice = subIndice;
        this.texto = texto;
    }
    /*Metodos Getter y setter*/
    public TipoFigura getFigura() {
        return figura;
    }

    public void setFigura(TipoFigura figura) {
        this.figura = figura;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public TipoLetra getTipoLetra() {
        return tipoLetra;
    }

    public void setTipoLetra(TipoLetra tipoLetra) {
        this.tipoLetra = tipoLetra;
    }

    public double getSizeLetra() {
        return sizeLetra;
    }

    public void setSizeLetra(double sizeLetra) {
        this.sizeLetra = sizeLetra;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getIndice() {
        return indice;
    }

    public void setIndice(int indice) {
        this.indice = indice;
    }

    public int getSubIndice() {
        return subIndice;
    }

    public void setSubIndice(int subIndice) {
        this.subIndice = subIndice;
    }

    public int getColorFondo() {
        return colorFondo;
    }

    public void setColorFondo(int colorFondo) {
        this.colorFondo = colorFondo;
    }

    public int getColorTexto() {
        return colorTexto;
    }

    public void setColorTexto(int colorTexto) {
        this.colorTexto = colorTexto;
    }
}
