package org.snakeskin.sensors

import edu.wpi.first.wpilibj.AnalogInput

/*
 * snakeskin - Created on 9/11/17
 * Author: Cameron Earle
 * 
 * This code is licensed under the GNU GPL v3
 * You can find more info in the LICENSE file at project root
 */

/**
 * @author Cameron Earle
 * @version 9/11/17
 */

open class AnalogSensor(val analogInput: AnalogInput, override var deadband: Double = 0.0, override var zero: Double = 0.0, var rawZero: Int = 0): NumericSensor({analogInput.voltage}) {
    fun getVoltage() = getValue()
    fun getRawValue() = analogInput.value - rawZero
    fun getAveragedVoltage() = analogInput.averageVoltage - zero
    fun getAveragedValue() = analogInput.averageValue - rawZero

    var analogReceivingChangeListener: (Double, Int, Double, Int) -> Unit = { _, _, _, _ -> }

    override fun zero() {
        super.zero()
        rawZero = getRawValue()
    }

    override fun pollImpl() {
        super.pollImpl()

        if (history.changedWithin(deadband)) {
            analogReceivingChangeListener(history.current!!, getRawValue(), getAveragedVoltage(), getAveragedValue())
        }
    }
}