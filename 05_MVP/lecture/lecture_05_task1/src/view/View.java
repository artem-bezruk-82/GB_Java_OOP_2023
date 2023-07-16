package view;

import java.util.Scanner;

public class View
{
    public void print(int data, String title)
    {
        System.out.printf("%s %d\n", title, data);
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
