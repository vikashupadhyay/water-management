package org.watermanagement;

import org.watermanagement.io.InputProcessor;
import org.watermanagement.io.utils.WaterManagementFeature;
import org.watermanagement.service.WaterManagementService;

import java.io.IOException;

public class WaterManagementApp {
    static final int PER_PERSON_ALLOCATED_WATER = 10;
    static final int BILLABLE_DAYS_IN_MONTH = 30;

    public static void main(String[] args) throws IOException {
        if (args.length == 0) {
            System.out.println("Invalid input.");
            return;
        }

        String filePath = args[0];
        WaterManagementService waterManagementService = new WaterManagementService(BILLABLE_DAYS_IN_MONTH, PER_PERSON_ALLOCATED_WATER);
        WaterManagementFeature waterManagementFeature = new WaterManagementFeature(waterManagementService);
        InputProcessor inputProcessor = new InputProcessor(waterManagementFeature);
        inputProcessor
                .parse(filePath)
                .forEach(Runnable::run);

        System.out.println(waterManagementService.getTotalWaterConsumed() + " " + waterManagementService.getTotalBill());

    }
}