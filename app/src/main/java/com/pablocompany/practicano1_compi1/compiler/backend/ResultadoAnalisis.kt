package com.pablocompany.practicano1_compi1.compiler.backend

import com.pablocompany.practicano1_compi1.compiler.backend.clases.NodoDiagrama
import com.pablocompany.practicano1_compi1.compiler.backend.clases.ReporteEstructuraControl
import com.pablocompany.practicano1_compi1.compiler.backend.clases.ReportesOperadores
import com.pablocompany.practicano1_compi1.compiler.models.ErrorAnalisis
import com.pablocompany.practicano1_compi1.compiler.models.NodoPrograma

data class ResultadoAnalisis(
    val exito: Boolean,
    val listaOperadores: List<ReportesOperadores>,
    val listaEstructurasControl: List<ReporteEstructuraControl>,
    val erroresLexicos: List<ErrorAnalisis>,
    val erroresSintacticos: List<ErrorAnalisis>,
    val codigoDiagrama: List<NodoDiagrama>,
    val esErrorCritico: Boolean = false
)
{

}