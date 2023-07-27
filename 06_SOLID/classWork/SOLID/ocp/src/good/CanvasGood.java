package good;

import bad.IShape;
import bad.RightTriangle;
import bad.Square;

import java.util.ArrayList;
import java.util.List;

public class CanvasGood implements IShapeGood
{
    private List<IShapeGood> shapes;

    public CanvasGood()
    {
        this.shapes = new ArrayList<>();
    }

    public void addShape(IShapeGood shape) { this.shapes.add(shape); }

    @Override
    public double getArea()
    {
        double sumArea = 0;
        for (IShapeGood shape : shapes)
            sumArea += shape.getArea();

        return sumArea;
    }
}
