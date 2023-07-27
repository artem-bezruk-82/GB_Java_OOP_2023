package good;

public class RectangleGood implements IShape
{
    private int sideA;
    private int sideB;

    public RectangleGood(int sideA, int sideB)
    {
        this.sideA = sideA;
        this.sideB = sideB;
    }

    public int getSideA() { return sideA; }

    public void setSideA(int sideA) { this.sideA = sideA; }

    public int getSideB() { return sideB; }

    public void setSideB(int sideB) { this.sideB = sideB; }

    @Override
    public int getArea() { return this.sideA * this.sideB; }
}
