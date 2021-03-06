package org.snakeskin.dsl

import org.snakeskin.logic.Parameters
import org.snakeskin.event.EventRouter
import org.snakeskin.logic.MutableParameters

/*
 * SnakeSkin - Created on 7/4/17
 * Author: Cameron Earle
 * 
 * This code is licensed under the GNU GPL v3
 * You can find more info in the LICENSE file at project root
 */

/**
 * @author Cameron Earle
 * @version 7/4/17
 */

/**
 * Sends an event on the event router
 * @param name The event to send
 * @param setup The function to set up the event.  Can be used to add parameters to the event.  @see MutableParameters
 */
fun send(name: Any, setup: MutableParameters.() -> Unit = {}) {
    val event = MutableParameters()
    event.setup()
    EventRouter.fireEvent(name, event)
}

/**
 * Registers an event handler
 * @param name The event to listen for
 * @param action The function to run when the event is received.  This function receives a Parameters object.  @see Parameters
 */
fun on(name: Any, action: Parameters.() -> Unit) {
    EventRouter.registerHandler(name, action)
}