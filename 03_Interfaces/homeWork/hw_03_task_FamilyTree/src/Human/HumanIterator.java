package Human;


import java.util.Iterator;
import java.util.List;

public class HumanIterator implements Iterator<Human>
{
    private int index;
    private List<Human> members;

    public HumanIterator(List<Human> membersList)
    {
        this.members = membersList;
    }

    @Override
    public boolean hasNext()
    {
        return index < members.size();
    }

    @Override
    public Human next()
    {
        return members.get(index++);
    }
}
