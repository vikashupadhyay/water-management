package org.watermanagement.service;

import org.watermanagement.domain.Apartment;
import org.watermanagement.domain.ApartmentType;
import org.watermanagement.domain.billCalculator.BillCalculator;
import org.watermanagement.domain.billCalculator.BoreWellBillCalculator;
import org.watermanagement.domain.billCalculator.CorporationBillCalculator;
import org.watermanagement.domain.billCalculator.TankWaterBillCalculator;

import java.util.Arrays;
import java.util.List;

public class WaterManagementService {

    private Apartment apartment;
    private final int billableDays;
    private final int perDayAllocatedWater;
    private int totalWaterConsumed;
    private int totalBill;

    public WaterManagementService(int billableDays, int perDayAllocatedWater) {
        this.billableDays = billableDays;
        this.perDayAllocatedWater = perDayAllocatedWater;
    }

    public void allotWater(ApartmentType apartmentType, int corporateWaterShare, int borewellWaterShare) {
        this.apartment = new Apartment(apartmentType, corporateWaterShare, borewellWaterShare);
        calculateWaterConsumption();
    }

    public void addGuests(int guests) {
        apartment.addGuests(guests);
        calculateWaterConsumption();
    }

    private void calculateWaterConsumption() {
        int totalNoOfPeople = apartment.getTotalPerson() + apartment.getTotalGuests();
        this.totalWaterConsumed = totalNoOfPeople * billableDays * perDayAllocatedWater;
    }

    public void calculateTotalBill() {
        List<BillCalculator> billCalculators = getBillCalculators();
        double billValue = billCalculators.stream()
                .mapToDouble(BillCalculator::calculate)
                .sum();
        this.totalBill = (int) Math.round(billValue);
    }

    private List<BillCalculator> getBillCalculators() {
        return Arrays.asList(
                new CorporationBillCalculator(apartment, perDayAllocatedWater, billableDays),
                new BoreWellBillCalculator(apartment, perDayAllocatedWater, billableDays),
                new TankWaterBillCalculator(apartment, perDayAllocatedWater, billableDays)
        );
    }

    public int getTotalWaterConsumed() {
        return totalWaterConsumed;
    }

    public int getTotalBill() {
        return totalBill;
    }

}
