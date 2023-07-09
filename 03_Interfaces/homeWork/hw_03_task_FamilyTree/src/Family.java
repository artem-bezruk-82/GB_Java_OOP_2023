import Human.*;
import Human.Comparators.HumanComparatorBirthDate;
import Human.Comparators.HumanComparatorDeathDate;
import Human.Comparators.HumanSortingTypesEnum;

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

    public void AddFamilyMember(Human human)
    {
        if (!family.contains(human))
            family.add(human);
    }

    public String GetName() { return name; }
    public void SetName(String name) { this.name = name; }

    public Family GetChildrenOf(Human human)
    {
        Family children = new Family();
        children.name = String.format("%s's children", human.getName());
        for (Human member : family)
        {
            if (member.getFather() == human)
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

    public void sort(HumanSortingTypesEnum sortingType)
    {
        switch (sortingType)
        {
            case sort_by_birthDate:
                family.sort(new HumanComparatorBirthDate());
                break;
            case sort_by_deathDate:
                family.sort(new HumanComparatorDeathDate());
                break;
        }
    }

    @Override
    public Iterator<Human> iterator() {
        return new HumanIterator(family);
    }
}
