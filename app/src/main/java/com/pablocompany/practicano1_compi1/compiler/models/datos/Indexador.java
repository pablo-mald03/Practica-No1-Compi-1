package com.pablocompany.practicano1_compi1.compiler.models.datos;

import com.pablocompany.practicano1_compi1.compiler.models.NodoEstructura;
import com.pablocompany.practicano1_compi1.compiler.models.NodoInstruccion;
import com.pablocompany.practicano1_compi1.compiler.models.estructuras.NodoMientras;
import com.pablocompany.practicano1_compi1.compiler.models.estructuras.NodoSi;

import java.util.HashMap;
import java.util.Map;

//Clase utilizada para poder indexar cada una de las instrucciones detectadas
/*Esto permite reducir la complejidad del codigo*/
public class Indexador {
    private int contadorGlobal = 0;
    private Map<String, Integer> contadores = new HashMap<>();

    public void registrarEstructura(NodoInstruccion nodo) {
        contadorGlobal++;
        String categoria;
        if (nodo instanceof NodoSi) categoria = "SI";
        else if (nodo instanceof NodoMientras) categoria = "MIENTRAS";
        else categoria = "BLOQUE";

        int interno = contadores.getOrDefault(categoria, 0) + 1;
        contadores.put(categoria, interno);

        nodo.setIndices(contadorGlobal, interno);
    }

}
