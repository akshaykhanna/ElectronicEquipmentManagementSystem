package com.company.floors;

import com.company.Constants;
import com.company.equipments.EquipmentStatus;

public class MainCorridor extends Corridor {

    public MainCorridor() {
        super(Constants.MAIN_CORRIDOR);
        this.addEquipments();
        this.setIntialState();
    }

    @Override
    protected void setIntialState() {
        this.equipments.forEach(equipment -> {
            equipment.Status(EquipmentStatus.ON);
        });
    }

    @Override
    public void reset() {
        this.setIntialState();
    }
}
