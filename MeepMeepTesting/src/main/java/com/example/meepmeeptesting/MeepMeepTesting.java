package com.example.meepmeeptesting;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.noahbres.meepmeep.MeepMeep;
import com.noahbres.meepmeep.roadrunner.DefaultBotBuilder;
import com.noahbres.meepmeep.roadrunner.entity.RoadRunnerBotEntity;

public class MeepMeepTesting {
    public static void main(String[] args) {
        MeepMeep meepMeep = new MeepMeep(800);

        RoadRunnerBotEntity myBot = new DefaultBotBuilder(meepMeep)
                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                .setConstraints(60, 60, Math.toRadians(180), Math.toRadians(180), 15)
                .followTrajectorySequence(drive -> drive.trajectorySequenceBuilder(new Pose2d(-35.61, -64.22, Math.toRadians(90.00)))
                        .lineToLinearHeading(new Pose2d(-39.19, -32.03, Math.toRadians(0.00)))
                        .splineToLinearHeading(new Pose2d(-18.19, -36.54, Math.toRadians(0.00)), Math.toRadians(0.00))
                        .lineTo(new Vector2d(33.90, -36.86))
                        .lineToSplineHeading(new Pose2d(52.72, -30.95, Math.toRadians(-1.27)))
                        .lineTo(new Vector2d(49.76, -13.53))
                        .lineTo(new Vector2d(61.74, -12.91))
                        .build());

        meepMeep.setBackground(MeepMeep.Background.FIELD_CENTERSTAGE_JUICE_DARK)
                .setDarkMode(true)
                .setBackgroundAlpha(0.95f)
                .addEntity(myBot)
                .start();
    }
}