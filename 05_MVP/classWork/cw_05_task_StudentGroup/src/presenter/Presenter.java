package presenter;

import model.Service;
import view.IView;


public class Presenter
{
    private IView view;
    private Service service;

    public Presenter(IView view)
    {
        this.view = view;
        service = new Service();
    }


    public void getStudentsInfo()
    {
        String info = service.GetStudentsInfo();
        view.print(info);
    }

    public void addStudent(String name, int age)
    {
        if (service.AddStudent(name, age))
            view.print("Student has been successfully added");
        else
            view.print("Student has not bee added");
    }

    public void sortByAge()
    {
       service.SortByAge();
       getStudentsInfo();
    }

    public void sortByName()
    {
        service.SortByName();
        getStudentsInfo();
    }
}
