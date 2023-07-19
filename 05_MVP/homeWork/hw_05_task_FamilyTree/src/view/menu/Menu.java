package view.menu;

import view.menu.commands.Command;

import java.util.ArrayList;
import java.util.List;

public class Menu
{
    private List<Command> commands;
    private String title;

    public Menu(String title, List<Command> commands)
    {
        this.title = title;
        this.commands = commands;
    }

    public Menu(String title)
    {
        this(title, new ArrayList<>());
    }

    public boolean add(Command command)
    {
        if (!this.commands.contains(command))
        {
            this.commands.add(command);
            return true;
        }
        return false;
    }

    public void execute(int menuItem)
    {
        commands.get(menuItem).execute();
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append(title);
        for (int i = 0; i < commands.size(); i++) {
            sb.append(String.format("%d - %s\n", i, commands.get(i).getDescription()));
        }
        return sb.toString();
    }
}
