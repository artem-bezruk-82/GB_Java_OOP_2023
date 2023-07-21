package view.menu.commands.human;

import view.human.ConsoleUIHuman;
import view.menu.commands.Command;

public class Apply extends Command
{

    public Apply(ConsoleUIHuman consoleUIHuman)
    {
        super(consoleUIHuman, "Exit");
    }

    @Override
    public void execute()
    {
        ((ConsoleUIHuman)this.view).end();
    }
}
