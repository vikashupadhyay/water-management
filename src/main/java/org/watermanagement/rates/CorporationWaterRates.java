package org.watermanagement.rates;

public enum CorporationWaterRates {
    ANY_QUANTITY(Integer.MAX_VALUE, 1.0);

    private final int limit;
    private final double rate;

    CorporationWaterRates(int limit, double rate) {
        this.limit = limit;
        this.rate = rate;
    }

    public int getLimit() {
        return limit;
    }

    public double getRate() {
        return rate;
    }
}
