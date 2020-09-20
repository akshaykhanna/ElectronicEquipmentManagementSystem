package com.company.floors;

import com.company.Constants;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Floor {

    private final ArrayList<Corridor> corridors;

    public Floor(int noOfMainCorridor, int noOfSubCorridor) {
        this.corridors = new ArrayList();
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

    public ArrayList<Corridor> getCorridors(String corridorType) {
        return new ArrayList(this.corridors.stream().filter(q -> q.getType() == corridorType)
                .collect(Collectors.toList()));
    }
}
