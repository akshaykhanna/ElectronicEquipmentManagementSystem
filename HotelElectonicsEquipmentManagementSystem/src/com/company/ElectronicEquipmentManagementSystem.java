package com.company;

import com.company.equipments.Equipment;
import com.company.floors.Corridor;
import com.company.floors.Floors;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class ElectronicEquipmentManagementSystem {
    Floors floors;

    public ElectronicEquipmentManagementSystem(int noOfFloors, int noOfCorridorPerFloor, int noOfSubCorridorPerFloor) {
        this.floors = new Floors(noOfFloors, noOfCorridorPerFloor, noOfSubCorridorPerFloor);
    }

    public String controllerOutput() {
        String out = "";
        for (int floorIndex = 0; floorIndex < this.floors.size(); floorIndex++) {
            out += floorOutput(floorIndex) + corridorOutput(this.floors.get(floorIndex).getCorridors());
        }
        return out;
    }

    private String floorOutput(int floorIndex) {
        return String.format("Floor %d\n", (floorIndex + 1));
    }

    private String corridorOutput(ArrayList<Corridor> corridors) {
        return eachCorridorOutput(filterCorridors(corridors, Constants.MAIN_CORRIDOR))
                + eachCorridorOutput(filterCorridors(corridors, Constants.SUB_CORRIDOR));
    }

    private String eachCorridorOutput(ArrayList<Corridor> corridors) {
        String corridorOut = "";
        for (int corridorIndex = 0; corridorIndex < corridors.size(); corridorIndex++) {
            Corridor corridor = corridors.get(corridorIndex);
            corridorOut += String.format("%s %d ", corridor.getType(), (corridorIndex + 1))
                    + equipmentOutput(corridor, corridorIndex + 1).trim()
                    + "\n";
        }
        return corridorOut;
    }


    private String equipmentOutput(Corridor corridor, int corridorNo) {
        String line = "";
        for (int equipmentIndex = 0; equipmentIndex < corridor.getEquipments().size(); equipmentIndex++) {
            Equipment equipment = corridor.getEquipments().get(equipmentIndex);
            line += String.format("%s : %s ", equipmentPreColonOut(corridorNo, equipment), equipment.Status().label);
        }
        return line;
    }

    private String equipmentPreColonOut(int corridorNo, Equipment equipment) {
        if (equipment.Name() == Constants.LIGHT)
            return String.format("%s %d", equipment.Name(), corridorNo);
        return String.format("%s", equipment.Name());

    }

    private ArrayList<Corridor> filterCorridors(ArrayList<Corridor> corridors, String corridorType) {
        return new ArrayList<Corridor>(corridors.stream().filter(q -> q.getType() == corridorType)
                .collect(Collectors.toList()));
    }
}
