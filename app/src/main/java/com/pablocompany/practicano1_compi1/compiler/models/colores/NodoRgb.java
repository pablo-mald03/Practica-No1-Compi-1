package com.pablocompany.practicano1_compi1.compiler.models.colores;

import com.pablocompany.practicano1_compi1.compiler.models.EntornoValores;
import com.pablocompany.practicano1_compi1.compiler.models.NodoColor;
import com.pablocompany.practicano1_compi1.compiler.models.NodoExpresion;

/*P*/
public class NodoRgb extends NodoColor {

    private NodoExpresion red;
    private NodoExpresion green;
    private NodoExpresion blue;

    public NodoRgb(NodoExpresion r, NodoExpresion g, NodoExpresion b) {
        this.red = r;
        this.green = g;
        this.blue = b;
    }
    @Override
    public int[] evaluar(EntornoValores entorno) {
        return new int[] {
                (int) red.evaluar(entorno),
                (int) green.evaluar(entorno),
                (int) blue.evaluar(entorno)
        };
    }

}
