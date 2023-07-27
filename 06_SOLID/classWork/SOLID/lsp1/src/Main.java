import bad.Rectangle;
import bad.Square;
import bad.ViewShape;
import good.RectangleGood;
import good.SquareGood;
import good.ViewShapeGood;

public class Main
{
    public static void main(String[] args)
    {
        System.out.println("\n*** Bad practice ***");
        Rectangle rectangle = new Rectangle(2,3);
        Square square = new Square(3);
        ViewShape viewRectangle = new ViewShape(rectangle);
        ViewShape viewSquare = new ViewShape(square);
        viewRectangle.showArea();
        viewSquare.showArea();
        try
        {
            testRectangle(rectangle);
            System.out.println("rectangle is ok");
            testRectangle(square);
            System.out.println("square is ok");
        }
        catch (Exception exception)
        {
            System.out.println(exception.getMessage());
        }

        System.out.println("\n*** Good practice ***");
        RectangleGood rectangleGood = new RectangleGood(2,3);
        SquareGood squareGood = new SquareGood(3);
        ViewShapeGood viewRectangleGood = new ViewShapeGood(rectangleGood);
        ViewShapeGood viewSquareGood = new ViewShapeGood(squareGood);
        viewRectangleGood.showArea();
        viewSquareGood.showArea();

    }

    public static void testRectangle(Rectangle rectangle) throws Exception
    {
        rectangle.setSideA(3);
        rectangle.setSideB(2);

        if (rectangle.getArea() != 6)
        {
            throw new Exception(String.format("%s area is incorrect", rectangle.getClass()));
        }
    }
}