package Human.Comparators;

import Human.Human;

public class HumanComparatorBirthDate extends HumanComparator
{
    @Override
    public int compare(Human left, Human right)
    {
        return left.getBirthDate().isBefore(right.getBirthDate()) ?
                (left.getBirthDate().isBefore(right.getBirthDate()) ? 1 : 0) : -1;
    }
}
