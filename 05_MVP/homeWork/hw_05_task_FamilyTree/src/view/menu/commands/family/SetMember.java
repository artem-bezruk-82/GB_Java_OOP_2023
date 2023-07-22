package view.menu.commands.family;

import view.family.ConsoleUIFamily;
import view.menu.commands.Command;

public class SetMember extends Command
{
    public SetMember(ConsoleUIFamily consoleUI)
    {
        super(consoleUI, "Set family member");
    }

    @Override
    public void execute()
    {
        ((ConsoleUIFamily)this.view).SetMember();
    }
}
