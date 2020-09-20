package com.company.floors;

import java.util.ArrayList;

public class Floors extends ArrayList<Floor> {

    public Floors(int noOfFloors, int noOfMainCorridorPerFloor, int noOfSubCorridorPerFloor) {
        createFloors(noOfFloors, noOfMainCorridorPerFloor, noOfSubCorridorPerFloor);
    }

    private void createFloors(int noOfFloors, int noOfMainCorridorPerFloor, int noOfSubCorridorPerFloor) {
        for (int i = 0; i < noOfFloors; i++) {
            this.add(new Floor(noOfMainCorridorPerFloor, noOfSubCorridorPerFloor));
        }
    }

}
