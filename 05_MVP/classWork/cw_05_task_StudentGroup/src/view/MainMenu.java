package view;

import view.commands.*;

import java.util.ArrayList;
import java.util.List;

public class MainMenu
{
    private List<Command> commandList;

    public MainMenu(ConsoleUI consoleUI)
    {
        commandList = new ArrayList<>();
        commandList.add(new Finish(consoleUI));
        commandList.add(new AddStudent(consoleUI));
        commandList.add(new GetStudentsInfo(consoleUI));
        commandList.add(new SortByName(consoleUI));
        commandList.add(new SortByAge(consoleUI));
    }

    public void execute(int menuItem)
    {
        commandList.get(menuItem).execute();
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("Main Menu\nChose command:\n");
        for (int i = 0; i < commandList.size(); i++)
            sb.append(String.format("%d - %s\n", i, commandList.get(i).getDescription()));

        return sb.toString();
    }
}
