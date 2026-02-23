package com.pablocompany.practicano1_compi1.domain.usecase

import com.pablocompany.practicano1_compi1.compiler.backend.ResultadoAnalisis
import com.pablocompany.practicano1_compi1.compiler.logic.Lexer
import com.pablocompany.practicano1_compi1.compiler.logic.Parser
import java.io.StringReader

class AnalizarCodigoUseCase {


    //CODIGO PROVISIONALLLLLL POR COMPLETO PROVISIONALLLLL
    operator fun invoke(codigo: String): ResultadoAnalisis {


        if (codigo.isBlank()) {
            return ResultadoAnalisis(
                exito = false,
                listaOperadores = emptyList(),
                erroresLexicos = emptyList(),
                erroresSintacticos = emptyList(),
                codigoProcesado = emptyList()
            )
        }

        return try {

            val lexer = Lexer(StringReader(codigo))
            val parser = Parser(lexer)

            val parseResult = parser.parse()

            val erroresLexicosList = lexer.lexicalErrors?: emptyList()

            val erroresSintacticosList = parser.syntaxErrorList?: emptyList()

            val exito = erroresLexicosList.isEmpty() && erroresSintacticosList.isEmpty()

            val ast = parseResult.value as? List<*>

            ResultadoAnalisis(
                exito = exito,
                listaOperadores = emptyList(),
                erroresLexicos = erroresLexicosList,
                erroresSintacticos = erroresSintacticosList,
                codigoProcesado = if (exito && ast != null) {
                    ast.map { it.toString() }
                } else {
                    emptyList()
                }
            )

        } catch (e: Exception) {

            ResultadoAnalisis(
                exito = false,
                listaOperadores = emptyList(),
                erroresLexicos = emptyList(),
                erroresSintacticos = emptyList(),
                codigoProcesado = emptyList()
            )
        }
    }
}