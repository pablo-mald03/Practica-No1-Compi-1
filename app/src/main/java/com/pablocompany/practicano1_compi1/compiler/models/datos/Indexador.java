package com.pablocompany.practicano1_compi1.compiler.models.datos;

import com.pablocompany.practicano1_compi1.compiler.models.NodoEstructura;

import java.util.HashMap;
import java.util.Map;

//Clase utilizada para poder indexar cada una de las instrucciones detectadas
/*Esto permite reducir la complejidad del codigo*/
public class Indexador {

    //Evita andar casteando cuando solo se requiere ordenar
    private int contadorGlobal = 0;
    //hashmap utilizado para poder ir tomando en cuenta cada una de las instancias y enumerarlas de forma independiente (Sin castear)
    private Map<Class<?>, Integer> contadorPorTipo = new HashMap<>();


    //Permite indexar a cada instruccion de la jerarquia de NodoInstruccion
    public void registrarEstructura(NodoEstructura nodo) {
        contadorGlobal++;
        Class<?> tipo = nodo.getClass();
        int interno = contadorPorTipo.getOrDefault(tipo, 0) + 1;
        nodo.setIndices(contadorGlobal, interno);
    }

}
