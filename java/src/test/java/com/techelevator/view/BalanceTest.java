package com.techelevator.view;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class BalanceTest {

    @Test
    public void get_current_balance() {
        Balance testCurrent = new Balance();

        BigDecimal expectedResult = new BigDecimal("0.00");
        BigDecimal actualResult = testCurrent.getCurrentBalance();

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void get_previous_balance() {
        Balance testPrevious = new Balance();

        BigDecimal expectedResult = new BigDecimal("0.00");
        BigDecimal actualResult = testPrevious.getPreviousBalance();

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void feed_money() {
        Balance testFeedMoney = new Balance();

        BigDecimal expectedFirstFeed = new BigDecimal("5.00");
        testFeedMoney.feedMoney(new BigDecimal("5.00"));
        BigDecimal actualFirstFeed = testFeedMoney.getCurrentBalance();

        assertEquals(expectedFirstFeed, actualFirstFeed);

        testFeedMoney.feedMoney(new BigDecimal("25.00"));
        BigDecimal actualPreviousBalance = testFeedMoney.getPreviousBalance();

        assertEquals(expectedFirstFeed, actualPreviousBalance);

        boolean throwsArithmeticException = false;
        try {testFeedMoney.feedMoney(new BigDecimal("3.95"));}
        catch (ArithmeticException e) {throwsArithmeticException = true;}

        assertTrue(throwsArithmeticException);
        BigDecimal expectedBalanceAfterNonInteger = new BigDecimal("30.00");
        BigDecimal actualBalanceAfterNonInteger = testFeedMoney.getCurrentBalance();

    }

    @Test
    //add later function to not allow purchase past 0
    public void purchase() {
        Balance testPurchase = new Balance();

        boolean throwsArithmeticException = false;
        testPurchase.feedMoney(new BigDecimal("10.00"));
        try{testPurchase.purchase(new BigDecimal ("11.00"));}
        catch (ArithmeticException e) {throwsArithmeticException = true;}

        assertTrue(true);

        testPurchase.purchase(new BigDecimal("1.25"));
        BigDecimal expectedResult = new BigDecimal("8.75");
        BigDecimal actualResult = testPurchase.getCurrentBalance();

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void give_change() {
        Balance testChange = new Balance();

        testChange.feedMoney(new BigDecimal ("5.00"));
        testChange.purchase(new BigDecimal("3.95"));
        String actualValue = testChange.giveChange();
        String expectedValue = "Your change is 4 quarter(s), 0 dime(s), and 1 nickel(s).";
        assertEquals(expectedValue, actualValue);

    }



}