package com.techelevator;

import com.techelevator.view.*;

import javax.print.DocFlavor;
import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class VendingMachineCLI {


    private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
    private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
    private static final String MAIN_MENU_OPTION_EXIT = "Exit";
    private static final String[] MAIN_MENU_OPTIONS = {MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE, MAIN_MENU_OPTION_EXIT};

    private static final String SUB_MENU_OPTION_FEED_MONEY = "Feed Money";
    private static final String SUB_MENU_OPTION_SELECT_PRODUCT = "Select Product";
    private static final String SUB_MENU_OPTION_FINISH_TRANSACTION = "Finish Transaction";
    private static final String[] SUB_MENU_OPTIONS = {SUB_MENU_OPTION_FEED_MONEY, SUB_MENU_OPTION_SELECT_PRODUCT, SUB_MENU_OPTION_FINISH_TRANSACTION};

    private Menu menu;
    private List<Snack> snacks = new ArrayList<>();
    private VendingMachine vendingMachine;

    public VendingMachineCLI(Menu menu) { //gets called when main creates a new CLI object
        this.loadSnackList();
        this.vendingMachine = new VendingMachine(snacks);
        this.menu = menu;
    }

    public void run() {
        while (true) {
            String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

            if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
                vendingMachine.displayMachineItems();
            } else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
                this.showSubMenu();
            } else if (choice.equals(MAIN_MENU_OPTION_EXIT)) {
                return;
            }
        }
    }

    public void showSubMenu() {
        while (true) {
            System.out.println("\n\nCurrent Money Provided:  \\$" + vendingMachine.getBalance().getCurrentBalance());
            String choice = (String) menu.getChoiceFromOptions(SUB_MENU_OPTIONS);

            if (choice.equals(SUB_MENU_OPTION_FEED_MONEY)) {
                System.out.print("Please insert bills: ");
                Scanner scanner = new Scanner(System.in);
                String fedBills = scanner.nextLine();
                BigDecimal billsFed = new BigDecimal(fedBills);
                try { //throw any amounts that arent whole numbers
                    vendingMachine.feedMoney(billsFed);
                    System.out.println("\n\nCurrent Money Provided:  \\$" + vendingMachine.getBalance().getCurrentBalance());
                } catch (ArithmeticException e) {
                    System.out.println("Not a whole number of bills.");
                }
            } else if (choice.equals(SUB_MENU_OPTION_SELECT_PRODUCT)) {
               vendingMachine.selectProduct();
            } else if (choice.equals(SUB_MENU_OPTION_FINISH_TRANSACTION)) {
                vendingMachine.finishTransaction();
                return;
            }
        }

    }

    public static void main(String[] args) { //runs first
        Menu menu = new Menu(System.in, System.out);
        VendingMachineCLI cli = new VendingMachineCLI(menu);
        cli.run(); //loops until user ends
    }

    public void loadSnackList() {

        File snackFile = new File("vendingmachine.csv"); //creates a file object that holds vendingmachine.csv

        if (snackFile.exists() == true) {

            try {
                Scanner scanner = new Scanner(snackFile); //create a scanner to scan the file

                while (scanner.hasNextLine()) { //as long as we have another line continue to scan

                    String line = scanner.nextLine(); //place the line we just read into memory

                    String[] snackArr = line.split("\\|"); //takes the lines and splits into dif strings

                    String slot = snackArr[0];
                    String snackName = snackArr[1];
                    BigDecimal priceOfSnack = new BigDecimal(snackArr[2]);
                    String type = snackArr[3];

                    if (type.equals("Chip")) {
                        Chips chip = new Chips(slot, snackName, priceOfSnack, type); //creates a new chip object called chip
                        snacks.add(chip);
                    } else if (type.equals("Candy")) {
                        Candy candy = new Candy(slot, snackName, priceOfSnack, type);
                        snacks.add(candy);
                    } else if (type.equals("Drink")) {
                        Drinks drink = new Drinks(slot, snackName, priceOfSnack, type);
                        snacks.add(drink);
                    } else if (type.equals("Gum")) {
                        Gum gum = new Gum(slot, snackName, priceOfSnack, type);
                        snacks.add(gum);
                    }
                }

            } catch (FileNotFoundException e) {
                System.out.println("Could not open file");
                System.exit(1);
            }
        }
    }
}
