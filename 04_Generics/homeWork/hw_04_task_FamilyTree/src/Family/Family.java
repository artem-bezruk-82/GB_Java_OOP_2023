package Family;

import Family.Comparators.MemberComparatorBirthDate;
import Family.Comparators.MemberComparatorDeathDate;
import Family.Comparators.MemberSortingTypesEnum;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public class Family<E extends IMember> implements Serializable, Iterable<E>
{
    private String name;
    private ArrayList<E> family;

    public Family(String name)
    {
        this.name = name;
        family = new ArrayList<>();
    }

    public Family() { this(null);}

    public void AddFamilyMember(E member)
    {
        if (!family.contains(member))
            family.add(member);
    }

    public String GetName() { return name; }
    public void SetName(String name) { this.name = name; }

    public Family<E> GetChildrenOf(E parent)
    {
        Family<E> children = new Family<E>();
        children.name = String.format("%s's children", parent.getName());
        for (E member : family)
        {
            if (member.getFather() == parent || member.getMother() == parent)
                children.AddFamilyMember(member);
        }
        return children;
    }

    public Family<E> GetChildrenOf(int index)
    {
        return GetChildrenOf(GetFamilyMember(index));
    }

    public E GetFamilyMember(int index)
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

    public void sort(MemberSortingTypesEnum sortingType)
    {
        switch (sortingType) {
            case sort_by_birthDate -> family.sort(new MemberComparatorBirthDate<>());
            case sort_by_deathDate -> family.sort(new MemberComparatorDeathDate<>());
        }
    }

    @Override
    public Iterator<E> iterator()
    {
        return new MemberIterator<>(family);
    }
}