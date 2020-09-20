package com.company;

import com.company.equipments.Equipment;
import com.company.floors.Corridor;
import com.company.floors.Floor;
import com.company.floors.Floors;

public class ElectronicEquipmentManagementSystem {
    Floors floors;

    public ElectronicEquipmentManagementSystem(int noOfFloors, int noOfCorridorPerFloor, int noOfSubCorridorPerFloor) {
        this.floors = new Floors(noOfFloors, noOfCorridorPerFloor, noOfSubCorridorPerFloor);
    }

    public String controllerOutput() {
        String out = "";
        for (int floorIndex = 0; floorIndex < this.floors.size(); floorIndex++) {
            out += String.format("Floor %d\n", (floorIndex + 1));
            Floor floor = this.floors.get(floorIndex);
            int mainCorridorNo = 0, subCorridorNo = 0;
            for (Corridor corridor : floor.getCorridors()) {
                if (corridor.getType() == Constants.MAIN_CORRIDOR) {
                    out += String.format("Main Corridor %d ", ++mainCorridorNo);
                } else if (corridor.getType() == Constants.SUB_CORRIDOR) {
                    out += String.format("Sub Corridor %d ", ++subCorridorNo);
                }
                String line = "";
                for (int equipmentIndex = 0; equipmentIndex < corridor.getEquipments().size(); equipmentIndex++) {
                    Equipment equipment = corridor.getEquipments().get(equipmentIndex);
                    if (equipment.Name() == Constants.LIGHT)
                        line += String.format("%s %d : %s ", equipment.Name(),
                                corridor.getType() == Constants.MAIN_CORRIDOR ? mainCorridorNo : subCorridorNo,
                                equipment.Status().label);
                    else
                        line += String.format("%s : %s ", equipment.Name(), equipment.Status().label);
                }
                out += line.trim() + "\n";
            }

        }
        return out;
    }
}
