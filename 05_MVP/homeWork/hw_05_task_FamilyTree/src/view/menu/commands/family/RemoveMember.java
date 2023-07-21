package view.menu.commands.family;

import view.family.ConsoleUIFamily;
import view.menu.commands.Command;

public class RemoveMember extends Command
{
    public RemoveMember(ConsoleUIFamily consoleUI)
    {
        super(consoleUI, "Remove member");
    }

    @Override
    public void execute()
    {
        ((ConsoleUIFamily)this.view).removeMember();
    }
}
