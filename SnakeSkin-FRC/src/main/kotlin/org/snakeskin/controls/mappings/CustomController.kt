package org.snakeskin.controls.mappings

import org.snakeskin.controls.Controller

/**
 * Created by cameronearle on 7/30/2017.
 */

class CustomController(id: Int, numAxes: Int, numButtons: Int, numHats: Int): Controller(id) {
    init {
        for (i in 0 until numAxes) {
            addAxis(i)
        }
        for (i in 1..numButtons) {
            addButton(i)
        }
        for (i in 0 until numHats) {
            addHat(i)
        }
    }

    override val Mapping = object : IMappingDefinitions {
        override val Axes = object : IMappingDefinitions.AxesDefinitions {}
        override val Buttons = object : IMappingDefinitions.ButtonsDefinitions {}
        override val Hats = object : IMappingDefinitions.HatsDefinitions {}
    }
}