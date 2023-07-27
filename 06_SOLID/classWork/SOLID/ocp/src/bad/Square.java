package bad;

public class Square implements IShape
{
    private int side;

    public Square(int side)
    {
        this.side = side;
    }

    public int getSide() { return side; }
}
