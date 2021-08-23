package com.techelevator.view;

import java.io.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Log {
    private String filename;
    private File logFile;

    public Log(String filename) {
        this.filename = filename;
        this.logFile = new File(filename);
        if (!logFile.exists()) {
            try {logFile.createNewFile();}
            catch (IOException e) {
                System.out.println("We were unable to create the file.");
                System.exit(1);
            }
        }
    }

    public String getFilename() {
        return filename;
    }

    public File getLogFile() {
        return logFile;
    }

    public void addBalanceLineForPurchase(Snack purchase, Balance currentBalance) {
        try {
            LocalDateTime localDateTime = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm:ss a");
            String name = purchase.getName();
            String slot = purchase.getSlot();
            BigDecimal prevBalance = currentBalance.getPreviousBalance();
            BigDecimal balance = currentBalance.getCurrentBalance();

            FileOutputStream fileOutputStream = new FileOutputStream(this.logFile, true);
            PrintWriter printWriter = new PrintWriter(fileOutputStream);
            printWriter.println(localDateTime.format(formatter) + " " + name + " " + slot + " \\$" + prevBalance + " \\$"  + balance);
            printWriter.flush();
            printWriter.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("Could not find file to write to.");
            System.exit(2);
        }

    }
    public void addBalanceLineFeedFinish(String choice,Balance currentBalance) {
        try {
            LocalDateTime localDateTime = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm:ss a");
            BigDecimal prevBalance = currentBalance.getPreviousBalance();
            BigDecimal balance = currentBalance.getCurrentBalance();

            FileOutputStream fileOutputStream = new FileOutputStream(this.logFile, true);
            PrintWriter printWriter = new PrintWriter(fileOutputStream);
            if (choice.equals("Feed Money")) {
                printWriter.println(localDateTime.format(formatter) + " " + "FEED MONEY: \\$" + prevBalance + " \\$" + balance);
                printWriter.flush();
                printWriter.close();
            }
            if (choice.equals("Finish Transaction")) {
                printWriter.println(localDateTime.format(formatter) + " " + "GIVE CHANGE: \\$" + prevBalance + " \\$" + balance);
                printWriter.flush();
                printWriter.close();
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("Could not find file to write to.");
            System.exit(2);
        }
    }
}
