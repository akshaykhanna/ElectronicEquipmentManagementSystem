package com.company.floors;

import com.company.Constants;
import com.company.equipments.EquipmentStatus;
import com.company.equipments.Light;

public class SubCorridor extends Corridor {
    public SubCorridor() {
        super(Constants.SUB_CORRIDOR);
        this.addEquipments();
        this.setIntialState();
    }

    @Override
    public void reset() {
        this.setIntialState();
    }

    @Override
    protected void setIntialState() {
        this.equipments.forEach(equipment -> {
            if (equipment.Name() != Constants.LIGHT) {
                equipment.Status(EquipmentStatus.ON);
            } else {
                equipment.Status(EquipmentStatus.OFF);

            }
        });
    }
}
