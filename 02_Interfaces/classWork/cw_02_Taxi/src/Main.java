
public class Main
{
    public static void main(String[] args)
    {
        Person person = new Person();
        person.CallTaxi(new Friend());
        person.CallTaxi(new Yandex());
        person.CallTaxi(new Uber());

    }
}