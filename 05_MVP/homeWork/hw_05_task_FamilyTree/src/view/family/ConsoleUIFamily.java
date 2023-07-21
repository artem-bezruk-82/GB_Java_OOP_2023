package view.family;

import presenter.PresenterFamily;
import view.IView;
import view.human.ConsoleUIHuman;
import view.menu.Menu;
import view.menu.commands.family.AddMember;
import view.menu.commands.family.Exit;
import view.menu.commands.family.GetInfo;
import view.menu.commands.family.RemoveMember;

import java.util.Scanner;

public class ConsoleUIFamily implements IView
{
    private Scanner scanner;
    private PresenterFamily presenter;
    private boolean isWorking;

    public ConsoleUIFamily(String filePath)
    {
        this.presenter = new PresenterFamily(this, filePath);
        this.scanner = new Scanner(System.in);
        isWorking = true;
    }

    @Override
    public void print(String text)
    {
        System.out.println(text);
    }

    @Override
    public void start()
    {
        Menu menu = new Menu("Family menu\n");
        menu.add(new Exit(this));
        menu.add(new AddMember(this));
        menu.add(new GetInfo(this));
        menu.add(new RemoveMember(this));

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
        isWorking = false;
    }

    public void addMember()
    {
        try
        {
            ConsoleUIHuman consoleUIHuman = new ConsoleUIHuman();
            consoleUIHuman.start();
            presenter.addMember(consoleUIHuman.getPresenter().getHuman());
        }
        catch (Exception exception)
        {
            print(exception.getMessage());
        }
    }

    public void removeMember()
    {
        getInfo();
        int index = GetConsoleInputInt("Please enter index of member you would like to remove", 0, presenter.getSize() -1);
        presenter.removeMember(index);
    }


    public void getInfo()
    {
        presenter.getInfo();
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
