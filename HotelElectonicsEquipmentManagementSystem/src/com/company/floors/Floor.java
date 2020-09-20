package com.company.floors;

import com.company.Constants;

import java.util.ArrayList;

public class Floor {

    private final ArrayList corridors;

    public Floor(int noOfMainCorridor, int noOfSubCorridor) {
        this.corridors = new ArrayList<Corridor>();
        for (int i = 0; i < noOfMainCorridor; i++) {
            this.corridors.add(new MainCorridor());
        }
        for (int i = 0; i < noOfSubCorridor; i++) {
            this.corridors.add(new SubCorridor());
        }
    }

    public ArrayList<Corridor> getCorridors() {
        return corridors;
    }
}
