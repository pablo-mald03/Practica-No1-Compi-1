package com.pablocompany.practicano1_compi1.compiler.models;

import com.pablocompany.practicano1_compi1.compiler.models.configuracion.NodoConfiguracion;
import com.pablocompany.practicano1_compi1.compiler.models.datos.Indexador;

import java.util.List;

public class NodoPrograma {

    private List<NodoInstruccion> instrucciones;
    private List<NodoConfiguracion> configuraciones;

    public NodoPrograma(List<NodoInstruccion> instrucciones,
                        List<NodoConfiguracion> configuraciones) {
        this.instrucciones = instrucciones;
        this.configuraciones = configuraciones;
    }

    //======APARTADO DE METODOS GETTER Y SETTER=======
    public List<NodoInstruccion> getInstrucciones() {

        return instrucciones;
    }

    public List<NodoConfiguracion> getConfiguraciones() {
        return configuraciones;
    }

    public void setConfiguraciones(List<NodoConfiguracion> configuraciones) {
        this.configuraciones = configuraciones;
    }

    public void setInstrucciones(List<NodoInstruccion> instrucciones) {
        this.instrucciones = instrucciones;
    }
    //======FIN DEL APARTADO DE METODOS GETTER Y SETTER=======

    //======APARTADO DE METODOS DELEGADOS A LA CLASE NodoPrograma=======
    //Metodo que indexa las instruccionde de bloques
    public void indexarInstrucciones() {

        Indexador index = new Indexador();
        for (NodoInstruccion nodo: instrucciones) {
            nodo.indexar(index);
        }
    }
    //======APARTADO DE METODOS DELEGADOS A LA CLASE NodoPrograma=======
}
