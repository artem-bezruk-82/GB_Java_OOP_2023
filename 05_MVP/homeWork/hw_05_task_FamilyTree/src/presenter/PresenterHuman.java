package presenter;

import model.Human.Human;
import view.IView;

import java.time.LocalDate;


public class PresenterHuman
{
    private Human human;
    private IView view;

    public PresenterHuman(IView view) throws Exception
    {
        this.view = view;
        human = new Human();
    }

    public Human getHuman() { return human; }

    public void setName(String name)
    {
        human.setName(name);
        view.print(human.toString());
    }

    public void setSurname(String surname)
    {
        human.setSurname(surname);
        view.print(human.toString());
    }

    public void setBirthDate(LocalDate date)
    {
        try
        {
            human.setBirthDate(date);
            view.print(human.toString());
        }
        catch (Exception exception)
        {
            view.print(exception.getMessage());
        }

    }

    public void setDeathDate(LocalDate date)
    {
        try
        {
            human.setDeathDate(date);
            view.print(human.toString());
        }
        catch (Exception exception)
        {
            view.print(exception.getMessage());
        }
    }

    public void setGender(Human.GenderEnum gender)
    {
        try
        {
            human.setGender(gender);
            view.print(human.getGender().toString());
        }
        catch (Exception exception)
        {
            view.print(exception.getMessage());
        }

    }
}
