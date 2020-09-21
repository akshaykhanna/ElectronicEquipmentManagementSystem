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

    public boolean isExceedingMaxPower() {
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

    public void handleMovement(String corridorType, int corridorNo) {
        if (corridorType == Constants.SUB_CORRIDOR) {
            this.getCorridors(Constants.SUB_CORRIDOR).get(corridorNo - 1).turnOnLight();
            this.balanceLoad();

        }
    }

    private void balanceLoad() {
        if (this.isExceedingMaxPower()) {
            this.turnOffEquipmentToReducePower();
        }
    }

    private void turnOffEquipmentToReducePower() {
        for (Corridor subCorridor : this.getCorridors(Constants.SUB_CORRIDOR)) {
            if (subCorridor.turnOffACIfOn()) {
                break;
            }
        }
    }
}
