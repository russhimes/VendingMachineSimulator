package com.techelevator.view;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class CandyTest {

    @Test
    public void test_get_slot() {

        BigDecimal price = new BigDecimal(1.50);
        Snack candy = new Candy("B3", "Wonka Bar", price, "Candy");
        String expectedSlot = "B3";
        String actualSlot = candy.getSlot();

        assertEquals(expectedSlot, actualSlot);

    }

    @Test
    public void test_get_name() {

        BigDecimal price = new BigDecimal(1.80);
        Snack candy = new Candy("B1", "Moonpie", price, "Candy");
        String expectedName = "Moonpie";
        String actualName = candy.getName();

        assertEquals(expectedName, actualName);
    }

    @Test
    public void test_get_price() {

        BigDecimal price = new BigDecimal(1.50);
        Snack candy = new Candy("B2", "Cowtales", price, "Candy");
        BigDecimal expectedPrice = new BigDecimal(1.50);
        BigDecimal actualPrice = candy.getPrice();

        assertEquals(expectedPrice, actualPrice);
    }

    @Test
    public void test_get_type_of_snack() {

        BigDecimal price = new BigDecimal(1.75);
        Snack candy = new Candy("B4", "Crunchie", price, "Candy");
        String expectedType = "Candy";
        String actualType = candy.getTypeOfSnack();

        assertEquals(expectedType, actualType);
    }

    @Test
    public void test_get_display_message() {

        BigDecimal price = new BigDecimal(1.75);
        Snack candy = new Candy("B4", "Crunchie", price, "Candy");
        String expectedDisplay = "Munch Munch, Yum!";
        String actualDisplay = candy.getDisplayMessage();

        assertEquals(expectedDisplay, actualDisplay);
    }


}