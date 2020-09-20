package com.company.floors;

public class FloorUnit {
    public void createFloorUnits(FloorUnit floorUnits[]) {
        for (FloorUnit floorUnit : floorUnits) {
            if (this instanceof MainCorridor)
                floorUnit = new MainCorridor();
            else if (this instanceof SubCorridor)
                floorUnit = new MainCorridor();
        }
    }
}
