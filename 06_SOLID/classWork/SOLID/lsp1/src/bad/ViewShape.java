package bad;

public class ViewShape
{
    private Rectangle rectangle;

    public ViewShape(Rectangle rectangle)
    {
        this.rectangle = rectangle;
    }

    public void showArea()
    {
        System.out.printf("bad.Rectangle area: %d\n", rectangle.getArea());
    }
}
