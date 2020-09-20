package test;

import com.company.ElectronicEquipmentManagementSystem;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ElectronicEquipmentManagementSystemTest {
    ElectronicEquipmentManagementSystem electronicEquipmentManagementSystem;
    @org.junit.jupiter.api.BeforeEach
    void setUp() {
//        electronicEquipmentManagementSystem = new ElectronicEquipmentManagementSystem();
    }

    @Test
    void controllerOutput_GetDefaultState() {
        electronicEquipmentManagementSystem = new ElectronicEquipmentManagementSystem
                (2, 1, 2);
        String expectedOutput =
                "Floor 1\n" +
                "Main Corridor 1 Light 1 : ON AC : ON\n"+
                "Sub Corridor 1 Light 1 : OFF AC : ON\n"+
                "Sub Corridor 2 Light 2 : OFF AC : ON\n"+
                        "Floor 2\n" +
                "Main Corridor 1 Light 1 : ON AC : ON\n"+
                "Sub Corridor 1 Light 1 : OFF AC : ON\n"+
                "Sub Corridor 2 Light 2 : OFF AC : ON\n";
        assertEquals(electronicEquipmentManagementSystem.controllerOutput(), expectedOutput);
    }
}