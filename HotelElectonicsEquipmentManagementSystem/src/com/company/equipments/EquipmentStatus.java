package com.company.equipments;

public enum EquipmentStatus {
    ON("ON"),
    OFF("OFF");
    public final String label;

    EquipmentStatus(String label) {
        this.label = label;
    }
}
