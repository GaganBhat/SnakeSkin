package org.snakeskin.controls

import org.snakeskin.ability.AReadable

/*
 * snakeskin - Created on 7/16/17
 * Author: Cameron Earle
 * 
 * This code is licensed under the GNU GPL v3
 * You can find more info in the LICENSE file at project root
 */

/**
 * @author Cameron Earle
 * @version 7/16/17
 */

class Hat(private val getter: () -> Int): AReadable<Int> {
    override fun read() = getter()
}