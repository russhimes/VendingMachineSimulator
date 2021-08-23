package com.techelevator.view;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class GumTest {

    @Test
    public void test_get_slot() {

        BigDecimal price = new BigDecimal(0.85);
        Snack gum = new Gum("D1", "U-Chews", price, "Gum");
        String expectedSlot = "D1";
        String actualSlot = gum.getSlot();

        assertEquals(expectedSlot, actualSlot);

    }

    @Test
    public void test_get_name() {

        BigDecimal price = new BigDecimal(0.95);
        Snack gum = new Gum("D2", "Little League", price, "Gum");
        String expectedName = "Little League";
        String actualName = gum.getName();

        assertEquals(expectedName, actualName);
    }

    @Test
    public void test_get_price() {

        BigDecimal price = new BigDecimal(0.75);
        Snack gum = new Gum("D3", "Chiclets", price, "Gum");
        BigDecimal expectedPrice = new BigDecimal(0.75);
        BigDecimal actualPrice = gum.getPrice();

        assertEquals(expectedPrice, actualPrice);
    }

    @Test
    public void test_get_type_of_snack() {

        BigDecimal price = new BigDecimal(0.75);
        Snack gum = new Gum("D4", "Triplemint", price, "Gum");
        String expectedType = "Gum";
        String actualType = gum.getTypeOfSnack();

        assertEquals(expectedType, actualType);
    }

    @Test
    public void test_get_display_message() {

        BigDecimal price = new BigDecimal(0.75);
        Snack gum = new Gum("D4", "Triplemint", price, "Gum");
        String expectedDisplay = "Chew Chew, Yum!";
        String actualDisplay = gum.getDisplayMessage();

        assertEquals(expectedDisplay, actualDisplay);
    }
}