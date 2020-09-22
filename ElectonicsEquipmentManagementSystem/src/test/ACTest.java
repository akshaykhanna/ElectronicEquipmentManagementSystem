package test;

import com.company.equipments.AC;
import com.company.equipments.Equipment;
import com.company.equipments.EquipmentStatus;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ACTest {
    @Test
    void test_InitialState() {
        Equipment obj = new AC();
        assertEquals("AC", obj.Name());
        assertEquals(10, obj.Power());
        assertEquals(EquipmentStatus.OFF, obj.Status());
    }
    @Test
    void test_StatusChange() {
        Equipment obj = new AC();
        assertEquals(EquipmentStatus.OFF, obj.Status());
        obj.Status(EquipmentStatus.ON);
        assertEquals(EquipmentStatus.ON, obj.Status());
    }
}