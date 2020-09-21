package com.company.equipments;

public abstract class Equipment {
    protected EquipmentStatus status;

    public abstract String Name();

    public abstract double Power();

    public EquipmentStatus Status() {
        return this.status;
    }

    public void Status(EquipmentStatus status) {
        this.status = status;
    }
}
