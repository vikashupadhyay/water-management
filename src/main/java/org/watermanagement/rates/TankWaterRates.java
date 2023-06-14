package org.watermanagement.rates;

public enum TankWaterRates {
    UNDER_FIVE_HUNDRED(500, 2.0),
    FIVE_HUNDRED_TO_FIFTEEN_HUNDRED(1500, 3.0),
    FIFTEEN_HUNDRED_TO_THREE_THOUSAND(3000, 5.0),
    MORE_THAN_THREE_THOUSAND(Integer.MAX_VALUE, 8.0);

    private final int limit;
    private final double rate;

    TankWaterRates(int limit, double rate) {
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
