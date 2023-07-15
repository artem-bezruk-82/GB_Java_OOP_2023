package student.comparators;

import group.IGroupItem;
import student.Student;

import java.util.Comparator;

public class StudentComparatorByAge<T extends IGroupItem> implements Comparator<T>
{
    @Override
    public int compare(T left, T right)
    {
        return Integer.compare(left.getAge(), right.getAge());
    }
}
