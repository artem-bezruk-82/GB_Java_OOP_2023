package view.menu.commands.human;

import view.human.ConsoleUIHuman;
import view.menu.commands.Command;

public class SetDeathDate extends Command
{
    public SetDeathDate(ConsoleUIHuman consoleUIHuman)
    {
        super(consoleUIHuman, "Set death date");
    }
    @Override
    public void execute()
    {
        ((ConsoleUIHuman)this.view).setDeathDate();
    }
}
