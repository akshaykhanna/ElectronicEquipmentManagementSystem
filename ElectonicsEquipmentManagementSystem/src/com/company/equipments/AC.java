package com.company.equipments;

import com.company.Constants;

public class AC extends Equipment {
    public AC() {
        this.power = 10;
        this.status = EquipmentStatus.OFF;
    }

    @Override
    public String Name() {
        return Constants.AC;
    }

    @Override
    public double Power() {
        return this.power;
    }
}
