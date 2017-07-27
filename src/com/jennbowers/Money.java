package com.jennbowers;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Created by jenniferbowers on 7/25/17.
 */
public class Money {
    private String currencySymbol;
    private double amount;
    private double amountInDollars;

    public Money(String currencySymbol, double amount) {
        this.currencySymbol = currencySymbol;
        this.amount = amount;
    }

    public String getCurrencySymbol() {
        return currencySymbol;
    }

    private void setCurrencySymbol(String currencySymbol) {
        this.currencySymbol = currencySymbol;
    }

    public double getAmount() {
        return amount;
    }

    private void setAmount(double amount) {
        this.amount = amount;
    }

    public double getAmountInDollars() {
        return amountInDollars;
    }

    public void setAmountInDollars(double amountInDollars) {
        this.amountInDollars = amountInDollars;
    }

    //    FOR DECIMAL ROUNDING
//    http://www.baeldung.com/java-round-decimal-number

    private double roundedResult (double tempSolution) {
        DecimalFormat roundedConversion = new DecimalFormat("#.##");
        roundedConversion.setRoundingMode(RoundingMode.HALF_UP);
        double result = Double.parseDouble(roundedConversion.format(tempSolution));
        return result;
    }


//    -------CONVERTING EVERYTHING TO USD FIRST

//    convert from JPY to USD
//    public double yenToDollars() {
//        tempSolution = this.getAmount() * 0.00896261;
//        System.out.println("JPY to USD: " + roundedResult(tempSolution));
//        return tempSolution;
//    }

    //    convert from EUR to USD
//    public double euroToDollars() {
//        tempSolution = this.getAmount() * 1.16574;
//        System.out.println("EUR to USD: " + roundedResult(tempSolution));
//        return tempSolution;
//    }

    //    convert from BTC to USD
//    public double bitcoinToDollars() {
//        tempSolution = this.getAmount() * 2550.69;
//        System.out.println("BTC to USD: " + roundedResult(tempSolution));
//        return tempSolution;
//    }

//    -------CONVERTING USD TO EVERYTHING NEXT

//    convert from USD to JPY
//    public double dollarsToYen() {
//        tempSolution = this.getAmountInDollars() / 0.00896261;
//        System.out.println("USD to JPY: " + roundedResult(tempSolution));
//        return tempSolution;
//    }

    //    convert from USD to EUR
//    public double dollarsToEuros() {
//        tempSolution = this.getAmountInDollars() / 1.16574;
//        System.out.println("USD to EUR: " + roundedResult(tempSolution));
//        return tempSolution;
//    }

    //    convert from USD to BTC
//    public double dollarsToBitcoin() {
//        tempSolution = this.getAmountInDollars() / 2550.69;
//        System.out.println("USD to BTC: " + roundedResult(tempSolution));
//        return tempSolution;
//    }

//    ----------- Now let's try a one method to USD converter that can be re-used

    public double toDollarsConverter() {
        double tempSolution;
        String currentCurrency = this.getCurrencySymbol();
        switch(currentCurrency) {
            case "USD":
                this.setAmountInDollars(this.getAmount());
                break;
            case "JPY":
                tempSolution = this.getAmount() * 0.00896261;
                this.setAmountInDollars(tempSolution);
                break;
            case "EUR":
                tempSolution = this.getAmount() * 1.16574;
                this.setAmountInDollars(tempSolution);
                break;
            case "BTC":
                tempSolution = this.getAmount() * 2550.69;
                this.setAmountInDollars(tempSolution);
                break;
        }
        return this.getAmountInDollars();
    }


//    ----------- Let's try a one step converter with user input...
    public double currencyConverter(String desiredCurrency) {
        Double finalResult = 0.0;
        this.toDollarsConverter();
        switch(desiredCurrency){
            case "USD":
                finalResult = this.getAmountInDollars();
                break;
            case "JPY":
                finalResult = this.getAmountInDollars() / 0.00896261;
                break;
            case "EUR":
                finalResult = this.getAmountInDollars() / 1.16574;
                break;
            case "BTC":
                finalResult = this.getAmountInDollars() / 2550.69;
                break;
        }
        System.out.println(roundedResult(finalResult));
        return roundedResult(finalResult);
    }

    public boolean isGreaterThan() {
        System.out.println(this.getAmountInDollars());
        return true;
    }

}


//    implement an `boolean isGreaterThan(Money otherMoney)` instance method on your money class. That way i can have like a money that is 5 EUR and it will be able to compare itself to another money object through the `isGreaterThan` method.
//        so it’d look like this `boolean moreMoney = new Money(5, 'EUR').isGreaterThan(new Money(10, 'USD'))` would set `moreMoney` to false.