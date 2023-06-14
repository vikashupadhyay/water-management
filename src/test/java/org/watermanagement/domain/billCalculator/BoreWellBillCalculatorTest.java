package org.watermanagement.domain.billCalculator;

import org.junit.jupiter.api.Test;
import org.watermanagement.domain.Apartment;
import org.watermanagement.domain.ApartmentType;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BoreWellBillCalculatorTest {
    @Test
    void shouldCalculateBill() {
        Apartment apartment = new Apartment(ApartmentType.THREE_BHK, 1, 5);
        BoreWellBillCalculator boreWellBillCalculator = new BoreWellBillCalculator(apartment, 10, 30);
        assertEquals(1875, boreWellBillCalculator.calculate());
    }

    @Test
    void shouldAddSlabRates() {
        Apartment apartment = new Apartment(ApartmentType.THREE_BHK, 3, 7);
        BoreWellBillCalculator calculator = new BoreWellBillCalculator(apartment, 10, 30);
        calculator.addSlabRates();

        assertEquals(1, calculator.getSlabRates().size());
        assertEquals(Double.valueOf(1.5), calculator.getSlabRates().get(Integer.MAX_VALUE));
    }

}