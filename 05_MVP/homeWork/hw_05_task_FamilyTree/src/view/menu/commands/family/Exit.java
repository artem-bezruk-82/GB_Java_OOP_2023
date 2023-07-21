package view.menu.commands.family;

import view.family.ConsoleUIFamily;
import view.human.ConsoleUIHuman;
import view.menu.commands.Command;

public class Exit extends Command
{
    public Exit(ConsoleUIFamily consoleUIFamily)
    {
        super(consoleUIFamily, "Exit");
    }
    @Override
    public void execute()
    {
        view.end();
    }
}
