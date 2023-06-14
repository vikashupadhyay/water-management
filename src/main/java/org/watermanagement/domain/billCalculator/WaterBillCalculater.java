package org.watermanagement.domain.billCalculator;

import java.util.HashMap;
import java.util.Map;

public abstract class WaterBillCalculater implements BillCalculator {

    private int people;
    private int litersPerPerson;
    private int days;
    private double ratio;

    public HashMap<Integer, Double> getSlabRates() {
        return slabRates;
    }

    private HashMap<Integer, Double> slabRates = new HashMap<>();

    public WaterBillCalculater(int people, int litersPerPerson, int days, double ratio) {
        this.people = people;
        this.litersPerPerson = litersPerPerson;
        this.days = days;
        this.ratio = ratio;
        addSlabRates();
    }

    public abstract void addSlabRates();

    public double calculate() {
        final double[] totalConsumption = {people * litersPerPerson * days * ratio};
        final int[] previousSlabLimit = {0};

        return slabRates.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .mapToDouble(slabLimit -> {
                    int slabDifference = slabLimit.getKey() - previousSlabLimit[0];
                    double slabRate = slabLimit.getValue();
                    double consumptionInSlab = Math.min(totalConsumption[0], slabDifference);

                    totalConsumption[0] -= consumptionInSlab;
                    previousSlabLimit[0] = slabLimit.getKey();

                    return consumptionInSlab * slabRate;
                })
                .sum() + totalConsumption[0] * slabRates.getOrDefault(Integer.MAX_VALUE, 0.0);
    }
}
