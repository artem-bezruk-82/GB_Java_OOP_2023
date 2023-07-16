package Core.Presenters;

 
import Core.Infrastructure.Generator;
import Core.Models.Model;
import Core.Views.IView;
import Mathematics.Exceptions.UnacceptableValueException;
import Mathematics.Shapes.Circle;
import Mathematics.Shapes.Rectangle;
import Mathematics.Shapes.Shape;

public class Presenter
{
    Model model;
    IView view;

    public Presenter(IView view, Model model)
    {
        this.model = model;
        this.view = view;
    }

    public void append() throws UnacceptableValueException
    {
        view.set("1 - Circle, 2 - Rectangle");
        String response = view.get();
        Shape figure;

        switch (response)
        {
            case "1":
                figure = Circle.create(Generator.number(), "Circle_" + Generator.number());
                break;
            default:
                figure = Rectangle.create(
                    Generator.number(),
                    Generator.number(),
                    "Rectangle_" + Generator.number());
                break;
        }

        model.append(figure);
        view.set("ok");

    }

    public void show() {
        view.set(model.show());
    }

    public void showArea()
        {
            view.set(String.format("all Area %s", model.area()));
        }
}
