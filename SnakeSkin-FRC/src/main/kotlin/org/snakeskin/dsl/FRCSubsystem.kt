package org.snakeskin.dsl

import edu.wpi.first.wpilibj.Solenoid
import org.snakeskin.state.StateMachine

/*
 * snakeskin - Created on 5/30/18
 * Author: Cameron Earle
 * 
 * This code is licensed under the GNU GPL v3
 * You can find more info in the LICENSE file at project root
 */

/**
 * @author Cameron Earle
 * @version 5/30/18
 */

fun Subsystem.solenoidStateMachine(solenoid: Solenoid): StateMachine {
    val machine = stateMachine {
        state(false) {
            entry {
                solenoid.set(false)
            }
        }
        state(true) {
            entry {
                solenoid.set(true)
            }
        }
        default {
            solenoid.set(false)
        }
    }
    return machine
}