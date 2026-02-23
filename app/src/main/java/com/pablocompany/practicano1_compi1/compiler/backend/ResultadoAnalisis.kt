package com.pablocompany.practicano1_compi1.compiler.backend

import com.pablocompany.practicano1_compi1.compiler.models.ErrorAnalisis

data class ResultadoAnalisis(
    val exito: Boolean,
    val listaOperadores: List<String>,
    val erroresLexicos: List<ErrorAnalisis>,
    val erroresSintacticos: List<ErrorAnalisis>,
    val codigoProcesado: List<String>
)
{

}