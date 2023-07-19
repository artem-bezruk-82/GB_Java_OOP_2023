package view.menu.commands;

import view.IView;
import view.family.ConsoleUIFamily;

public abstract class Command
{
    protected IView view;
    protected String description;

    public Command(IView view, String description)
    {
        this.view = view;
        this.description = description;
    }

    public String getDescription() { return description; }

    public abstract void execute();
}
