package com.jennbowers;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        System.out.println("Hi! Welcome to currency converter! Which currency would you like to convert from: USD? JPY? BTC? EUR?");
        String userInputCurrency = scanner.nextLine();

        System.out.println("And what is the amount of money you would like to convert?");
        String userInputAmountString = scanner.nextLine();
        Double userInputAmount = Double.parseDouble(userInputAmountString);

        System.out.println("Last, what currency would you like to convert to: USD? JPY? BTC? EUR?");
        String userInputDesiredCurrency = scanner.nextLine();

        Money money = new Money(userInputCurrency, userInputAmount);

        money.currencyConverter(userInputDesiredCurrency);
    }
}
