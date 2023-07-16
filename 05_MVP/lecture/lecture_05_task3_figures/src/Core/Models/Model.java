package Core.Models;

import Mathematics.CalculateArea.ICalculate;
import Mathematics.Shapes.Canvas;
import Mathematics.Shapes.Shape;

public class Model
{
    Shape panel;
    ICalculate calc;

    public Model(ICalculate c, String canvasName)
    {
        panel = new Canvas(canvasName);//"Без имени (2).jpg");
        calc = c;
    }

    public void append(Shape shape) {
        panel.shapes.add(shape);
    }

    public double area() {
        return calc.visit(panel);
    }

    public String show() {
        return panel.toString();
    }

}
