import java.util.ArrayList;

public class Family
{
    private String _name;
    private ArrayList<Human> _family;

    public Family(String name)
    {
        _name = name;
        _family = new ArrayList<>();
    }

    public Family() { this(null);}

    public void AddFamilyMember(Human human) { _family.add(human); }

    public String GetName() { return _name; }
    public void SetName(String name) { _name = name; }

    public Family GetChildrenOf(Human human)
    {
        Family children = new Family();
        children._name = String.format("%s's children", human.GetName());
        for (Human member : _family)
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
        return _family.get(index);
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s\n", _name));
        for (int i = 0; i < _family.size(); i++)
            sb.append(String.format("\t%d - %s\n", i, _family.get(i).toString()));

        return sb.toString();
    }
}
