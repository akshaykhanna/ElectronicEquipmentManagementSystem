package com.company;

import com.company.floors.FloorUnit;
import com.company.floors.Floors;

public class ElectronicEquipmentManagementSystem {
    Floors floors;
    FloorUnit mainCorridors[];
    FloorUnit subCorridors[];

    public ElectronicEquipmentManagementSystem(int noOfFloors, int noOfCorridorPerFloor, int noOfSubCorridorPerFloor) {
        this.floors = new Floors(noOfFloors, noOfCorridorPerFloor, noOfSubCorridorPerFloor);
    }

    public String controllerOutput() {
        String out = "";
        for (int i = 0; i < this.floors.size(); i++) {
            out += String.format("Floor %d\n", (i + 1));
        }
        return out;
    }
}
