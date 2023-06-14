package org.watermanagement.io.utils;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.watermanagement.domain.ApartmentType;
import org.watermanagement.service.WaterManagementService;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;

@ExtendWith(MockitoExtension.class)
class WaterManagementFeatureTest {

    @Mock
    WaterManagementService waterManagementService;

    @InjectMocks
    WaterManagementFeature waterManagementFeature;

    @Nested
    class AllocateWaterTest {
        @Test
        void shouldAllocateWaterFor3BHKApartment() {
            waterManagementFeature.allocateWater("ALLOT_WATER 3 2:1");

            verify(waterManagementService, times(1)).allotWater(ApartmentType.THREE_BHK, 2, 1);
        }

        @Test
        void shouldAllocateWaterFor2BHKApartment() {

            waterManagementFeature.allocateWater("ALLOT_WATER 2 2:1");

            verify(waterManagementService, times(1)).allotWater(ApartmentType.TWO_BHK, 2, 1);
        }

    }

    @Nested
    class AddGuestsTest {

        @Test
        void shouldAddGuests() {
            waterManagementFeature.addGuests("ADD_GUESTS 4");

            verify(waterManagementService, times(1)).addGuests(4);
        }
    }

    @Nested
    class CalculateBillTest {

        @Test
        void shouldCalculateBill() {
            waterManagementFeature.calculateBill("BILL");

            verify(waterManagementService, times(1)).calculateTotalBill();
        }

        @Test
        void shouldNotCalculateBillWhenInvalidInputPassed() {
            waterManagementFeature.calculateBill("ALLOT_WATER");
            verifyNoInteractions(waterManagementService);
        }

    }
}