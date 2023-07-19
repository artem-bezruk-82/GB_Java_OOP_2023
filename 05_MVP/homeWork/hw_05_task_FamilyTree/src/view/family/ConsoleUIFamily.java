package view.family;

import presenter.Presenter;
import view.IView;

public class ConsoleUIFamily implements IView
{
    private Presenter presenter;

    @Override
    public void print(String text)
    {
        System.out.println(text);
    }

    @Override
    public void start()
    {



    }

    public void addMember()
    {
        //presenter.addMember();
    }
}
