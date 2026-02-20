package com.pablocompany.practicano1_compi1.compiler.backend

data class ResultadoAnalisis(
    val exito: Boolean,
    val erroresLexicos: List<String>,
    val erroresSintacticos: List<String>,
    val codigoProcesado: List<String>
)