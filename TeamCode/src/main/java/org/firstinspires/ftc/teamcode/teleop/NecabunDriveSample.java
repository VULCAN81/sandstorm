package org.firstinspires.ftc.teamcode.teleop;


import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import org.firstinspires.ftc.teamcode.teleop.Robot;
@TeleOp
public class NecabunDriveSample extends LinearOpMode{

    public Robot robot;

    @Override
    public void runOpMode() throws InterruptedException {

        DcMotor frontRight = hardwareMap.get(DcMotor.class, "frontRight");
        DcMotor frontLeft = hardwareMap.get(DcMotor.class, "frontLeft");
        DcMotor backRight = hardwareMap.get(DcMotor.class, "backRight");
        DcMotor backLeft = hardwareMap.get(DcMotor.class, "backLeft");
        DcMotor slides = hardwareMap.get(DcMotor.class, "slides");

        Servo armRight = hardwareMap.get(Servo.class, "armRight");
        Servo armLeft = hardwareMap.get(Servo.class, "armLeft");
        Servo clawRight = hardwareMap.get(Servo.class, "clawRight");
        Servo clawLeft = hardwareMap.get(Servo.class, "clawLeft");
        Servo clawTilt = hardwareMap.get(Servo.class, "clawTilt");
        Servo drone = hardwareMap.get(Servo.class, "drone");

        frontRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        frontLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        slides.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        backLeft.setDirection(DcMotor.Direction.FORWARD);

        double trigger_threshold = 0.5;

        waitForStart();


        while (opModeIsActive() && !isStopRequested()); {
            double speed = -gamepad1.left_stick_y;
            double strafe = gamepad1.left_stick_x;
            double turn = gamepad1.right_stick_x;

            frontLeft.setPower(speed + turn + strafe);
            frontRight.setPower(speed - turn - strafe);
            backLeft.setPower(speed + turn - strafe);
            backRight.setPower(speed - turn + strafe);

            if (gamepad1.left_bumper) {

            }

            /*
            if (gamepad2.dpad_up){
                slides.setTargetPosition(3500);
                slides.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                slides.setPower(0.5);
            }
            */

            /*
            if (gamepad2.dpad_down){
                slides.setTargetPosition(slides.getCurrentPosition() + 100);
                slides.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                slides.setPower(0.5);
            }
            */

            if (gamepad2.dpad_left) {
                if (clawLeft.getPosition() > ) {
                    ;
                } else {
                    clawLeft.setPosition(1);
                }
            }

            if (gamepad2.dpad_right) {
                if (clawRight.getPosition() > 0.5) {
                    clawRight.setPosition(0);
                } else {
                    clawRight.setPosition(1);
                }
            }

            if (gamepad2.left_bumper) {
                drone.setPosition(1.0); //tune value later
            }
        }
    }
}

