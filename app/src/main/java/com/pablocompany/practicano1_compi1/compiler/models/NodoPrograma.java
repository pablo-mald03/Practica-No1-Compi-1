package com.pablocompany.practicano1_compi1.compiler.models;

import com.pablocompany.practicano1_compi1.compiler.models.configuracion.NodoConfiguracion;

import java.util.List;

public class NodoPrograma {

        private List<NodoInstruccion> instrucciones;
        private List<NodoConfiguracion> configuraciones;

        public NodoPrograma(List<NodoInstruccion> instrucciones,
                            List<NodoConfiguracion> configuraciones) {
            this.instrucciones = instrucciones;
            this.configuraciones = configuraciones;
        }

        public List<NodoInstruccion> getInstrucciones() {
            return instrucciones;
        }

        public List<NodoConfiguracion> getConfiguraciones() {
            return configuraciones;
        }
}
