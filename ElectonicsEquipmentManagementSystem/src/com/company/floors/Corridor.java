package com.company.floors;

import com.company.Constants;
import com.company.equipments.AC;
import com.company.equipments.Equipment;
import com.company.equipments.EquipmentStatus;

import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Collectors;

public class Corridor {
    protected String type;
    protected ArrayList<Equipment> equipments;

    public Corridor(String type) {
        this.type = type;
        this.equipments = new ArrayList<Equipment>();
    }

    public String getType() {
        return type;
    }

    public ArrayList<Equipment> getEquipments() {
        return equipments;
    }

    public ArrayList<Equipment> getEquipments(String equiptmentName) {
        return new ArrayList(this.equipments.stream().filter(q -> q.Name() == equiptmentName)
                .collect(Collectors.toList()));
    }

    protected void addGenericEquipments() {
        this.equipments.add(new AC());
    }

    public double totalPower() {
        return this.equipments.stream().filter(p -> p.Status() == EquipmentStatus.ON).map(p -> p.Power())
                .reduce((a, b) -> a + b).get().doubleValue();
    }

    public void turnOnLight() {
        this.getEquipments(Constants.LIGHT).get(0).Status(EquipmentStatus.ON);
    }

    public boolean turnOffACIfOn() {
        Equipment firstAC = this.getEquipments(Constants.AC).get(0);
        if (firstAC.Status() == EquipmentStatus.ON) {
            firstAC.Status(EquipmentStatus.OFF);
            return true;
        }
        return false;
    }
}
