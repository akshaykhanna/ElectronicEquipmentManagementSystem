package com.company.floors;

public class Floor {

    private final FloorUnit[] mainCorridors;
    private final FloorUnit[] subCorridors;

    public Floor(int noOfCorridor, int noOfSubCorridor) {
        this.mainCorridors = new MainCorridor[noOfCorridor];
        createMainCorridors(noOfCorridor);
        this.subCorridors = new SubCorridor[noOfSubCorridor];
    }

    private void createMainCorridors(int noOfCorridor) {
        for (FloorUnit mainCorridor : this.mainCorridors) {
            mainCorridor = new MainCorridor();
        }
    }
}
