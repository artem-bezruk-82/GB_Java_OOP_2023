package student;

import java.util.Iterator;
import java.util.List;

public class StudentIterator<E> implements Iterator<E>
{
    private int index;
    private List<E> students;

    public StudentIterator(List<E> students)
    {
        this.students = students;
    }

    @Override
    public boolean hasNext()
    {
        return index < this.students.size();
    }

    @Override
    public E next()
    {
        return this.students.get(index++);
    }
}
