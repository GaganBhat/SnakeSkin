package org.snakeskin.executor

/*
 * snakeskin - Created on 5/16/18
 * Author: Cameron Earle
 * 
 * This code is licensed under the GNU GPL v3
 * You can find more info in the LICENSE file at project root
 */

/**
 * @author Cameron Earle
 * @version 5/16/18
 */
class ExceptionHandlingRunnable(private val r: Runnable?): Runnable {
    override fun run() {
        try {
            r?.run()
        } catch (e: Exception) {
            //TODO actually do exception handling
            println("ExceptionHandlingRunnable caught exception $e")
        }
    }
}