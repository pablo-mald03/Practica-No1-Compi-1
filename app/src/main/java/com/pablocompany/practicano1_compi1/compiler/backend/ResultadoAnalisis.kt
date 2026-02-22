package com.pablocompany.practicano1_compi1.compiler.backend

data class ResultadoAnalisis(
    val exito: Boolean,
    val listaOperadores: List<String>,
    val erroresDetectados: List<String>,
    val codigoProcesado: List<String>
)
{

}