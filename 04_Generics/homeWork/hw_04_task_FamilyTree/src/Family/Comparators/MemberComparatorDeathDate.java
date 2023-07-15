package Family.Comparators;

import Family.IMember;

import java.util.Comparator;

public class MemberComparatorDeathDate<T extends IMember> implements Comparator<T>
{
    @Override
    public int compare(T left, T right)
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