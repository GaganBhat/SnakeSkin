package org.team401.snakeskin.logic

/*
 * SnakeSkin - Created on 5/25/2017
 * Author: Zachary Kozar
 * 
 * This code is licensed under the GNU GPL v3
 * You can find more info in the LICENSE file at the project root.
 */

/**
 * @author Zachary Kozar
 * @version 5/25/2017
 */
class Axis(private val axis: () -> Double, var deadband: Double = -1.0) {

    var scaling: (Double) -> Double = NO_SCALING

    companion object {
        val NO_SCALING: (Double) -> Double = { input -> input }
        val INVERTED: (Double) -> Double = { input -> -input }
        val SQUARED: (Double) -> Double = { input -> if (input < 0.0) -input*input else input*input }
        val CUBED: (Double) -> Double = { input -> input*input*input }
        val LOG: (Double) -> Double = { input -> Math.log(input) }
    }

    fun read(): Double {
        val delta = scaling(axis())

        if (deadband == -1.0 || Math.abs(delta) > deadband)
            return delta
        return 0.0
    }

    fun invert(): Axis = Axis({ -axis()}, deadband)
}
