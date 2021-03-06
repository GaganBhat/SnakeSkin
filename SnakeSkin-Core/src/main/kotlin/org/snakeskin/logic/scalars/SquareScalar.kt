package org.snakeskin.logic.scalars

/*
 * snakeskin - Created on 9/1/17
 * Author: Cameron Earle
 * 
 * This code is licensed under the GNU GPL v3
 * You can find more info in the LICENSE file at project root
 */

/**
 * @author Cameron Earle
 * @version 9/1/17
 */

object SquareScalar : Scalar {
    override fun scale(input: Double) = if (input < 0.0) -input*input else input*input
}