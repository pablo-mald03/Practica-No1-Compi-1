package com.pablocompany.practicano1_compi1.compiler.backend

import com.pablocompany.practicano1_compi1.compiler.models.ErrorAnalisis
import com.pablocompany.practicano1_compi1.compiler.models.NodoPrograma

data class ResultadoAnalisis(
    val exito: Boolean,
    val listaOperadores: List<String>,
    val erroresLexicos: List<ErrorAnalisis>,
    val erroresSintacticos: List<ErrorAnalisis>,
    val codigoProcesado: NodoPrograma,
    val esErrorCritico: Boolean = false
)
{

}