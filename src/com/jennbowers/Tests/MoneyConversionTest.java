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
        double result = newYen.toDollarsConverter();
        assertEquals(0.90, result, 0.01);
    }

    @Test
    public void testingEurosToDollars() {
        Money newEuro = new Money("EUR", 100);
        double result = newEuro.toDollarsConverter();
        assertEquals(116.58, result, 0.01);

    }

    @Test
    public void testingBitcoinToDollars() {
        Money newBitcoin = new Money("BTC", 100);
        double result = newBitcoin.toDollarsConverter();
        assertEquals(255069, result, 0.01);
    }



//    ----------TESTING CONVERTING FROM USD TO OTHER CURRENCIES

    Money newDollars = new Money("USD", 100);

    @Test
    public void testingDollarsToYen() {
        double result = newDollars.currencyConverter("JPY");
        assertEquals(11157.46, result, 0.01);
    }

    @Test
    public void testingDollarsToEuros() {
        double result = newDollars.currencyConverter("EUR");
        assertEquals(85.78, result, 0.01);
    }

    @Test
    public void testingDollarsToBitcoin() {
        double result = newDollars.currencyConverter("BTC");
        assertEquals(0.04, result, 0.01);
    }

//    ---------TESTING ISGREATERTHAN boolean
    @Test
    public void testingIsGreaterThan() {
        Money testMoney = new Money("EUR", 5);
        boolean result = testMoney.isGreaterThan();
        assertEquals(true, result);
    }


}
