package org.watermanagement.domain.billCalculator;

import org.watermanagement.domain.Apartment;
import org.watermanagement.rates.CorporationWaterRates;

import java.util.Arrays;

public class CorporationBillCalculator extends WaterBillCalculater {
    public CorporationBillCalculator(Apartment apartment, int allocatedWater, int billableDays) {
        super(apartment.getTotalPerson(), allocatedWater, billableDays, getRatio(apartment));

    }

    private static double getRatio(Apartment apartment) {
        return (double) apartment.getCorporateWaterShare() / apartment.getTotalShare();
    }

    @Override
    public void addSlabRates() {
        Arrays.stream(CorporationWaterRates.values())
                .forEach(rate -> getSlabRates().put(rate.getLimit(), rate.getRate()));
    }

}
