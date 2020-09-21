package test;

import com.company.equipments.EquipmentStatus;
import com.company.equipments.Light;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LightTest {

    @Test
    void test_InitialState() {
        Light obj = new Light(EquipmentStatus.OFF);
        assertEquals("Light", obj.Name());
        assertEquals(5, obj.Power());
        assertEquals(EquipmentStatus.OFF, obj.Status());
    }
    @Test
    void test_StatusChange() {
        Light obj = new Light();
        assertEquals(EquipmentStatus.ON, obj.Status());
        obj.Status(EquipmentStatus.OFF);
        assertEquals(EquipmentStatus.OFF, obj.Status());
    }
}