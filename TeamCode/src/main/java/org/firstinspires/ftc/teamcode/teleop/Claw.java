package org.firstinspires.ftc.teamcode.teleop;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.Servo;

@Config
public class Claw {
    private Servo armLeft;
    private Servo armRight;

    double openPosition = 0.5;
    double closedPosition = 1;
    double thresholdPosition = (openPosition+closedPosition)/2;

    public Claw(LinearOpMode opMode) {
        armLeft = opMode.hardwareMap.servo.get("armLeft");
        armRight = opMode.hardwareMap.servo.get("armRight");
        armRight.setDirection(Servo.Direction.REVERSE);
    }

    public void openRight() {
        armLeft.setPosition(openPosition);
    }

    public void openLeft() {
        armLeft.setPosition(openPosition);
    }

    public void closeRight() {
        armRight.setPosition(closedPosition);
    }

    public void closeLeft() {
        armLeft.setPosition(closedPosition);
    }

    public double getThresholdPosition() {
        return thresholdPosition;
    }

    public double getLeftPosition() {
        return armLeft.getPosition();
    }

    public double getRightPosition() {
        return armLeft.getPosition();
    }
}
