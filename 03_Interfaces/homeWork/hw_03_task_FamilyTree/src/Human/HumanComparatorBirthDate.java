package Human;

import java.util.Comparator;

public class HumanComparatorBirthDate implements Comparator<Human>
{

    @Override
    public int compare(Human left, Human right)
    {
        if (left.GetBirthDate().isBefore(right.GetBirthDate()))
            return 1;
        else if (!left.GetBirthDate().isBefore(right.GetBirthDate()))
        {
            return -1;
        } else
        {
            return 0;
        }
    }
}
