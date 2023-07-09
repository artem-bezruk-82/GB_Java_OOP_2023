package student.comparators;

import student.Student;

import java.util.Comparator;

public class StudentComparatorByAge implements Comparator<Student>
{
    @Override
    public int compare(Student left, Student right)
    {
        return Integer.compare(left.getAge(), right.getAge());
    }
}
