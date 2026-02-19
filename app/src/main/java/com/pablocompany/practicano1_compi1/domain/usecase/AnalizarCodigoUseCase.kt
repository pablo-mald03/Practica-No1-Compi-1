package com.pablocompany.practicano1_compi1.domain.usecase

class AnalizarCodigoUseCase{

    operator fun invoke(codigo: String): Boolean {

        //APARTADO DE LEXER Y PARSER

        return codigo.isNotBlank()
    }
}