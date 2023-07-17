package model.student.comparators;

import model.group.IGroupItem;

import java.util.Comparator;

public class StudentComparatorByAge<T extends IGroupItem> implements Comparator<T>
{
    @Override
    public int compare(T left, T right)
    {
        return Integer.compare(left.getAge(), right.getAge());
    }
}