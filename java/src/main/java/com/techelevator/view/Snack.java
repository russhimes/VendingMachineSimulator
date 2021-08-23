package com.techelevator.view;

import java.math.BigDecimal;

public abstract class Snack {

    private String name;
    private BigDecimal price;
    private String slot;
//    private String message;
    private String typeOfSnack;
    private int numAvailable = 5;

    public Snack (String slot, String name, BigDecimal price, String typeOfSnack) {
        this.name = name;
        this.price = price;
        this.slot = slot;
        this.typeOfSnack = typeOfSnack;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getSlot() {
        return slot;
    }

    public String getTypeOfSnack() {
        return typeOfSnack;
    }

    public int getNumAvailable() {
        return numAvailable;
    }

    public void decrementSnack () {
        numAvailable --;
    }

    public abstract String getDisplayMessage ();
}
