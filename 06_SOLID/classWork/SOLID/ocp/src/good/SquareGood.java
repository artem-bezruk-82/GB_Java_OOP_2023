package good;

import bad.IShape;

public class SquareGood implements IShapeGood
{
    private int side;

    public SquareGood(int side)
    {
        this.side = side;
    }

    public int getSide() { return side; }

    @Override
    public double getArea() { return Math.pow(this.side, 2); }
}
