package com.company;

import com.company.floors.Floors;

public class Controller {
    Floors floors;

    public Controller(int noOfFloors, int noOfCorridorPerFloor, int noOfSubCorridorPerFloor) {
        this.floors = new Floors(noOfFloors, noOfCorridorPerFloor, noOfSubCorridorPerFloor);
    }

    public void onMovementInFloorCorridor(int floorNo, String corridorType, int corridorNo) {
        if (corridorType == Constants.SUB_CORRIDOR) {
            this.floors.getFloor(floorNo).turnOnLight(corridorType, corridorNo);
            this.floors.getFloor(floorNo).balanceLoad();
        }
    }

    public String output() {
        return new OutputCreator(this.floors).generateOutput();
    }
}
