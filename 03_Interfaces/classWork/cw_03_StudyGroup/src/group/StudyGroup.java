package group;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import student.*;
import student.comparators.StudentComparatorByAge;

public class StudyGroup implements Iterable<Student>
{
    private List<Student> students;

    public StudyGroup()
    {
        students = new ArrayList<>();
    }

    public void AddStudent(Student student)
    {
        students.add(student);
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        for (Student student : students)
            sb.append(String.format("%s\n", student));

        return sb.toString();
    }

    @Override
    public Iterator<Student> iterator()
    {
        return new StudentIterator(students);
    }

    public void SortByName()
    {
        Collections.sort(students);
    }

    public void SortByAge()
    {
        students.sort(new StudentComparatorByAge());
    }

}
