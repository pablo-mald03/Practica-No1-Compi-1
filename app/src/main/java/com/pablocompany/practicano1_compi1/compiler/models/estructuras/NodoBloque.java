package com.pablocompany.practicano1_compi1.compiler.models.estructuras;

import com.pablocompany.practicano1_compi1.compiler.models.EntornoValores;
import com.pablocompany.practicano1_compi1.compiler.models.NodoEstructura;
import com.pablocompany.practicano1_compi1.compiler.models.NodoExpresion;
import com.pablocompany.practicano1_compi1.compiler.models.NodoInstruccion;
import com.pablocompany.practicano1_compi1.compiler.models.datos.Indexador;

import java.util.List;

public class NodoBloque extends NodoEstructura {

    private NodoExpresion condicion;
    public NodoBloque(NodoExpresion condicion, List<NodoInstruccion> instrucciones) {
        super(instrucciones);
        this.condicion = condicion;
    }

    @Override
    public void ejecutar(EntornoValores entorno) {

    }

    @Override
    public void indexar(Indexador ctx) {
        ctx.registrarEstructura(this);
    }

}
