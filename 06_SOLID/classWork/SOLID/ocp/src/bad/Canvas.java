package bad;

import bad.RightTriangle;
import bad.Square;

import java.util.ArrayList;
import java.util.List;

public class Canvas
{
    private List<IShape> shapes;

    public Canvas()
    {
        this.shapes = new ArrayList<>();
    }

    public void addShape(IShape shape) { this.shapes.add(shape); }

    public double getArea()
    {
        double sumArea = 0;
        for (IShape shape : shapes)
        {
            if (shape instanceof RightTriangle)
            {
                RightTriangle triangle = (RightTriangle) shape;
                sumArea += triangle.getLegA() * triangle.getLegB() / 2.0;
            }
            if (shape instanceof Square)
            {
                Square square = (Square) shape;
                sumArea += Math.pow(square.getSide(),2);
            }
        }
        return sumArea;
    }
}
