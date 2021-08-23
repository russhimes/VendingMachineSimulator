package com.techelevator.view;

import java.math.BigDecimal;

public class Drinks extends Snack{

    @Override
    public String getDisplayMessage() {
        return "Glug Glug, Yum!";
    }

    public Drinks (String slot, String name, BigDecimal price, String typeOfSnack) {
        super (slot, name, price, typeOfSnack);
    }
}
