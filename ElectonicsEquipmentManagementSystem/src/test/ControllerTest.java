package test;

import com.company.Constants;
import com.company.Controller;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ControllerTest {
    Controller controller;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        controller = new Controller
                (2, 1, 2);
    }

    @Test
    void controllerOutput_GetDefaultState() {
        String expectedOutput =
                "Floor 1\n" +
                        "Main Corridor 1 Light 1 : ON AC : ON\n" +
                        "Sub Corridor 1 Light 1 : OFF AC : ON\n" +
                        "Sub Corridor 2 Light 2 : OFF AC : ON\n" +
                        "Floor 2\n" +
                        "Main Corridor 1 Light 1 : ON AC : ON\n" +
                        "Sub Corridor 1 Light 1 : OFF AC : ON\n" +
                        "Sub Corridor 2 Light 2 : OFF AC : ON\n";
        assertEquals(expectedOutput, controller.output());
    }

    @Test
    void controllerOutput_WhenThereIsMotionOnFloor() {
        controller.onMovementInFloorCorridor(1, Constants.SUB_CORRIDOR, 2);
        String expectedOutput =
                "Floor 1\n" +
                        "Main Corridor 1 Light 1 : ON AC : ON\n" +
                        "Sub Corridor 1 Light 1 : OFF AC : OFF\n" +
                        "Sub Corridor 2 Light 2 : ON AC : ON\n" +
                        "Floor 2\n" +
                        "Main Corridor 1 Light 1 : ON AC : ON\n" +
                        "Sub Corridor 1 Light 1 : OFF AC : ON\n" +
                        "Sub Corridor 2 Light 2 : OFF AC : ON\n";
        assertEquals(expectedOutput, controller.output());
    }

    @Test
    void controllerOutput_WhenThereIsNoMovementForSomeTime() throws InterruptedException {
        String expectedOutput =
                "Floor 1\n" +
                        "Main Corridor 1 Light 1 : ON AC : ON\n" +
                        "Sub Corridor 1 Light 1 : OFF AC : ON\n" +
                        "Sub Corridor 2 Light 2 : OFF AC : ON\n" +
                        "Floor 2\n" +
                        "Main Corridor 1 Light 1 : ON AC : ON\n" +
                        "Sub Corridor 1 Light 1 : OFF AC : ON\n" +
                        "Sub Corridor 2 Light 2 : OFF AC : ON\n";
        controller.onMovementInFloorCorridor(1, Constants.SUB_CORRIDOR, 2);
        // was ease of dev taking min as sec
        TimeUnit.SECONDS.sleep(2);
        assertEquals(controller.output(), expectedOutput);
    }
}