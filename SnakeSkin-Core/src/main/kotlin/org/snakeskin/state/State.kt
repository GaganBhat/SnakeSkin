package org.snakeskin.state

/*
 * snakeskin - Created on 8/3/17
 * Author: Cameron Earle
 * 
 * This code is licensed under the GNU GPL v3
 * You can find more info in the LICENSE file at project root
 */

/**
 * @author Cameron Earle
 * @version 8/3/17
 */

/**
 * @param name The name of the state
 * @param entry The entry actions of the state
 * @param action The looping actions of the state
 * @param exit The exit actions of the state
 * @param rate The rate, in ms, to run the action loop at
 * @param rejectionConditions The rejection conditions for this state, which will prevent it being switched to
 * @param timeout The timeout length, in ms, to active the timeout
 * @param timeoutTo The state to timeout to
 */
data class State(val name: Any,
                 var entry: () -> Unit,
                 var action: () -> Unit,
                 var exit: () -> Unit,
                 var rate: Long = 20,
                 var rejectionConditions: () -> Boolean = {false},
                 var timeout: Long = -1L,
                 var timeoutTo: Any = "")