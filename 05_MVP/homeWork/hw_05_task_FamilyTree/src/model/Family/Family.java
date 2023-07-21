package model.Family;

import model.Family.Comparators.MemberComparatorBirthDate;
import model.Family.Comparators.MemberComparatorDeathDate;
import model.Family.Comparators.MemberSortingTypesEnum;

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

    public Family() { this("");}

    public boolean addFamilyMember(E member)
    {
        if (!family.contains(member))
        {
            family.add(member);
            return true;
        }
        return false;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Family<E> getChildrenOf(E parent)
    {
        Family<E> children = new Family<E>();
        children.name = String.format("%s's children", parent.getName());
        for (E member : family)
        {
            if (member.getFather() == parent || member.getMother() == parent)
                children.addFamilyMember(member);
        }
        return children;
    }

    public Family<E> getChildrenOf(int index)
    {
        return getChildrenOf(getFamilyMember(index));
    }

    public E getFamilyMember(int index)
    {
        return family.get(index);
    }

    public void removeFamilyMember(int index)
    {
        family.remove(index);
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

    public int getSize()
    {
        return this.family.size();
    }

    @Override
    public Iterator<E> iterator()
    {
        return new MemberIterator<>(family);
    }
}