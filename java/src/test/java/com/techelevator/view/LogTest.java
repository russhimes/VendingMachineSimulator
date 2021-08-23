package com.techelevator.view;

import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.Scanner;

import static org.junit.Assert.*;

public class LogTest {

    @Test
    public void test_log_constructor() {
        Log testLog = new Log("test.txt");
        boolean expectedValue = true;
        File testFile = testLog.getLogFile();
        boolean actualValue = (testFile.exists());

        assertEquals(expectedValue, actualValue);

        Log testLogFileExists = new Log("test.txt");
        File testFileExists = testLog.getLogFile();
        boolean actualFileExists = (testFileExists.exists());

        assertEquals(expectedValue, actualFileExists);

        testFile.delete();
    }

    @Test
    public void test_get_file_name() {
        Log testFileNameTest = new Log("test2.txt");
        String expectedFileName = "test2.txt";
        String actualFileName = (testFileNameTest.getFilename());

        assertEquals(expectedFileName, actualFileName);

        testFileNameTest.getLogFile().delete();
    }

    @Test
    public void test_feed_finish() {
        Log feedFinishTest = new Log("testFeed.txt");
        Balance feedTest = new Balance();
        BigDecimal testAmount = new BigDecimal("10.00");
        feedTest.feedMoney(testAmount);
        feedFinishTest.addBalanceLineFeedFinish("Feed Money", feedTest);


        String logLine = "";
        String changeLine = "";
        String logLineExpectedResult = "FEED MONEY: \\$0.00 \\$10.00";

        feedTest.giveChange();
        feedFinishTest.addBalanceLineFeedFinish("Finish Transaction", feedTest);
        String changeLineExpectedResult = "GIVE CHANGE: \\$10.00 \\$0.00";

        try {
            Scanner logScanner = new Scanner(feedFinishTest.getLogFile());
            if (logScanner.hasNextLine()) {
                logLine = logScanner.nextLine().substring(23);
                changeLine = logScanner.nextLine().substring(23);
                logScanner.close();
            }
        } catch (FileNotFoundException e) {
            System.out.println("Scanner could not be created");
        }
        String logLineActualResult = logLine;
        String changeLineActualResult = changeLine;

        assertEquals(logLineExpectedResult, logLineActualResult);

        assertEquals(changeLineExpectedResult, changeLineActualResult);

        feedFinishTest.getLogFile().delete();
    }

    @Test
    public void test_purchase() {
        Log testPurchase = new Log("testPurchase.txt");
        Balance testBalance = new Balance();

        BigDecimal feedAmount = new BigDecimal ("5.00");
        testBalance.feedMoney(feedAmount);

        Snack testSnack = new Candy("A1", "moonpie", new BigDecimal("1.50"), "candy");
        testBalance.purchase(new BigDecimal("1.50"));

        String expectedPurchaseResult = "moonpie A1 \\$5.00 \\$3.50";

        testPurchase.addBalanceLineForPurchase(testSnack, testBalance);
        String logLine = "";
        try {
            Scanner logScanner = new Scanner(testPurchase.getLogFile());
            if (logScanner.hasNextLine()) {
                logLine = logScanner.nextLine().substring(23);
                logScanner.close();
            }
        } catch (FileNotFoundException e) {
            System.out.println("Scanner could not be created");
        }

        String actualPurchaseResult = logLine;

        assertEquals(expectedPurchaseResult, actualPurchaseResult);

        testPurchase.getLogFile().delete();

    }
}