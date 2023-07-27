import bad.Canvas;
import bad.RightTriangle;
import bad.Square;
import good.CanvasGood;
import good.RightTriangleGood;
import good.SquareGood;

public class Main
{
    public static void main(String[] args)
    {
        System.out.println("\n*** Bad practice ***");
        Canvas canvas = new Canvas();
        canvas.addShape(new Square(4));
        canvas.addShape(new RightTriangle(2,3));
        System.out.printf("Total area: %f\n",canvas.getArea());

        System.out.println("\n*** Good practice ***");
        CanvasGood canvasGood = new CanvasGood();
        canvasGood.addShape(new SquareGood(4));
        canvasGood.addShape(new RightTriangleGood(3, 2));
        System.out.printf("Total area: %f\n",canvasGood.getArea());
    }
}