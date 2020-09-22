package com.company.equipments;

import static com.company.Constants.LIGHT;

public class Light extends Equipment {
    public Light() {
        this.power = 5;
        this.status = EquipmentStatus.OFF;
    }

    @Override
    public String Name() {
        return LIGHT;
    }

    @Override
    public double Power() {
        return this.power;
    }
}
