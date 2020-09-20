package com.company.floors;

import com.company.Constants;
import com.company.equipments.EquipmentStatus;
import com.company.equipments.Light;

public class SubCorridor extends Corridor {
    public SubCorridor() {
        super(Constants.SUB_CORRIDOR);
        this.equipments.add(new Light(EquipmentStatus.OFF));
        this.addGenericEquipments();
    }
}
