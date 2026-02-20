package com.pablocompany.practicano1_compi1.domain.usecase

import com.pablocompany.practicano1_compi1.compiler.backend.ResultadoAnalisis
import java.io.StringReader

class AnalizarCodigoUseCase {


    //CODIGO PROVISIONALLLLLL POR COMPLETO PROVISIONALLLLL
    operator fun invoke(codigo: String): ResultadoAnalisis {


        val erroresLexicos = listOf<String>()
        val erroresSintacticos = listOf<String>()

        val codigoProcesado = listOf(
            "INICIO",
            "DECLARACION x = 10",
            "SI x > 5",
            "IMPRIMIR x",
            "FIN"
        )

        val exito = true

        return ResultadoAnalisis(
            exito = exito,
            erroresLexicos = erroresLexicos,
            listaOperadores = erroresSintacticos,
            codigoProcesado = codigoProcesado
        )
    }


    //Codigo pendiente CUANDO YA EXISTA UN PARSER Y LEXER
    /*operator fun invoke(codigo: String): ResultadoAnalisis {

        if (codigo.isBlank()) {
            return ResultadoAnalisis(
                exito = false,
                erroresLexicos = listOf("El código está vacío"),
                erroresSintacticos = emptyList(),
                codigoProcesado = emptyList()
            )
        }

        return try {

            //Clases java
            //val lexer = Lexer(StringReader(codigo))
            //val parser = Parser(lexer)

           // parser.parse()

            //val erroresLexicos = lexer.lexicalErrors ?: emptyList()
            //val erroresSintacticos = parser.syntaxErrors ?: emptyList()

           // val exito = erroresLexicos.isEmpty() && erroresSintacticos.isEmpty()

            ResultadoAnalisis(
                codigo provisional
               /* exito = exito,
                erroresLexicos = erroresLexicos,
                erroresSintacticos = erroresSintacticos,
                codigoProcesado = if (exito) {
                    listOf("CODIGO_TRADUCIDO_TEMPORAL")
                } else {
                    emptyList()
                }*/
            )

        } catch (e: Exception) {

            ResultadoAnalisis(
                exito = false,
                erroresLexicos = emptyList(),
                erroresSintacticos = listOf("Error inesperado: ${e.message}"),
                codigoProcesado = emptyList()
            )
        }
    }*/
}