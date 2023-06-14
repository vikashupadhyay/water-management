package org.watermanagement.domain.billCalculator;

import org.watermanagement.domain.Apartment;
import org.watermanagement.rates.BorewellWaterRates;

import java.util.Arrays;

public class BoreWellBillCalculator extends WaterBillCalculater {
    public BoreWellBillCalculator(Apartment apartment, int allocatedWater, int billableDays) {
        super(apartment.getTotalPerson(), allocatedWater, billableDays, getRatio(apartment));
    }

    @Override
    public void addSlabRates() {
        Arrays.stream(BorewellWaterRates.values())
                .forEach(rate -> getSlabRates().put(rate.getLimit(), rate.getRate()));
    }

    private static double getRatio(Apartment apartment) {
        return (double) (apartment.getTotalShare() - apartment.getCorporateWaterShare()) / apartment.getTotalShare();
    }


}
