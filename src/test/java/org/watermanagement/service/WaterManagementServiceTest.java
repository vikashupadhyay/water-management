package org.watermanagement.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.watermanagement.domain.ApartmentType;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WaterManagementServiceTest {

    private WaterManagementService waterManagementService;

    @BeforeEach
    void setup() {
        waterManagementService = new WaterManagementService(30, 10);
    }

    @Test
    void shouldAllotWater() {
        waterManagementService.allotWater(ApartmentType.TWO_BHK, 1, 2);

        assertEquals(waterManagementService.getTotalWaterConsumed(), 900);
    }

    @Test
    void shouldCalculateBill() {
        waterManagementService.allotWater(ApartmentType.TWO_BHK, 1, 2);
        waterManagementService.calculateTotalBill();

        assertEquals(waterManagementService.getTotalBill(), 1200);
    }

    @Test
    void shouldCalculateBillWhenGuestsArePresent() {
        waterManagementService.allotWater(ApartmentType.THREE_BHK, 1, 5);
        waterManagementService.addGuests(10);
        waterManagementService.calculateTotalBill();

        assertEquals(waterManagementService.getTotalBill(), 13625);
    }
}