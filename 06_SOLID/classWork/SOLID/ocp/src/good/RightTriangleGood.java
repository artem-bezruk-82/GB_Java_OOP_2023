package good;

public class RightTriangleGood implements IShapeGood
{
    private int legA;
    private int legB;
    private double hypotenuse;

    public RightTriangleGood(int legA, int legB)
    {
        this.legA = legA;
        this.legB = legB;
        this.hypotenuse = getHypotenuse();
    }

    public int getLegA() { return this.legA; }

    public int getLegB() { return this.legB; }

    public double getHypotenuse() { return Math.sqrt(Math.pow(this.legA,2) + Math.pow(this.legB,2)); }

    @Override
    public double getArea() { return this.legA * this.legB / 2.0; }
}
