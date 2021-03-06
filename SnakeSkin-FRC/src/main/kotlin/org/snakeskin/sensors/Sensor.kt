package org.snakeskin.sensors

import org.snakeskin.ability.AReadable
import org.snakeskin.ability.AUpdatable
import java.util.Vector

/*
 * snakeskin - Created on 9/10/17
 * Author: Cameron Earle
 * 
 * This code is licensed under the GNU GPL v3
 * You can find more info in the LICENSE file at project root
 */

/**
 * @author Cameron Earle
 * @version 9/10/17
 */
abstract class Sensor<T>: AReadable<T> {
    abstract internal fun pollImpl()
    var changedListener = {}
    var receivingChangeListener: (T) -> Unit = {}
    private val updatableListeners = Vector<AUpdatable<T>>()

    protected fun callListeners(value: T) {
        changedListener()
        receivingChangeListener(value)
        updatableListeners.forEach {
            it.update(value)
        }
    }

    fun registerUpdatable(updatable: AUpdatable<T>) {
        updatableListeners.addElement(updatable)
    }

    var pollRate = 20L
}