package student;

import java.util.Iterator;
import java.util.List;

public class StudentIterator implements Iterator<Student>
{
    private int index;
    private List<Student> students;

    public StudentIterator(List<Student> students)
    {
        this.students = students;
    }

    @Override
    public boolean hasNext()
    {
        return index < this.students.size();
    }

    @Override
    public Student next()
    {
        return this.students.get(index++);
    }
}
