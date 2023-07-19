package model.Family.Comparators;

import model.Family.IMember;

import java.util.Comparator;

public class MemberComparatorBirthDate<T extends IMember> implements Comparator<T>
{
    @Override
    public int compare(T left, T right)
    {
        return left.getBirthDate().isBefore(right.getBirthDate()) ?
                (left.getBirthDate().isBefore(right.getBirthDate()) ? 1 : 0) : -1;
    }
}
