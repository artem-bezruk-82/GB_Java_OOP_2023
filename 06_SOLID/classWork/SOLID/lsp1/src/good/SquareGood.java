package good;

public class SquareGood implements IShape
{
    int side;
    public SquareGood(int side)
    {
        this.side = side;
    }

    public void setSide(int side)
    {
        this.side = side;
    }

    public int getSide() { return side; }

    @Override
    public int getArea() { return (int)Math.pow(this.side,2); }
}
