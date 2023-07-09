package Human.Comparators;

import Human.Human;

public class HumanComparatorDeathDate extends HumanComparator
{
    @Override
    public int compare(Human left, Human right)
    {
        if (left.getDeathDate() != null && right.getDeathDate() != null)
        {
            return left.getDeathDate().isBefore(right.getDeathDate()) ?
                    (left.getDeathDate().isBefore(right.getDeathDate()) ? 1 : 0) : -1;
        }
        else if (left.getDeathDate() == null && right.getDeathDate() == null)
        {
            return 0;
        }
        else if (left.getDeathDate() != null && right.getDeathDate() == null)
        {
            return 1;
        }
        else
        {
            return -1;
        }
    }
}
