package view.menu.commands.family;

import view.family.ConsoleUIFamily;
import view.menu.commands.Command;

public class GetInfo extends Command
{
    public GetInfo(ConsoleUIFamily consoleUI)
    {
        super(consoleUI, "Get information");
    }

    @Override
    public void execute()
    {
        ((ConsoleUIFamily)this.view).getInfo();
    }
}
