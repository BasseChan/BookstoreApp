package com.example.productlist.model;

public class AvailabilityFormClass {
    private long id;
    private int availability;

    public AvailabilityFormClass(long id, int availability) {
        this.id = id;
        this.availability = availability;
    }

    public AvailabilityFormClass() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getAvailability() {
        return availability;
    }

    public void setAvailability(int availability) {
        this.availability = availability;
    }
}
