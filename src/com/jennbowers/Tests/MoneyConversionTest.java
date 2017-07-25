package com.jennbowers.Tests;

import com.jennbowers.Money;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by jenniferbowers on 7/25/17.
 */
public class MoneyConversionTest {
//    @Test
//    public void justTestingForFailure() {
//        assertEquals(1, 2);
//    }

//    ------TESTING CONVERTING TO USD
    @Test
    public void testingYenToDollars() {
        Money newYen = new Money("JPY", 100);
        double result = newYen.yenToDollars();
        assertEquals(0.90, result, 0.01);
    }

    @Test
    public void testingEurosToDollars() {
        Money newEuro = new Money("EUR", 100);
        double result = newEuro.euroToDollars();
        assertEquals(116.58, result, 0.01);

    }

    @Test
    public void testingBitcoinToDollars() {
        Money newBitcoin = new Money("BTC", 100);
        double result = newBitcoin.bitcoinToDollars();
        assertEquals(255069, result, 0.01);
    }

//    ----------TESTING CONVERTING FROM USD TO OTHER CURRENCIES

    Money newDollars = new Money("USD", 100);

    @Test
    public void testingDollarsToYen() {
        double result = newDollars.dollarsToYen();
        assertEquals(11157.47, result, 0.01);
    }

    @Test
    public void testingDollarsToEuros() {
        double result = newDollars.dollarsToEuros();
        assertEquals(85.79, result, 0.01);
    }

    @Test
    public void testingDollarsToBitcoin() {
        double result = newDollars.dollarsToBitcoin();
        assertEquals(0.04, result, 0.01);
    }


}
