package com.pablocompany.practicano1_compi1.data.repository

import android.content.Context
import android.net.Uri
import java.io.BufferedReader
import java.io.InputStreamReader

class RepositorioArchivo {

    fun readTextFromUri(context: Context, uri: Uri): String {

        val inputStream = context.contentResolver.openInputStream(uri)
        val reader = BufferedReader(InputStreamReader(inputStream))

        val stringBuilder = StringBuilder()

        reader.forEachLine {
            stringBuilder.append(it).append("\n")
        }

        reader.close()

        return stringBuilder.toString()
    }
}