package com.jennbowers;

import java.math.RoundingMode;
import java.text.DecimalFormat;

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

    public double getAmount() {
        return amount;
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
        System.out.println("JPY to USD: " + roundedResult(tempSolution));
        return roundedResult(tempSolution);
    }

    //    convert from EUR to USD
    public double euroToDollars() {
        tempSolution = this.getAmount() * 1.16574;
        System.out.println("EUR to USD: " + roundedResult(tempSolution));
        return roundedResult(tempSolution);
    }

    //    convert from BTC to USD
    public double bitcoinToDollars() {
        tempSolution = this.getAmount() * 2550.69;
        System.out.println("BTC to USD: " + roundedResult(tempSolution));
        return roundedResult(tempSolution);
    }

//    -------CONVERTING USD TO EVERYTHING NEXT

//    convert from USD to JPY
    public double dollarsToYen() {
        tempSolution = this.getAmount() / 0.00896261;
        System.out.println("USD to JPY: " + roundedResult(tempSolution));
        return roundedResult(tempSolution);
    }

    //    convert from USD to EUR
    public double dollarsToEuros() {
        tempSolution = this.getAmount() / 1.16574;
        System.out.println("EUR to USD: " + roundedResult(tempSolution));
        return roundedResult(tempSolution);
    }

    //    convert from BTC to USD
    public double dollarsToBitcoin() {
        tempSolution = this.getAmount() / 2550.69;
        System.out.println("BTC to USD: " + roundedResult(tempSolution));
        return roundedResult(tempSolution);
    }

}
