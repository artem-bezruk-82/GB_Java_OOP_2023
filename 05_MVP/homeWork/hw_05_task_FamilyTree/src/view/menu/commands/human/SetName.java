package view.menu.commands.human;

import view.human.ConsoleUIHuman;
import view.menu.commands.Command;

public class SetName extends Command
{
    public SetName(ConsoleUIHuman consoleUIHuman)
    {
        super(consoleUIHuman, "Set name");
    }
    @Override
    public void execute()
    {
        ((ConsoleUIHuman)this.view).setName();
    }
}
