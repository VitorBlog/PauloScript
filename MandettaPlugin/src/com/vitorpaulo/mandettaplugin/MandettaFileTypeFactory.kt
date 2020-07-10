package com.vitorpaulo.mandettaplugin

import com.intellij.openapi.fileTypes.FileTypeConsumer;
import com.intellij.openapi.fileTypes.FileTypeFactory;

object MandettaFileTypeFactory : FileTypeFactory() {

    override
    fun createFileTypes(fileTypeConsumer: FileTypeConsumer) {
        fileTypeConsumer.consume(MandettaFileType)
    }


}