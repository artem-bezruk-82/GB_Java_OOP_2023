

public class Main
{
    public static void main(String[] args)
    {
        Service service = new Service();
        service.AddStudent("Pasha", 18);
        service.AddStudent("Masha", 20);
        service.AddStudent("Sasha", 17);
        service.AddStudent("Dasha", 19);

        System.out.println(service);
        System.out.println(service.GetStudentsInfo());

        service.SortByName();
        System.out.println("Sorted by Name:");
        System.out.println(service);

        service.SortByAge();
        System.out.println("Sorted by Age");
        System.out.println(service);
    }
}