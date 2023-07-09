import Human.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public class Family implements Serializable, Iterable<Human>
{
    private String name;
    private ArrayList<Human> family;

    public Family(String name)
    {
        this.name = name;
        family = new ArrayList<>();
    }

    public Family() { this(null);}

    public void AddFamilyMember(Human human) { family.add(human); }

    public String GetName() { return name; }
    public void SetName(String name) { this.name = name; }

    public Family GetChildrenOf(Human human)
    {
        Family children = new Family();
        children.name = String.format("%s's children", human.GetName());
        for (Human member : family)
        {
            if (member.GetFather() == human)
                children.AddFamilyMember(member);
        }
        return children;
    }

    public Family GetChildrenOf(int index)
    {
        return GetChildrenOf(GetFamilyMember(index));
    }

    public Human GetFamilyMember(int index)
    {
        return family.get(index);
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s\n", name));
        for (int i = 0; i < family.size(); i++)
            sb.append(String.format("\t%d - %s\n", i, family.get(i).toString()));

        return sb.toString();
    }

    @Override
    public Iterator<Human> iterator() {
        return new HumanIterator(family);
    }
}
