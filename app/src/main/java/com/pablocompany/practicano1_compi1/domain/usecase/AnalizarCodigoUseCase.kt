package com.pablocompany.practicano1_compi1.domain.usecase

import android.util.Log
import com.pablocompany.practicano1_compi1.compiler.backend.ResultadoAnalisis
import com.pablocompany.practicano1_compi1.compiler.backend.recursos.GestorCodigo
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
                listaEstructurasControl = emptyList(),
                erroresLexicos = emptyList(),
                erroresSintacticos = emptyList(),
                codigoDiagrama = emptyList()
            )
        }

        return try {
            //ER que sirve para quitar valores basura que vienen al usar android
            val regexBasura = Regex("[\\u200B-\\u200D\\uFEFF\\p{C}&&[^\\n\\r\\t]]")

            val codigoLimpio = codigo.replace(regexBasura, "")

            val lexer = Lexer(StringReader(codigoLimpio))
            val parser = Parser(lexer)

            val parseResult = parser.parse()

            val erroresLexicosList = lexer.lexicalErrors ?: emptyList()
            val erroresSintacticosList = parser.syntaxErrorList ?: emptyList()

            val exito = erroresLexicosList.isEmpty() && erroresSintacticosList.isEmpty()

            val ast = parseResult.value as? NodoPrograma ?: NodoPrograma(emptyList(), emptyList())

            //Codigo delegado a backend (PATRON EXPERTO)
            val gestor = GestorCodigo(ast)
            try {
                gestor.procesarCodigo()

            } catch (e: Exception) {
                Log.e("ERROR_GESTOR", "Error: ${e.message}")
            }

            ResultadoAnalisis(
                exito = exito,
                listaOperadores = gestor.listaOperadoresMatematicos,
                listaEstructurasControl = gestor.listaEstructurasControl,
                erroresLexicos = erroresLexicosList,
                erroresSintacticos = erroresSintacticosList,
                codigoDiagrama = gestor.listaDiagrama
            )

        } catch (e: Exception) {
            ResultadoAnalisis(
                exito = false,
                listaOperadores = emptyList(),
                listaEstructurasControl = emptyList(),
                erroresLexicos = emptyList(),
                erroresSintacticos = emptyList(),
                codigoDiagrama =  emptyList(),
                esErrorCritico = true
            )
        }
    }
}