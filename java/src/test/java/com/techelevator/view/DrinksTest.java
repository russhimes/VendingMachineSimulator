package com.techelevator.view;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class DrinksTest {

    @Test
    public void test_get_slot() {

        BigDecimal price = new BigDecimal(1.25);
        Snack drinks = new Drinks("C1", "Cola", price, "Drink");
        String expectedSlot = "C1";
        String actualSlot = drinks.getSlot();

        assertEquals(expectedSlot, actualSlot);

    }

    @Test
    public void test_get_name() {

        BigDecimal price = new BigDecimal(1.50);
        Snack drinks = new Drinks("C2", "Dr. Salt", price, "Drink");
        String expectedName = "Dr. Salt";
        String actualName = drinks.getName();

        assertEquals(expectedName, actualName);
    }

    @Test
    public void test_get_price() {

        BigDecimal price = new BigDecimal(1.50);
        Snack drinks = new Drinks("C3", "Mountain Melter", price, "Drink");
        BigDecimal expectedPrice = new BigDecimal(1.50);
        BigDecimal actualPrice = drinks.getPrice();

        assertEquals(expectedPrice, actualPrice);
    }

    @Test
    public void test_get_type_of_snack() {

        BigDecimal price = new BigDecimal(1.50);
        Snack drinks = new Chips("C4", "Heavy", price, "Drink");
        String expectedType = "Drink";
        String actualType = drinks.getTypeOfSnack();

        assertEquals(expectedType, actualType);
    }

    @Test
    public void test_get_display_message() {

        BigDecimal price = new BigDecimal(1.50);
        Snack drinks = new Drinks("C4", "Heavy", price, "Drink");
        String expectedDisplay = "Glug Glug, Yum!";
        String actualDisplay = drinks.getDisplayMessage();

        assertEquals(expectedDisplay, actualDisplay);
    }
}