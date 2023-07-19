package view.menu.commands.human;

import view.human.ConsoleUIHuman;
import view.menu.commands.Command;

public class SetGender extends Command
{

    public SetGender(ConsoleUIHuman consoleUIHuman)
    {
        super(consoleUIHuman, "Set gender");
    }

    @Override
    public void execute()
    {
        ((ConsoleUIHuman)view).setGender();
    }
}
