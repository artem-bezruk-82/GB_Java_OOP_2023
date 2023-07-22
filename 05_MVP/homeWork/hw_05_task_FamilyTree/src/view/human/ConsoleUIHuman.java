package view.human;


import model.Human.Human;
import presenter.Presenter;
import view.IView;
import view.menu.Menu;
import view.menu.commands.human.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ConsoleUIHuman implements IView
{

    private Scanner scanner;
    //private PresenterHuman presenter;
    private Presenter presenter;
    private boolean isWorking;

    public ConsoleUIHuman(Presenter presenter) throws Exception
    {
        this.presenter = presenter;
        this.scanner = new Scanner(System.in);
        isWorking = true;
    }

    @Override
    public void print(String text) {
        System.out.println(text);
    }

    @Override
    public void start() {

        Menu menu = new Menu("Human menu\n");
        menu.add(new Apply(this));
        menu.add(new SetName(this));
        menu.add(new SetSurname(this));
        menu.add(new SetBirthDate(this));
        menu.add(new SetDeathDate(this));
        menu.add(new SetGender(this));
        while (isWorking)
        {
            System.out.println(menu);
            int menuItemIndex = scanner.nextInt();
            scanner.nextLine();
            menu.execute(menuItemIndex);
        }
    }

    @Override
    public void end()
    {
        this.isWorking = false;
    }

    public void setName()
    {
        System.out.println("Please enter name");
        presenter.setMemberName(scanner.nextLine());
    }

    public void setSurname()
    {
        System.out.println("Please enter surname");
        presenter.setSurname(scanner.nextLine());
    }



    private LocalDate GetDateConsole()
    {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println("Please enter date in dd/MM/yyyy format");
        String dateStr = scanner.nextLine();
        LocalDate date = null;
        try
        {
            date = LocalDate.parse(dateStr, formatter);
        }
        catch (Exception exc)
        {
            exc.printStackTrace();
        }
        return date;
    }

    public void setBirthDate()
    {
        LocalDate date = GetDateConsole();
        presenter.setBirthDate(date);
    }

    public void setDeathDate()
    {
        LocalDate date = GetDateConsole();
        presenter.setDeathDate(date);
    }

    public void setGender()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("Please chose gender:\n");

        Human.GenderEnum[] genders = Human.GenderEnum.values();

        for (int i = 0; i < genders.length; i++)
            sb.append(String.format("%d - %s\n", i, genders[i]));

        int genderIndex = GetConsoleInputInt(sb.toString(), 0, genders.length);
        presenter.setGender(genders[genderIndex]);
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
