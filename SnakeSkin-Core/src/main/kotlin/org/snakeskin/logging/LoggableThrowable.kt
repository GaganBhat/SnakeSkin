package org.snakeskin.logging

import org.snakeskin.ability.ALoggable

/*
 * snakeskin - Created on 8/26/17
 * Author: Cameron Earle
 * 
 * This code is licensed under the GNU GPL v3
 * You can find more info in the LICENSE file at project root
 */

/**
 * @author Cameron Earle
 * @version 8/26/17
 */
class LoggableThrowable(e: Throwable, t: Thread?): ALoggable {
    override val type = "exception"

    val name = e::class.java.simpleName
    val thread = t?.name ?: "Unknown"
    val message = e.message
    val stackTrace = e.stackTrace
}