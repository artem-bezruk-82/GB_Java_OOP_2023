package view.human;


import model.Human.Human;
import presenter.PresenterHuman;
import view.IView;
import view.menu.Menu;
import view.menu.commands.human.*;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

public class ConsoleUIHuman implements IView
{

    private Scanner scanner;
    private PresenterHuman presenter;
    private boolean isWorking;

    public ConsoleUIHuman() throws Exception {
        this.presenter = new PresenterHuman(this);
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
        menu.add(new Exit(this));
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

    public void end()
    {
        this.isWorking = false;
    }

    public void setName()
    {
        System.out.println("Please enter name");
        presenter.setName(scanner.nextLine());
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
        System.out.println("Please chose gender:");
        Human.GenderEnum[] genders = Human.GenderEnum.values();

        for (int i = 1; i < genders.length; i++)
            System.out.println(String.format("%d - %s", i, genders[i]));

        int genderIndex = 1;
        presenter.setGender(genders[genderIndex]);
    }
}
