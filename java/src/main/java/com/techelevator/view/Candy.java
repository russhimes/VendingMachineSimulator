package com.techelevator.view;

import java.math.BigDecimal;

public class Candy extends Snack {

    @Override
    public String getDisplayMessage() {
        return "Munch Munch, Yum!";
    }

    public Candy (String slot, String name, BigDecimal price, String typeOfSnack) {
        super (slot, name, price, typeOfSnack);
    }
}
