package com.vitorpaulo.mandettaplugin

import com.intellij.lang.Language
import com.intellij.openapi.util.IconLoader

object MandettaLanguage : Language("PseudoMandetta") {

    val instance = this
    val icon = IconLoader.findIcon("/icon.png")

}