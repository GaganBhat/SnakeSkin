package org.snakeskin.sensors

/*
 * SnakeSkin - Created on 5/22/17
 * Author: Zachary Kozar
 *
 * This code is licensed under the GNU GPL v3
 * You can find more info in the LICENSE file at the project root.
 */

import edu.wpi.first.wpilibj.interfaces.Gyro

/**
 * @author Zachary Kozar
 * @version 5/22/17
 *
 * A gyro with more precise controls on calibration.
 */
interface InterruptableGyro : Gyro {

    fun startCalibrate()

    fun endCalibrate()

    fun cancelCalibrate()

    fun getCenter(): Double

    fun getCalibrationSampleTime(): Double
}