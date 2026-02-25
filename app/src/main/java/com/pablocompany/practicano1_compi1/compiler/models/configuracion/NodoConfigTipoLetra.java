package com.pablocompany.practicano1_compi1.compiler.models.configuracion;

import com.pablocompany.practicano1_compi1.compiler.models.EntornoValores;
import com.pablocompany.practicano1_compi1.compiler.models.NodoExpresion;
import com.pablocompany.practicano1_compi1.compiler.models.enumsprogam.TipoConfiguracion;
import com.pablocompany.practicano1_compi1.compiler.models.enumsprogam.TipoLetra;

/*Clase que permite configurar el tipo de letra de la instruccion*/
public class NodoConfigTipoLetra extends NodoConfiguracion {

    private TipoConfiguracion tipo;
    private TipoLetra tipoLetra;
    private NodoExpresion nivel;

    public NodoConfigTipoLetra(TipoConfiguracion tipo, String letra, NodoExpresion nivel) {
        this.tipoLetra = TipoLetra.valueOf(letra);
        this.nivel = nivel;
        this.tipo = tipo;
    }

    /*==========APARTADO DE METODOS GETTER==========*/
    public TipoConfiguracion getTipo() {
        return tipo;
    }

    public NodoExpresion getNivel() {
        return this.nivel;
    }

    public TipoLetra getTipoLetra() {
        return this.tipoLetra;
    }

    @Override
    public void aplicar(EntornoValores entorno) {

    }
}