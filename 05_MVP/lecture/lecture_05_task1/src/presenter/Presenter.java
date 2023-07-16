package presenter;

import model.IModel;
import view.View;

public class Presenter
{
    View view;
    IModel model;

    public Presenter(IModel model, View view)
    {
        this.model = model;
        this.view = view;
    }

    public void buttonClick()
    {
        int firstValue = view.GetConsoleInputInt("Please enter first value");
        int secondValue = view.GetConsoleInputInt("Please enter second value");
        model.setValueA(firstValue);
        model.setValueB(secondValue);
        int result = model.getResult();
        view.print(result, model.toString() + " =");
    }
}
