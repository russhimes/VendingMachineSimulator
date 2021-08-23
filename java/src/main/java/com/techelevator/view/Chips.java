package com.techelevator.view;

import java.math.BigDecimal;

public class Chips extends Snack {

    @Override
    public String getDisplayMessage() {
        return "Crunch Crunch, Yum!";
    }

    public Chips(String slot, String name, BigDecimal price, String typeOfSnack) {
        super (slot, name, price, typeOfSnack);
    }
}
