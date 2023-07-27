package bad;

import java.awt.*;

public class RightTriangle implements IShape
{
    private int legA;
    private int legB;
    private double hypotenuse;

    public RightTriangle(int legA, int legB)
    {
        this.legA = legA;
        this.legB = legB;
        this.hypotenuse = getHypotenuse();
    }

    public int getLegA() { return this.legA; }

    public int getLegB() { return this.legB; }

    public double getHypotenuse() { return Math.sqrt(Math.pow(this.legA,2) + Math.pow(this.legB,2)); }
}
