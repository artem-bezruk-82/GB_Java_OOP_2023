package view.commands;

import view.ConsoleUI;

public class SortByName extends Command
{
    public SortByName(ConsoleUI consoleUI)
    {
        super(consoleUI, "Sort students by name");
    }

    @Override
    public void execute()
    {
        consoleUI.sortByName();
    }
}
