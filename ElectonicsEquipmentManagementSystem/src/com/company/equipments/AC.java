package com.company.equipments;

import com.company.Constants;

public class AC extends Equipment {
    public AC() {
        this.status = EquipmentStatus.ON;
    }

    @Override
    public String Name() {
        return Constants.AC;
    }

    @Override
    public double Power() {
        return 10;
    }
}
