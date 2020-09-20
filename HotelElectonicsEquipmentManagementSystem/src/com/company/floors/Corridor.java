package com.company.floors;

import com.company.equipments.AC;
import com.company.equipments.Equipment;

import java.util.ArrayList;

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

    protected void addGenericEquipments() {
        this.equipments.add(new AC());
    }
}
