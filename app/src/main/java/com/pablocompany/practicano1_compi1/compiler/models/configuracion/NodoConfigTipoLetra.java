package com.pablocompany.practicano1_compi1.compiler.models.configuracion;

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
    //Metodo que permite obtener a que instruccion se le va a aplicar
    public TipoConfiguracion getTipo() {
        return tipo;
    }

    //Metodo que permite retornar el indice de aplicacion del estilo
    public int getIndice() {
        return this.nivel.getValorEntero();
    }
    //Metodo que permite obtener el tipo de letra
    public TipoLetra getTipoLetra() {
        return this.tipoLetra;
    }

    @Override
    public void aplicar() {

    }
}