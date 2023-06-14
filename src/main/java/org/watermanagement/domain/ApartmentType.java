package org.watermanagement.domain;

public enum ApartmentType {
    TWO_BHK(3),
    THREE_BHK(5);

    private final int noOfPerson;

    ApartmentType(int noOfPerson) {
        this.noOfPerson = noOfPerson;
    }

    public int getNoOfPerson() {
        return noOfPerson;
    }
}
