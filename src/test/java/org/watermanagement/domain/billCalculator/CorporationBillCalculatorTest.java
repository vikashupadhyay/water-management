package org.watermanagement.domain.billCalculator;

import org.junit.jupiter.api.Test;
import org.watermanagement.domain.Apartment;
import org.watermanagement.domain.ApartmentType;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CorporationBillCalculatorTest {

    @Test
    void shouldCalculateBill() {
        Apartment apartment = new Apartment(ApartmentType.THREE_BHK, 1, 5);
        CorporationBillCalculator corporationBillCalculator = new CorporationBillCalculator(apartment, 10, 30);
        assertEquals(250, corporationBillCalculator.calculate());
    }

    @Test
    void shouldAddSlabRates() {
        Apartment apartment = new Apartment(ApartmentType.THREE_BHK, 3, 7);
        CorporationBillCalculator calculator = new CorporationBillCalculator(apartment, 10, 30);
        calculator.addSlabRates();

        assertEquals(1, calculator.getSlabRates().size());
        assertEquals(Double.valueOf(1), calculator.getSlabRates().get(Integer.MAX_VALUE));
    }

}