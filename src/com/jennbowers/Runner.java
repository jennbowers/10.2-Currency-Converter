package com.jennbowers;

import java.util.Scanner;

/**
 * Created by jenniferbowers on 7/26/17.
 */
public class Runner {
    public static void userInterface() {
        Scanner scanner = new Scanner (System.in);

        System.out.println("Hi! Welcome to currency converter! Which currency would you like to convert from: USD? JPY? BTC? EUR?");
        String userInputCurrency = scanner.nextLine();

        System.out.println("And what is the amount of money you would like to convert?");
        Double userInputAmount = scanner.nextDouble();

        System.out.println("Last, what currency would you like to convert to: USD? JPY? BTC? EUR?");
        String userInputDesiredCurrency = scanner.next();

        Money money = new Money(userInputCurrency, userInputAmount);

        money.currencyConverter(userInputDesiredCurrency);

        System.out.println("Would you like to convert more money? YES or NO?");
        String runAgain = scanner.next();

        if(runAgain.equals("YES")) {
            userInterface();
        }

    }
}
