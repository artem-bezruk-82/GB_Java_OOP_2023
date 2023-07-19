package view.menu.commands.human;

import view.human.ConsoleUIHuman;
import view.menu.commands.Command;

public class Exit extends Command
{

    public Exit(ConsoleUIHuman consoleUIHuman)
    {
        super(consoleUIHuman, "Exit");
    }

    @Override
    public void execute()
    {
        ((ConsoleUIHuman)this.view).end();
    }
}
