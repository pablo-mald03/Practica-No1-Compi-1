package com.pablocompany.practicano1_compi1.domain.usecase

import android.content.Context
import android.net.Uri
import com.pablocompany.practicano1_compi1.data.repository.RepositorioArchivo

class LeerArchivoUseCase(
    private val repositorioArchivo: RepositorioArchivo
) {

    operator fun invoke(context: Context, uri: Uri): String {
        return repositorioArchivo.readTextFromUri(context, uri)
    }
}