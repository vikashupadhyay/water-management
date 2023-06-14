package org.watermanagement.rates;

public enum BorewellWaterRates {
    ANY_QUANTITY(Integer.MAX_VALUE, 1.5);

    private final int limit;
    private final double rate;

    BorewellWaterRates(int limit, double rate) {
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
