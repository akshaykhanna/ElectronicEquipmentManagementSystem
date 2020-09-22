package com.company.floors;

import com.company.Constants;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Floor {
    private final ArrayList<Corridor> corridors;
    private final int noOfMainCorridor;
    private final int noOfSubCorridor;

    public Floor(int noOfMainCorridor, int noOfSubCorridor) {
        this.noOfMainCorridor = noOfMainCorridor;
        this.noOfSubCorridor = noOfSubCorridor;
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

    public void turnOnLight(String corridorType, int corridorNo) {
        this.getCorridors(Constants.SUB_CORRIDOR).get(corridorNo - 1).turnOnLight();
    }

    public void balanceLoad() {
        if (this.isExceedingMaxPower()) {
            this.turnOffEquipmentToReducePower();
        }
    }

    private boolean isExceedingMaxPower() {
        return totalPower() > maxFloorPower();
    }

    private double totalPower() {
        double power = 0;
        for (Corridor corridor : this.corridors) {
            power += corridor.totalPower();
        }
        return power;
    }

    private double maxFloorPower() {
        return (this.noOfMainCorridor * 15) + (this.noOfSubCorridor * 10);
    }

    private void turnOffEquipmentToReducePower() {
        for (Corridor subCorridor : this.getCorridors(Constants.SUB_CORRIDOR)) {
            if (subCorridor.turnOffACIfOn()) {
                break;
            }
        }
    }
}
