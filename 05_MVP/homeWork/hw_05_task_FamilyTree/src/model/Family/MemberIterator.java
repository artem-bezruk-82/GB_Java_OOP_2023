package model.Family;


import java.util.Iterator;
import java.util.List;

public class MemberIterator<E> implements Iterator<E>
{
    private int index;
    private List<E> members;

    public MemberIterator(List<E> membersList)
    {
        this.members = membersList;
    }

    @Override
    public boolean hasNext()
    {
        return index < members.size();
    }

    @Override
    public E next()
    {
        return this.members.get(index++);
    }
}