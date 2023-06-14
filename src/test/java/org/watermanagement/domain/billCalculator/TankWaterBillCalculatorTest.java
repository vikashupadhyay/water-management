package org.watermanagement.domain.billCalculator;

import org.junit.jupiter.api.Test;
import org.watermanagement.domain.Apartment;
import org.watermanagement.domain.ApartmentType;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TankWaterBillCalculatorTest {
    @Test
    void shouldCalculateBill() {
        Apartment apartment = new Apartment(ApartmentType.THREE_BHK, 1, 5);
        apartment.addGuests(10);
        TankWaterBillCalculator tankWaterBillCalculator = new TankWaterBillCalculator(apartment, 10, 30);
        assertEquals(11500, tankWaterBillCalculator.calculate());
    }

    @Test
    void shouldAddSlabRates() {
        Apartment apartment = new Apartment(ApartmentType.THREE_BHK, 3, 7);
        TankWaterBillCalculator calculator = new TankWaterBillCalculator(apartment, 10, 30);
        calculator.addSlabRates();

        assertEquals(4, calculator.getSlabRates().size());
        assertEquals(Double.valueOf(2), calculator.getSlabRates().get(500));
        assertEquals(Double.valueOf(3), calculator.getSlabRates().get(1500));
        assertEquals(Double.valueOf(5), calculator.getSlabRates().get(3000));
        assertEquals(Double.valueOf(8), calculator.getSlabRates().get(Integer.MAX_VALUE));
    }
}