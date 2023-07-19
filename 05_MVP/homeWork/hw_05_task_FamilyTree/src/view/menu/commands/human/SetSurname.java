package view.menu.commands.human;

import view.human.ConsoleUIHuman;
import view.menu.commands.Command;

public class SetSurname extends Command
{

    public SetSurname(ConsoleUIHuman consoleUIHuman)
    {
        super(consoleUIHuman, "Set Surname");
    }
    @Override
    public void execute()
    {
        ((ConsoleUIHuman)this.view).setSurname();
    }
}
