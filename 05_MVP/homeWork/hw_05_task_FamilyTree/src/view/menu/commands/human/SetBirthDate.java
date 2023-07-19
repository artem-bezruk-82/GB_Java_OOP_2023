package view.menu.commands.human;

import view.human.ConsoleUIHuman;
import view.menu.commands.Command;

public class SetBirthDate extends Command
{
    public SetBirthDate(ConsoleUIHuman consoleUIHuman)
    {
        super(consoleUIHuman, "Set Birthday Date");
    }
    @Override
    public void execute()
    {
        ((ConsoleUIHuman)this.view).setBirthDate();
    }
}
