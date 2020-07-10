package com.vitorpaulo.mandettaplugin.file

import com.intellij.openapi.fileTypes.LanguageFileType
import com.vitorpaulo.mandettaplugin.MandettaLanguage

object MandettaFileType : LanguageFileType(MandettaLanguage) {

    override
    fun getDefaultExtension() = "sus"

    override
    fun getIcon() = MandettaLanguage.icon

    override
    fun getName() = "PseudoMandetta"

    override
    fun getDescription() = "PseudoLanguage for programming students"

}