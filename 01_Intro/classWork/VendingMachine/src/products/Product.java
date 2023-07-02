package products;

public class Product
{
    private static int counter = 0;
    private int _id;
    private String _name;
    private double _price;

    public Product(String name, double price) throws Exception
    {
        SetId();
        SetName(name);
        SetPrice(price);
    }


    public int GetId() { return _id; }
    public String GetName() { return _name; }
    public double GetPrice() { return _price; }

    public static int GetCounter() { return counter; }

    public void SetId()
    {
        counter++;
        _id = counter;
    }

    public void SetName(String name) { _name = name; }

    public void SetPrice(double price) throws Exception
    {
        if (price >= 0)
            _price = price;
        else
            throw new Exception("Price less than zero");
    }



    @Override
    public String toString()
    {
        return String.format("id: %d; name: %s; price: %f", _id, _name, _price);
    }


}
