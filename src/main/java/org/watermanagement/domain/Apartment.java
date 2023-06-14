package org.watermanagement.domain;

public class Apartment {
    private ApartmentType apartmentType;
    private int corporateWaterShare;

    private int boreWellWaterShare;
    private int guests;

    public Apartment(ApartmentType apartmentType, int corporateWaterShare, int boreWellWaterShare) {
        this.apartmentType = apartmentType;
        this.corporateWaterShare = corporateWaterShare;
        this.boreWellWaterShare = boreWellWaterShare;
    }

    public void addGuests(int guests) {
        this.guests += guests;
    }

    public int getTotalPerson() {
        return apartmentType.getNoOfPerson();
    }

    public int getTotalGuests() {
        return this.guests;
    }

    public int getCorporateWaterShare() {
        return corporateWaterShare;
    }

    public int getTotalShare() {
        return corporateWaterShare + boreWellWaterShare;
    }
}
