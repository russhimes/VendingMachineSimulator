package com.techelevator.view;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class VendingMachineTest {

    public List<Snack> testList = new ArrayList<>();
    Snack testChips = new Chips("A1", "Potato Crisps", new BigDecimal(3.05), "Chip");
    Snack testCandy = new Candy("B1", "Moonpie", new BigDecimal(1.80), "Candy");
    Snack testDrink = new Drinks("C1", "Cola", new BigDecimal(1.25), "Drinks");

    public VendingMachineTest() {
        testList.add(testChips);
        testList.add(testCandy);
        testList.add(testDrink);
    }

    @Test
    public void test_constructor_properly() {
        VendingMachine testVendingMachine = new VendingMachine(testList);
        Balance testBalance = testVendingMachine.getBalance();
        BigDecimal actualCurrentBalance = testBalance.getCurrentBalance();
        BigDecimal expectedCurrentBalance = new BigDecimal("0.00");

        assertEquals(expectedCurrentBalance, actualCurrentBalance);

        List actualListOfSnacks = testVendingMachine.getListOfSnacks();
        List expectedListOfSnacks = testList;

        assertEquals(expectedListOfSnacks, actualListOfSnacks);
    }

    @Test
    public void test_feed_money() {
        VendingMachine testVendingMachine = new VendingMachine(testList);

        testVendingMachine.feedMoney(new BigDecimal("2.00"));
        BigDecimal actualValue = testVendingMachine.getBalance().getCurrentBalance();
        BigDecimal expectedValue = new BigDecimal("2.00");

        assertEquals(expectedValue, actualValue);

        boolean throwsException = false;

        try {
            testVendingMachine.feedMoney(new BigDecimal("1.75"));
        } catch(ArithmeticException e) {
           throwsException = true;
        }

        assertEquals(throwsException, true);
    }
}

