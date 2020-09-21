package test;

import com.company.Constants;
import com.company.Controller;
import org.junit.jupiter.api.Test;

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
//        electronicEquipmentManagementSystem = new ElectronicEquipmentManagementSystem
//                (2, 1, 2);
        String expectedOutput =
                "Floor 1\n" +
                        "Main Corridor 1 Light 1 : ON AC : ON\n" +
                        "Sub Corridor 1 Light 1 : OFF AC : ON\n" +
                        "Sub Corridor 2 Light 2 : OFF AC : ON\n" +
                        "Floor 2\n" +
                        "Main Corridor 1 Light 1 : ON AC : ON\n" +
                        "Sub Corridor 1 Light 1 : OFF AC : ON\n" +
                        "Sub Corridor 2 Light 2 : OFF AC : ON\n";
        assertEquals(controller.output(), expectedOutput);
    }

    @Test
    void controllerOutput_WhenThereIs() {
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
        assertEquals(controller.output(), expectedOutput);
    }
}