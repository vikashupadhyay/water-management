package org.watermanagement.domain.billCalculator;

import org.watermanagement.domain.Apartment;
import org.watermanagement.rates.TankWaterRates;

import java.util.Arrays;

public class TankWaterBillCalculator extends WaterBillCalculater {
    public TankWaterBillCalculator(Apartment apartment, int allocatedWater, int billableDays) {
        super(apartment.getTotalGuests(), allocatedWater, billableDays, 1);

    }

    @Override
    public void addSlabRates() {
        Arrays.stream(TankWaterRates.values())
                .forEach(rate -> getSlabRates().put(rate.getLimit(), rate.getRate()));

    }

}
