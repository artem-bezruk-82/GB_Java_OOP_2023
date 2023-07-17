package view.commands;

import view.ConsoleUI;

public class SortByAge extends Command
{
    public SortByAge(ConsoleUI consoleUI)
    {
        super(consoleUI, "Sort students by age");
    }

    @Override
    public void execute()
    {
        consoleUI.sortByAge();
    }
}