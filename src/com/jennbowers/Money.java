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

    //    FOR DECIMAL ROUNDING
//    http://www.baeldung.com/java-round-decimal-number
    private double tempSolution;

    private double roundedResult (double tempSolution) {
        DecimalFormat roundedConversion = new DecimalFormat("#.##");
        roundedConversion.setRoundingMode(RoundingMode.CEILING);
        double result = Double.parseDouble(roundedConversion.format(tempSolution));
        return result;
    }


//    -------CONVERTING EVERYTHING TO USD FIRST

//    convert from JPY to USD
    public double yenToDollars() {
        tempSolution = this.getAmount() * 0.00896261;
//        System.out.println("JPY to USD: " + roundedResult(tempSolution));
        return roundedResult(tempSolution);
    }

    //    convert from EUR to USD
    public double euroToDollars() {
        tempSolution = this.getAmount() * 1.16574;
//        System.out.println("EUR to USD: " + roundedResult(tempSolution));
        return roundedResult(tempSolution);
    }

    //    convert from BTC to USD
    public double bitcoinToDollars() {
        tempSolution = this.getAmount() * 2550.69;
//        System.out.println("BTC to USD: " + roundedResult(tempSolution));
        return roundedResult(tempSolution);
    }

//    -------CONVERTING USD TO EVERYTHING NEXT

//    convert from USD to JPY
    public double dollarsToYen() {
        tempSolution = this.getAmount() / 0.00896261;
//        System.out.println("USD to JPY: " + roundedResult(tempSolution));
        return roundedResult(tempSolution);
    }

    //    convert from USD to EUR
    public double dollarsToEuros() {
        tempSolution = this.getAmount() / 1.16574;
//        System.out.println("EUR to USD: " + roundedResult(tempSolution));
        return roundedResult(tempSolution);
    }

    //    convert from BTC to USD
    public double dollarsToBitcoin() {
        tempSolution = this.getAmount() / 2550.69;
//        System.out.println("BTC to USD: " + roundedResult(tempSolution));
        return roundedResult(tempSolution);
    }





//    ----------- Let's try a one step converter with user input...
    public double currencyConverter(String desiredCurrency) {
        String currentCurrency = this.getCurrencySymbol();
        Double finalResult = 0.0;
        switch(currentCurrency) {
            case "USD":
                break;
            case "JPY":
                 this.setAmount(yenToDollars());
                break;
            case "EUR":
                this.setAmount(euroToDollars());
                break;
            case "BTC":
                this.setAmount(bitcoinToDollars());
                break;
        }
        switch(desiredCurrency){
            case "USD":
                break;
            case "JPY":
                finalResult = dollarsToYen();
                break;
            case "EUR":
                finalResult = dollarsToEuros();
                break;
            case "BTC":
                finalResult = dollarsToBitcoin();
                break;
        }
        return finalResult;
    }

}
