package presenter;

import view.IView;

public class Presenter
{
    protected IView view;

    public Presenter(IView view)
    {
        this.view = view;
    }

}
