package com.company;

import com.company.floors.Floors;

public class Controller {
    Floors floors;

    public Controller(int noOfFloors, int noOfCorridorPerFloor, int noOfSubCorridorPerFloor) {
        this.floors = new Floors(noOfFloors, noOfCorridorPerFloor, noOfSubCorridorPerFloor);
    }

    public void onMovementInFloorCorridor(int floorNo, String corridorType, int corridorNo) {
        if (corridorType == Constants.SUB_CORRIDOR) {
            respondToMotion(floorNo, corridorType, corridorNo);
            Util.setTimeout(() -> {
                this.resetBack();
                // considering 1 min as 1 sec (1000ms) for ease of dev
            }, Config.RESET_TIME_INTERVAL);
        }
    }

    private void resetBack() {
        this.floors.reset();
    }

    private void respondToMotion(int floorNo, String corridorType, int corridorNo) {
        this.floors.getFloor(floorNo).turnOnLight(corridorType, corridorNo);
        this.floors.getFloor(floorNo).balanceLoad();
    }

    public String output() {
        return new OutputCreator(this.floors).generateOutput();
    }
}
