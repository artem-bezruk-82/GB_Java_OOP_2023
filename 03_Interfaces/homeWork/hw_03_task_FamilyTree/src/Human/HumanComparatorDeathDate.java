package Human;

import java.util.Comparator;

public class HumanComparatorDeathDate implements Comparator<Human>
{
    @Override
    public int compare(Human left, Human right)
    {
        return left.getDeathDate().isBefore(right.getDeathDate()) ?
                (left.getDeathDate().isBefore(right.getDeathDate()) ? 1 : 0) : -1;
    }
}
