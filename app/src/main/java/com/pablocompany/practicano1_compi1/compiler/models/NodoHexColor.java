package com.pablocompany.practicano1_compi1.compiler.models;

public class NodoHexColor extends NodoColor {

    private String hex;

    public NodoHexColor(String hex) {
        this.hex = hex;
    }

    @Override
    public int[] evaluar(EntornoValores entorno) {

        int red = Integer.parseInt(hex.substring(1,3), 16);
        int green = Integer.parseInt(hex.substring(3,5), 16);
        int blue = Integer.parseInt(hex.substring(5,7), 16);

        return new int[]{red, green, blue};
    }
}
