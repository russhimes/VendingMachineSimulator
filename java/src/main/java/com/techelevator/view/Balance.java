package com.techelevator.view;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class Balance {

    private BigDecimal currentBalance = new BigDecimal("0.00");
    private BigDecimal previousBalance = new BigDecimal("0.00");

    public void feedMoney(BigDecimal feed) throws ArithmeticException{

        this.previousBalance = this.currentBalance;
        boolean isFinished = false;
        BigDecimal times100 = feed.multiply(new BigDecimal("100.00").setScale(2, RoundingMode.HALF_UP));
        int feedInPennies = times100.intValue();
        if (feedInPennies % 100 == 0) {
            this.currentBalance = this.currentBalance.add(feed).setScale(2, RoundingMode.HALF_UP);
        }
        else {
            throw new ArithmeticException();
        }

    }

    public void purchase(BigDecimal price) throws ArithmeticException {

        this.previousBalance = this.currentBalance;
        if (this.currentBalance.compareTo(price) >= 0) {
            this.currentBalance = this.currentBalance.subtract(price).setScale(2, RoundingMode.HALF_UP);
        } else {
            throw new ArithmeticException();
        }
    }

    public String giveChange() {

        int numQuarters = 0;
        int numDimes = 0;
        int numNickels = 0;

        this.previousBalance = this.currentBalance;
        // while (this.currentBalance.compareTo(new BigDecimal(0)) == 1) {

        while (this.currentBalance.compareTo(new BigDecimal("0.25")) >= 0) {
            this.currentBalance = this.currentBalance.subtract(new BigDecimal("0.25")).setScale(2, RoundingMode.HALF_UP);
            numQuarters++;
        }
        while (this.currentBalance.compareTo(new BigDecimal("0.10")) >= 0) {
            this.currentBalance = this.currentBalance.subtract(new BigDecimal("0.10")).setScale(2, RoundingMode.HALF_UP);
            numDimes++;
        }
        while (this.currentBalance.compareTo(new BigDecimal("0.05")) >= 0) {
            this.currentBalance = this.currentBalance.subtract(new BigDecimal("0.05")).setScale(2, RoundingMode.HALF_UP);
            numNickels++;
        }


        // }

        return ("Your change is " + numQuarters + " quarter(s), " + numDimes + " dime(s), and " + numNickels + " nickel(s).");
    }

    public BigDecimal getCurrentBalance() {
        return currentBalance;
    }

    public BigDecimal getPreviousBalance() {
        return previousBalance;
    }
}
