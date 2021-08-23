package com.techelevator.view;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class ChipsTest {


    @Test
    public void test_get_slot() {

        BigDecimal price = new BigDecimal(3.05);
        Snack chips = new Chips("A1", "Potato Crisp", price, "Chip");
        String expectedSlot = "A1";
        String actualSlot = chips.getSlot();

        assertEquals(expectedSlot, actualSlot);

    }

    @Test
    public void test_get_name() {

        BigDecimal price = new BigDecimal(1.45);
        Snack chips = new Chips("A2", "Stackers", price, "Chip");
        String expectedName = "Stackers";
        String actualName = chips.getName();

        assertEquals(expectedName, actualName);
    }

    @Test
    public void test_get_price() {

        BigDecimal price = new BigDecimal(2.75);
        Snack chips = new Chips("A3", "Grain Waves", price, "Chip");
        BigDecimal expectedPrice = new BigDecimal(2.75);
        BigDecimal actualPrice = chips.getPrice();

        assertEquals(expectedPrice, actualPrice);
    }

    @Test
    public void test_get_type_of_snack() {

        BigDecimal price = new BigDecimal(3.65);
        Snack chips = new Chips("A4", "Cloud Popcorn", price, "Chip");
        String expectedType = "Chip";
        String actualType = chips.getTypeOfSnack();

        assertEquals(expectedType, actualType);
    }

    @Test
    public void test_get_display_message() {

        BigDecimal price = new BigDecimal(3.65);
        Snack chips = new Chips("A4", "Cloud Popcorn", price, "Chip");
        String expectedDisplay = "Crunch Crunch, Yum!";
        String actualDisplay = chips.getDisplayMessage();

        assertEquals(expectedDisplay, actualDisplay);
    }

    @Test
    public void test_decrement_snack() {

        BigDecimal price = new BigDecimal(3.05);
        Snack chips = new Chips("A1", "Potato Crisp", price, "Chip");
        int expectedNumAvailable = 4;
        chips.decrementSnack();
        int actualNumAvailable = chips.getNumAvailable();

        assertEquals(expectedNumAvailable, actualNumAvailable);
    }
}
