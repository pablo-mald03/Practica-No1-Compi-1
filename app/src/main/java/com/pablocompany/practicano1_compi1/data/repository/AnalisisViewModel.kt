package com.pablocompany.practicano1_compi1.data.repository

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.pablocompany.practicano1_compi1.compiler.backend.ResultadoAnalisis
import com.pablocompany.practicano1_compi1.domain.usecase.AnalizarCodigoUseCase

class AnalisisViewModel : ViewModel() {

    var resultado by mutableStateOf<ResultadoAnalisis?>(null)
        private set

    fun analizarCodigo(codigo: String) {
        val useCase = AnalizarCodigoUseCase()
        resultado = useCase(codigo)
    }
}