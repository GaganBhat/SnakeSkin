package org.snakeskin

import edu.wpi.first.wpilibj.IterativeRobot
import org.snakeskin.auto.AutoManager
import org.snakeskin.event.EventRouter
import org.snakeskin.event.Events
import org.snakeskin.registry.Subsystems

/*
 * snakeskin - Created on 12/14/17
 * Author: Cameron Earle
 *
 * This code is licensed under the GNU GPL v3
 * You can find more info in the LICENSE file at project root
 */

/**
 * @author Cameron Earle
 * @version 12/14/17
 */

class Robot: IterativeRobot() {
    override fun testPeriodic() {}
    override fun autonomousPeriodic() {}
    override fun teleopPeriodic() {}
    override fun disabledPeriodic() {}
    override fun robotPeriodic() {}

    override fun robotInit() {
        //Run the Init Manager to initialize the user code
        InitManager.init()
    }

    override fun disabledInit() {
        //If the auto script is running for some reason, we should stop it
        AutoManager.stop()
        //Publish the available autonomous modes to SmartDashboard
        //AutoManager.publish()
        //At this point the robot is disabled, so we should fire the "DISABLED" event to let everyone know that
        EventRouter.fireEvent(Events.DISABLED)
    }

    override fun teleopInit() {
        //First, we stop the auto script
        AutoManager.stop()
        //Teleop has now started, so we need to notify everyone of that
        EventRouter.fireEvent(Events.ENABLED)
        EventRouter.fireEvent(Events.TELEOP_ENABLED)
    }

    override fun autonomousInit() {
        //Autonomous has now started, so we need to notify everyone of that
        EventRouter.fireEvent(Events.ENABLED)
        EventRouter.fireEvent(Events.AUTO_ENABLED)
        //Now, we need to start the auto script
        AutoManager.start()
    }

    override fun testInit() {
        //Run all subsystem tests
        Subsystems.testAll()
    }
}