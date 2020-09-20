package com.company.equipments;

import static com.company.Constants.LIGHT;

public class Light extends Equipment {
    public Light(){

    }

    public Light(EquipmentStatus status) {
        this.status = status;
    }

    @Override
    public String Name() {
        return LIGHT;
    }

    @Override
    public double Power() {
        return 5;
    }
}
