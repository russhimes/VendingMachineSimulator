package com.techelevator.view;

import java.math.BigDecimal;

public class Gum extends Snack{

    @Override
    public String getDisplayMessage() {
        return "Chew Chew, Yum!";
    }

    public Gum (String slot, String name, BigDecimal price, String typeOfSnack) {
        super (slot, name, price, typeOfSnack);
    }
}
