package com.company.floors;

import java.util.ArrayList;

public class Floors extends ArrayList<Floor> {
    public Floors(int noOfFloors, int noOfMainCorridorPerFloor, int noOfSubCorridorPerFloor) {
        for (int i = 0; i < noOfFloors; i++) {
            this.add(new Floor(noOfMainCorridorPerFloor, noOfSubCorridorPerFloor));
        }
    }

    public Floor getFloor(int floorNo) {
        return this.get(floorNo - 1);
    }

    public void reset() {
        this.forEach(floor -> floor.reset());
    }
}
