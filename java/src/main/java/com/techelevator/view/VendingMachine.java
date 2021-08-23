package com.techelevator.view;

import java.math.BigDecimal;
import java.util.*;

public class VendingMachine {

    private List<Snack> listOfSnacks;
    private Balance balance = new Balance();
    private Log auditReport = new Log("Log.txt");

    //Constructor
    public VendingMachine(List<Snack> listOfSnacks) {
        this.listOfSnacks = listOfSnacks; //takes snacks from vendingmachineCLI to vending machine
    }

    public void displayMachineItems() { //loops through list of snacks and displays info
        for (Snack current : listOfSnacks) {
            String slot = current.getSlot();
            String name = current.getName();
            BigDecimal price = current.getPrice();
            int numAvailable = current.getNumAvailable();
            System.out.println(slot + " " + name + ": $" + price + "| " + numAvailable + " available");
        }
        System.out.println("\n\nCurrent Money Provided: \\$" + balance.getCurrentBalance());
    }

    public void feedMoney(BigDecimal amountToFeed) throws ArithmeticException {
        try {this.balance.feedMoney(amountToFeed);}
        catch (ArithmeticException e) {
            throw new ArithmeticException();
        }
        this.auditReport.addBalanceLineFeedFinish("Feed Money", this.balance);
    }

    public void selectProduct() {

        Map<String, Snack> slotMap = new HashMap<>(); //creates a map to hold list of snacks
        for (Snack current : this.listOfSnacks) {  // current is the current snack
            slotMap.put(current.getSlot(), current); //keys are slot #s
        }

        this.displayMachineItems(); //displays available snacks

        Scanner inputScanner = new Scanner(System.in); //creates scanner to get users input
        System.out.print("\nMake a selection using the slot letter and number (e.g. A1): "); //prints prompt
        String userSelection = inputScanner.nextLine().toUpperCase(); //saves users selection as a string

        Snack choice = null;
        if (slotMap.containsKey(userSelection)) {
            choice = slotMap.get(userSelection);
        }
        else {
            System.out.println("Not a valid selection.");
            return;
        }
        if (choice.getNumAvailable() <= 0) {
            System.out.println("Product is sold out.");
            return;
        }
        BigDecimal price = choice.getPrice();
        try {
            this.balance.purchase(price);
            choice.decrementSnack();
            System.out.println(choice.getDisplayMessage());
            System.out.println(choice.getName() + " $" + choice.getPrice() + " ");
            System.out.println("Funds Remaining:  \\$" + this.balance.getCurrentBalance());
            this.auditReport.addBalanceLineForPurchase(choice, this.balance);
        }
        catch (ArithmeticException e) {
            System.out.println("Insufficient Funds.");
            return;
        }

    }

    public void finishTransaction() {
        String change = this.balance.giveChange();
        this.auditReport.addBalanceLineFeedFinish("Finish Transaction", this.balance);
        System.out.println(change);
    }

    public List<Snack> getListOfSnacks() {
        return listOfSnacks;
    }

    public Balance getBalance() {
        return balance;
    }

    public Log getAuditReport() {
        return auditReport;
    }
}
