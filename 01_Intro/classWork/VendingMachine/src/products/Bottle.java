package products;

public class Bottle extends Product
{
    private double _volume;
    public Bottle(String name, double price, double volume) throws Exception
    {
        super(name, price);
        _volume = volume;
    }

    public double GetVolume() { return _volume; }

    public void SetVolume(double volume) throws Exception
    {
        if (volume > 0)
            _volume = volume;
        else
            throw new Exception("Volume is less than zero");
    }

    @Override
    public String toString()
    {
        return String.format("%s Volume: %f", super.toString(), _volume);
    }
}
