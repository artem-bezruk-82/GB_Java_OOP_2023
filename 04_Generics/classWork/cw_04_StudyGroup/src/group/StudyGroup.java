package group;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import student.*;
import student.comparators.StudentComparatorByAge;
import student.comparators.StudentComparatorByName;

public class StudyGroup<E extends IGroupItem> implements Iterable<E>
{
    private List<E> students;

    public StudyGroup()
    {
        students = new ArrayList<>();
    }

    public void AddStudent(E student)
    {
        students.add(student);
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
