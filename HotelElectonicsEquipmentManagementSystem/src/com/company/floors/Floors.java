package com.company.floors;

import java.util.ArrayList;

public class Floors extends ArrayList {

    public Floors(int noOfFloors, int noOfCorridorPerFloor, int noOfSubCorridorPerFloor) {
        createFloors(noOfFloors, noOfCorridorPerFloor, noOfSubCorridorPerFloor);
    }

    private void createFloors(int noOfFloors, int noOfCorridorPerFloor, int noOfSubCorridorPerFloor) {
        for (int i = 0; i < noOfFloors; i++) {
            this.add(new Floor(noOfCorridorPerFloor, noOfSubCorridorPerFloor));
        }
    }

}
