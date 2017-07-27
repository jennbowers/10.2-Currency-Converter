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

//    ---------- FOR DECIMAL ROUNDING
//    http://www.baeldung.com/java-round-decimal-number

    private double roundedResult (double tempSolution) {
        DecimalFormat roundedConversion = new DecimalFormat("#.##");
        roundedConversion.setRoundingMode(RoundingMode.HALF_UP);
        double result = Double.parseDouble(roundedConversion.format(tempSolution));
        return result;
    }

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


//    ----------- Let's try a one method converter with user input...
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

//    ------------ HARDER MODE—comparing currencies

    public boolean isGreaterThan(String currency, double amount) {
        double firstMoney = this.toDollarsConverter();
        Money otherMoney = new Money(currency, amount);
        double secondMoney = otherMoney.toDollarsConverter();
        if (firstMoney > secondMoney){
            return true;
        } else {
            return false;
        }
    }

    public boolean isLessThan(String currency, double amount) {
        double firstMoney = this.toDollarsConverter();
        Money otherMoney = new Money(currency, amount);
        double secondMoney = otherMoney.toDollarsConverter();
        if (firstMoney < secondMoney){
            return true;
        } else {
            return false;
        }
    }

}
