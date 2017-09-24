package org.team401.snakeskin.subsystem

import org.team401.snakeskin.ability.AWaitable
import org.team401.snakeskin.logic.Parameters
import org.team401.snakeskin.event.EventRouter
import org.team401.snakeskin.event.Events
import org.team401.snakeskin.exception.ItemNotFoundException
import org.team401.snakeskin.factory.ExecutorFactory
import org.team401.snakeskin.logic.TickedWaitable
import org.team401.snakeskin.state.StateMachine
import java.util.concurrent.*
import java.util.concurrent.atomic.AtomicReference

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

class Subsystem {
    //Executor, for running subsystem actions
    private val executor = ExecutorFactory.getExecutor("Subsystem")

    //<editor-fold desc="State Handler">
    private val stateMachines = hashMapOf<String, StateMachine>() //The states that a subsystem can be in

    fun addStateMachine(machine: String, instance: StateMachine = StateMachine()) = stateMachines.put(machine, instance)

    fun getStateMachine(machine: String): StateMachine {
        if (stateMachines.contains(machine)) {
            return stateMachines[machine]!!
        } else {
            throw ItemNotFoundException("Could not find state machine $machine")
        }
    }


    //</editor-fold>

    //<editor-fold desc="Setup Tasks">
    private val setupTasks = arrayListOf<() -> Unit>()
    fun addSetupTask(task: () -> Unit) = setupTasks.add(task)
    //</editor-fold>

    //<editor-fold desk="Tests">
    private val tests = hashMapOf<String, () -> Boolean>()
    fun addTest(name: String, test: () -> Boolean) = tests.put(name, test)
    //</editor-fold>

    internal fun init() {
        setupTasks.forEach {
            it()
        }
        stateMachines.forEach {
            _, machine ->
            EventRouter.registerPriority(Events.DISABLED) {
                machine.setState(States.DISABLED)
            }
        }
    }

    fun addEventHandler(event: String, action: (Parameters) -> Unit) = EventRouter.registerPriority(event) {
        executor.submit {
            action(it)
        }
    }
}