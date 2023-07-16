import model.IModel;
import model.SumModel;
import presenter.Presenter;
import view.CalculatorExt;
import view.View;

public class Main
{
    public static void main(String[] args)
    {
        IModel model = new SumModel();
        View view = new View();
        Presenter presenter = new Presenter(model, view);
        presenter.buttonClick();
    }
}