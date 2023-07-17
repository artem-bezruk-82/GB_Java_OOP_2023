package model.student.comparators;

import model.group.IGroupItem;

import java.util.Comparator;

public class StudentComparatorByName <T extends IGroupItem> implements Comparator<T>
{
    @Override
    public int compare(T left, T right)
    {
        return left.getName().compareTo(right.getName());
    }
}