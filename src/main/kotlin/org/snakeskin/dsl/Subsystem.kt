package org.snakeskin.dsl

import org.snakeskin.logic.Parameters
import org.snakeskin.state.StateMachine
import org.snakeskin.subsystem.Subsystem

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

fun Subsystem.machine(machine: String) = getStateMachine(machine)

fun buildSubsystem(setup: SubsystemBuilder.() -> Unit): Subsystem {
    val builder = SubsystemBuilder()
    builder.setup()
    return builder.build()
}

class SubsystemBuilder: Builder<Subsystem> {
    private val builder = Subsystem()

    fun setup(action: () -> Unit) {
        builder.addSetupTask(action)
    }

    fun on(event: String, action: Parameters.() -> Unit) {
        builder.addEventHandler(event, action)
    }

    fun stateMachine(machine: String, setup: StateMachineBuilder.() -> Unit): StateMachine {
        val sBuilder = StateMachineBuilder()
        sBuilder.setup()
        val instance = sBuilder.build()
        builder.addStateMachine(machine, instance)
        return instance
    }

    fun test(name: String, body: () -> Boolean) {
        builder.addTest(name, body)
    }

    override fun build() = builder
}