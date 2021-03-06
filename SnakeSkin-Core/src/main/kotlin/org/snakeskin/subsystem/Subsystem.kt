package org.snakeskin.subsystem

import org.snakeskin.logic.Parameters
import org.snakeskin.event.EventRouter
import org.snakeskin.event.Events
import org.snakeskin.exception.InitException
import org.snakeskin.exception.ItemNotFoundException
import org.snakeskin.factory.ExecutorFactory
import org.snakeskin.state.StateMachine
import java.lang.reflect.InvocationTargetException
import java.util.*
import java.util.concurrent.ScheduledFuture
import java.util.concurrent.TimeUnit

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

open class Subsystem(val name: String, private val loopRate: Long = 20L) {
    //Executor, for running subsystem actions
    private val executor = ExecutorFactory.getExecutor("Subsystem")
    private var loopFuture: ScheduledFuture<*>? = null

    private val stateMachines = arrayListOf<StateMachine>()

    /**
     * Adds a state machine to this subsystem
     * @param machine The state machine to add
     */
    fun addStateMachine(machine: StateMachine = StateMachine()) = stateMachines.add(machine)

    private val faults = Vector<Any>()
    /**
     * Registers the specified fault to this subsystem
     * @param fault The fault to add
     */
    fun fault(fault: Any) = faults.add(fault)

    /**
     * Removes a fault from this subsystem
     * @param fault The fault to remove
     */
    fun clearFault(fault: Any) = faults.remove(fault)

    /**
     * Returns true if this subsystem has any faults
     * @return true if this subsystem has any faults, false otherwise
     */
    fun isFaulted() = faults.isNotEmpty()

    /**
     * Returns true if this subsystem has any of the provided faults
     * @param faults The faults to check
     * @return true if this subsystem has any of the provided faults, false otherwise
     */
    fun isFaulted(vararg faults: Any) = faults.any { this.faults.contains(it) }

    /**
     * Setup tasks for this subsystem
     */
    open fun setup() {}

    /**
     * Looping actions for this subsystem
     */
    open fun action() {
        loopFuture?.cancel(true) //Cancel the loopable task since there isn't one (default)
    }

    internal fun init() {
        try {
            setup()
        } catch (e: Exception) {
            throw InitException("Exception while running setup tasks for subsystem '$name'", e)
        }
        stateMachines.forEach {
            machine ->
            EventRouter.registerHandler(Events.DISABLED) {
                machine.setState(States.DISABLED)
            }
        }
        loopFuture = executor.scheduleAtFixedRate(this::action, 0L, loopRate, TimeUnit.MILLISECONDS)
    }
}