package com.company.floors;

import com.company.Constants;
import com.company.equipments.Light;

public class MainCorridor extends Corridor {

    public MainCorridor() {
        super(Constants.MAIN_CORRIDOR);
        this.equipments.add(new Light());
        this.addGenericEquipments();
    }
}
