package com.company.equipments;

import com.company.Constants;

public class AC extends Equipment {
    @Override
    public String Name() {
        return Constants.AC;
    }

    @Override
    public double Power() {
        return 10;
    }
}
