package Human;

import java.util.Comparator;

public class HumanComparatorBirthDate implements Comparator<Human>
{
    @Override
    public int compare(Human left, Human right)
    {
        return left.getBirthDate().isBefore(right.getBirthDate()) ?
                (left.getBirthDate().isBefore(right.getBirthDate()) ? 1 : 0) : -1;
    }
}
