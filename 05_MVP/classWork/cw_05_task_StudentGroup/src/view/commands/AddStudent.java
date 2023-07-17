package view.commands;

import view.ConsoleUI;


public class AddStudent extends Command
{

    public AddStudent(ConsoleUI consoleUI)
    {
        super(consoleUI, "Add student");
    }

    @Override
    public void execute()
    {
        this.consoleUI.addStudentConsole();
    }
}
