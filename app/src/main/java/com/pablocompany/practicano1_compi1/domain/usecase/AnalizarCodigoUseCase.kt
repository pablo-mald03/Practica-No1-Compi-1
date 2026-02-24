package com.pablocompany.practicano1_compi1.domain.usecase

import com.pablocompany.practicano1_compi1.compiler.backend.ResultadoAnalisis
import com.pablocompany.practicano1_compi1.compiler.logic.Lexer
import com.pablocompany.practicano1_compi1.compiler.logic.Parser
import com.pablocompany.practicano1_compi1.compiler.models.NodoPrograma
import java.io.StringReader

class AnalizarCodigoUseCase {


    //Funcion intermedia (YA CON EL PARSER REAL)
    operator fun invoke(codigo: String): ResultadoAnalisis {

        if (codigo.isBlank()) {
            return ResultadoAnalisis(
                exito = false,
                listaOperadores = emptyList(),
                erroresLexicos = emptyList(),
                erroresSintacticos = emptyList(),
                codigoProcesado = NodoPrograma(emptyList(), emptyList())
            )
        }

        return try {
            //Primer filtro para evitar caracteres basura
            val codigoLimpio = codigo.replace(Regex("\\p{C}"), "")

            val lexer = Lexer(StringReader(codigoLimpio))
            val parser = Parser(lexer)

            val parseResult = parser.parse()

            val erroresLexicosList = lexer.lexicalErrors ?: emptyList()
            val erroresSintacticosList = parser.syntaxErrorList ?: emptyList()

            val exito = erroresLexicosList.isEmpty() && erroresSintacticosList.isEmpty()

            val ast = parseResult.value as? NodoPrograma ?: NodoPrograma(emptyList(), emptyList())

            ResultadoAnalisis(
                exito = exito,
                listaOperadores = emptyList(),
                erroresLexicos = erroresLexicosList,
                erroresSintacticos = erroresSintacticosList,
                codigoProcesado = ast
            )

        } catch (e: Exception) {
            ResultadoAnalisis(
                exito = false,
                listaOperadores = emptyList(),
                erroresLexicos = emptyList(),
                erroresSintacticos = emptyList(),
                codigoProcesado = NodoPrograma(emptyList(), emptyList())
            )
        }
    }
}