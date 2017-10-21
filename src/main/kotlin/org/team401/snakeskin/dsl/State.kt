package org.team401.snakeskin.dsl

import edu.wpi.first.wpilibj.Sendable
import org.team401.snakeskin.publish.NumberPublisher
import org.team401.snakeskin.state.State
import org.team401.snakeskin.state.StateMachine
import org.team401.snakeskin.subsystem.States

/*
 * snakeskin - Created on 8/16/17
 * Author: Cameron Earle
 * 
 * This code is licensed under the GNU GPL v3
 * You can find more info in the LICENSE file at project root
 */

/**
 * @author Cameron Earle
 * @version 8/16/17
 */

class StateMachineBuilder: Builder<StateMachine> {
    private val builder = StateMachine()
    override fun build() = builder

    fun state(state: String, setup: MutableStateBuilder.() -> Unit) {
        val stateBuilder = MutableStateBuilder(state)
        stateBuilder.setup()
        builder.addState(stateBuilder.build())
    }

    fun disabled(setup: StateBuilder.() -> Unit) {
        val stateBuilder = StateBuilder(States.DISABLED)
        stateBuilder.setup()
        builder.addState(stateBuilder.build())
    }

    fun default(setup: StateBuilder.() -> Unit) {
        val stateBuilder = StateBuilder(States.ELSE)
        stateBuilder.setup()
        builder.elseCondition = stateBuilder.build()
    }

    @JvmName("publishNumber")
    fun publish(vararg pairs: Pair<String, () -> Number>) {
        pairs.forEach {
            builder.publisher.publishNumber(it.first, it.second)
        }
    }

    @JvmName("publishBoolean")
    fun publish(vararg pairs: Pair<String, () -> Boolean>) {
        pairs.forEach {
            builder.publisher.publishBoolean(it.first, it.second)
        }
    }

    @JvmName("publishString")
    fun publish(vararg pairs: Pair<String, () -> String>) {
        pairs.forEach {
            builder.publisher.publishString(it.first, it.second)
        }
    }

    @JvmName("publishSendable")
    fun publish(vararg pairs: Pair<String, () -> Sendable>) {
        pairs.forEach {
            builder.publisher.publishSendable(it.first, it.second)
        }
    }

    fun isInState(state: String) = builder.getState() == state
    fun wasInState(state: String) = builder.getLastState() == state
}

open class StateBuilder(name: String): Builder<State> {
    protected val builder = State(name, {}, {}, {})
    override fun build() = builder

    fun entry(action: () -> Unit) {
        builder.entry = action
    }

    fun action(rate: Long = 20L, action: () -> Unit) {
        builder.rate = rate
        builder.action = action
    }

    fun exit(action: () -> Unit) {
        builder.exit = action
    }
}

class MutableStateBuilder(name: String): StateBuilder(name) {
    fun rejectIf(condition: () -> Boolean) {
        builder.rejectionConditions = condition
    }

    fun timeout(timeout: Long, timeoutTo: String) {
        builder.timeout = timeout
        builder.timeoutTo = timeoutTo
    }
}