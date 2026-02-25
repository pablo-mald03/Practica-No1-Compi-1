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
    //Metodo que retorna su valor de color via arreglo
    @Override
    public int[] evaluar() {
        return new int[] {
                Integer.parseInt(this.red.getString()),
                Integer.parseInt(this.green.getString()),
                Integer.parseInt(this.blue.getString())
        };
    }

}
