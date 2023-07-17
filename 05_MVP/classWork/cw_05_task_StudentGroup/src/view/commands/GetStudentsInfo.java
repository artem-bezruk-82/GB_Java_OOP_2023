package view.commands;

import view.ConsoleUI;

public class GetStudentsInfo extends Command
{
    public GetStudentsInfo(ConsoleUI consoleUI)
    {
        super(consoleUI, "Get Students Info");
    }

    @Override
    public void execute()
    {
        this.consoleUI.getStudentsInfo();
    }
}
