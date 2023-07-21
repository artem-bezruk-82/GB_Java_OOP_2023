package presenter;

import model.Human.Human;
import model.Model;
import view.IView;

public class PresenterFamily
{
    private Model model;
    private IView view;

    public PresenterFamily(IView view, String filePath)
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

}
