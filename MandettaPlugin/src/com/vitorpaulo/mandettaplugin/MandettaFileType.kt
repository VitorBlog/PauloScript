package com.vitorpaulo.mandettaplugin

import com.intellij.openapi.fileTypes.LanguageFileType

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