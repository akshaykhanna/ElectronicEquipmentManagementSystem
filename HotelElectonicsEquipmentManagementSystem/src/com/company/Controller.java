package com.company;

import com.company.equipments.Equipment;
import com.company.equipments.EquipmentStatus;
import com.company.floors.Corridor;
import com.company.floors.Floor;
import com.company.floors.Floors;

import java.util.ArrayList;

public class Controller {
    Floors floors;

    public Controller(int noOfFloors, int noOfCorridorPerFloor, int noOfSubCorridorPerFloor) {
        this.floors = new Floors(noOfFloors, noOfCorridorPerFloor, noOfSubCorridorPerFloor);
    }

    public void onMovementInFloorCorridor(int floorNo, String corridorType, int corridorNo) {
        this.floors.handleMovement(floorNo, corridorType, corridorNo);
    }

    public String output() {
        return new OutputCreator(this.floors).generateOutput();
    }
}
