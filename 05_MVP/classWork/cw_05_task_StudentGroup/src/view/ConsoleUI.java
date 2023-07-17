package view;

import presenter.Presenter;

import java.util.Scanner;

public class ConsoleUI implements IView
{
    private Scanner scanner;
    private Presenter presenter;
    private boolean isWorking;

    public ConsoleUI()
    {
        this.presenter = new Presenter(this);
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
        System.out.println("Hello!");
        MainMenu mainMenu = new MainMenu(this);
        while (isWorking)
        {
            System.out.println(mainMenu);
            int choice = scanner.nextInt();
            mainMenu.execute(choice);
        }
    }

    public void addStudentConsole()
    {
        System.out.println("Please enter name");
        String name = scanner.nextLine();
        System.out.println("Please enter age");
        int age = scanner.nextInt();
        presenter.addStudent(name, age);
    }

    public void getStudentsInfo()
    {
        presenter.getStudentsInfo();
    }

    public void finish()
    {
        System.out.println("Goodbye!");
        isWorking = false;
    }

    public void sortByName()
    {
        presenter.sortByName();
    }

    public void sortByAge()
    {
        presenter.sortByAge();
    }

}
