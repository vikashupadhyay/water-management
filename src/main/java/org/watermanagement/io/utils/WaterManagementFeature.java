package org.watermanagement.io.utils;

import org.watermanagement.domain.ApartmentType;
import org.watermanagement.service.WaterManagementService;
import org.watermanagement.service.command.Actions;

import java.util.Objects;

public class WaterManagementFeature implements Functionality {
    private final WaterManagementService waterManagementService;

    public WaterManagementFeature(WaterManagementService waterManagementService) {
        this.waterManagementService = waterManagementService;
    }

    @Override
    public void allocateWater(String lineInput) {
        String[] inputs = lineInput.split(" ");
        int numOfBedrooms = Integer.parseInt(inputs[1]);
        String[] ratios = inputs[2].split(":");
        int corporationWaterRatio = Integer.parseInt(ratios[0]);
        int borewellWaterRatio = Integer.parseInt(ratios[1]);
        ApartmentType apartmentType = numOfBedrooms == 2 ? ApartmentType.TWO_BHK : ApartmentType.THREE_BHK;
        waterManagementService.allotWater(apartmentType, corporationWaterRatio, borewellWaterRatio);
    }

    @Override
    public void addGuests(String lineInput) {
        String[] inputs = lineInput.split(" ");
        int numOfGuests = Integer.parseInt(inputs[1]);
        waterManagementService.addGuests(numOfGuests);
    }

    @Override
    public void calculateBill(String lineInput) {
        if (!Objects.equals(lineInput, Actions.BILL.name())) {
            return;
        }
        waterManagementService.calculateTotalBill();
    }
}
