package com.pablocompany.practicano1_compi1.compiler.backend.recursos;

import com.pablocompany.practicano1_compi1.compiler.models.enumsprogam.TipoFigura;
import com.pablocompany.practicano1_compi1.compiler.models.enumsprogam.TipoLetra;

//Clase que define la configuracion predeterminada para las figuras
public class ConfiguracionPredeterminada {

    //Colores predeterminados de bloque
    private final int RGB_BLOQUE_LETRA[] = {255, 255, 255};
    private final int RGB_BLOQUE_FONDO[] = {15, 3, 71};

    //Colores predeterminados del Si
    private final int RGB_SI_LETRA[] = {255, 255, 255};
    private final int RGB_SI_FONDO[] = {115, 0, 72};

    //Colores predeterminados del Mientras
    private final int RGB_MIENTRAS_LETRA[] = {255, 255, 255};
    private final int RGB_MIENTRAS_FONDO[] = {14, 105, 3};

    //Apartado de figuras predeterminadas
    private final TipoFigura FIGURA_BLOQUE = TipoFigura.PARALELOGRAMO;
    private final TipoFigura FIGURA_SI = TipoFigura.ROMBO;
    private final TipoFigura FIGURA_MIENTRAS = TipoFigura.CIRCULO;

    //APARTADO LETRA PREDETERMINADA DE FIGURAS
    private final TipoLetra LETRA_BLOQUE = TipoLetra.ARIAL;
    private final TipoLetra LETRA_SI = TipoLetra.TIMES_NEW_ROMAN;
    private final TipoLetra LETRA_MIENTRAS = TipoLetra.TIMES_NEW_ROMAN;

    //APARTADO TAMANIO DE LETRA PREDETERMINADA DE INSTRUCCIONES
    private final double SIZE_BLOQUE = 12;
    private final double SIZE_SI = 15;
    private final double SIZE_MIENTRAS = 15;


    public ConfiguracionPredeterminada() {

    }

    /*===APARTADO DE METODOS GETTER====*/
    public double getSizeMientras() {
        return SIZE_MIENTRAS;
    }

    public double getSizeSi() {
        return SIZE_SI;
    }

    public double getSizeBloque() {
        return SIZE_BLOQUE;
    }

    public TipoLetra getLetraMientras() {
        return LETRA_MIENTRAS;
    }

    public TipoLetra getLetraSi() {
        return LETRA_SI;
    }

    public TipoLetra getLetraBloque() {
        return LETRA_BLOQUE;
    }

    public TipoFigura getFiguraMientras() {
        return FIGURA_MIENTRAS;
    }

    public TipoFigura getFiguraSi() {
        return FIGURA_SI;
    }

    public TipoFigura getFiguraBloque() {
        return FIGURA_BLOQUE;
    }

    public int[] getRgbMientrasFondo() {
        return RGB_MIENTRAS_FONDO;
    }

    public int[] getRgbMientrasLetra() {
        return RGB_MIENTRAS_LETRA;
    }

    public int[] getRgbSiFondo() {
        return RGB_SI_FONDO;
    }

    public int[] getRgbSiLetra() {
        return RGB_SI_LETRA;
    }

    public int[] getRgbBloqueFondo() {
        return RGB_BLOQUE_FONDO;
    }

    public int[] getRgbBloqueLetra() {
        return RGB_BLOQUE_LETRA;
    }
}
