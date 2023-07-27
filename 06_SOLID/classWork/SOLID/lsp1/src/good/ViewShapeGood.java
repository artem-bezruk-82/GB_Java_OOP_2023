package good;

public class ViewShapeGood
{
    private IShape shape;

    public ViewShapeGood(IShape shape)
    {
        this.shape = shape;
    }

    public void showArea()
    {
        System.out.printf("%s area: %d\n", shape.getClass().getName(), shape.getArea());
    }
}
