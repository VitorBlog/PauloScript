package com.vitorpaulo.mandettaplugin.file

import com.intellij.openapi.fileTypes.FileTypeConsumer;
import com.intellij.openapi.fileTypes.FileTypeFactory;
import com.vitorpaulo.mandettaplugin.file.MandettaFileType

object MandettaFileTypeFactory : FileTypeFactory() {

    override
    fun createFileTypes(fileTypeConsumer: FileTypeConsumer) {
        fileTypeConsumer.consume(MandettaFileType)
    }

}