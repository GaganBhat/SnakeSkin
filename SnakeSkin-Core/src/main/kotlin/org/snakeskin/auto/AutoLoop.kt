package org.snakeskin.auto

/*
 * snakeskin - Created on 1/23/18
 * Author: Cameron Earle
 * 
 * This code is licensed under the GNU GPL v3
 * You can find more info in the LICENSE file at project root
 */

/**
 * @author Cameron Earle
 * @version 1/23/18
 */
interface AutoLoop {
    val rate: Long

    fun entry()
    fun action()
    fun exit()
}