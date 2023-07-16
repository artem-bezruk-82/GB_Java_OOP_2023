package view;

import model.Calculator;

import java.util.Scanner;

public class CalculatorExt
{
    public static void getSumConsole()
    {
        int firstValue = GetConsoleInputInt("Please enter first value");
        int secondValue = GetConsoleInputInt("Please enter second value");
        int result = Calculator.sum(firstValue, secondValue);
        System.out.printf("%d + %d = %d", firstValue, secondValue, result);
    }

    public static int GetConsoleInputInt(String requestText)
    {
        return GetConsoleInputInt(requestText, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public static int GetConsoleInputInt(String requestText, int startRange, int endRange)
    {
        Scanner consoleInput = new Scanner(System.in);
        int value;
        do
        {
            System.out.println(requestText);
            while (!consoleInput.hasNextInt())
            {
                System.out.printf("Entered value is not integer type. %s\n", requestText);
                consoleInput.next();
            }
            value = consoleInput.nextInt();
            if (value < startRange || value > endRange)
            {
                System.out.printf("Entered value is out of %d...%d range. %s\n", startRange, endRange, requestText);
            }
        } while (value < startRange || value > endRange);
        return value;
    }
}
