package model.group;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import model.student.StudentIterator;
import model.student.comparators.StudentComparatorByAge;
import model.student.comparators.StudentComparatorByName;

public class StudyGroup<E extends IGroupItem> implements Iterable<E>
{
    private List<E> students;

    public StudyGroup()
    {
        students = new ArrayList<>();
    }

    public boolean AddStudent(E student)
    {
        if (students.add(student))
            return true;
        return false;
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        for (E student : students)
            sb.append(String.format("%s\n", student));

        return sb.toString();
    }

    @Override
    public Iterator<E> iterator()
    {
        return new StudentIterator<>(students);
    }

    public void SortByName()
    {
        students.sort(new StudentComparatorByName<>());
    }

    public void SortByAge()
    {
        students.sort(new StudentComparatorByAge<>());
    }
}