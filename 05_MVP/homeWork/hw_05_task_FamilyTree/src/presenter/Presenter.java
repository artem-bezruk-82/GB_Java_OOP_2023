package presenter;

import model.Human.Human;
import model.Model;
import view.IView;

import java.time.LocalDate;

public class Presenter
{
    private Model model;
    private IView view;

    public Presenter(IView view, String filePath)
    {
        this.view = view;
        this.model = new Model(filePath);
    }

    public void addMember(Human human)
    {
        try
        {
            if (model.getFamily().addFamilyMember(human))
            {
                view.print("Member successfully added");
                model.save();
            }
            else
                view.print("This member already exist");
        }
        catch (Exception exception)
        {
            view.print(exception.getMessage());
        }
    }

    public void removeMember(int index)
    {
        model.getFamily().removeFamilyMember(index);
        model.save();
    }

    public void getInfo()
    {
        view.print(model.getFamily().toString());
    }

    public int getSize()
    {
        return model.getFamily().getSize();
    }

    public void selectMember(int index)
    {
        model.setCurrentMemberIndex(index);
        view.print(model.getCurrentMember().toString());
    }

    // from human presentter
    public void setMemberName(String name)
    {
        model.getCurrentMember().setName(name);
        model.save();
    }

    public void setSurname(String surname)
    {
        model.getCurrentMember().setSurname(surname);
        view.print(model.getCurrentMember().toString());
        model.save();
    }

    public void setBirthDate(LocalDate date)
    {
        try
        {
            model.getCurrentMember().setBirthDate(date);
            view.print(model.getCurrentMember().toString());
            model.save();
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
            model.getCurrentMember().setDeathDate(date);
            view.print(model.getCurrentMember().toString());
            model.save();
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
            model.getCurrentMember().setGender(gender);
            view.print(model.getCurrentMember().getGender().toString());
            model.save();
        }
        catch (Exception exception)
        {
            view.print(exception.getMessage());
        }
    }

}
