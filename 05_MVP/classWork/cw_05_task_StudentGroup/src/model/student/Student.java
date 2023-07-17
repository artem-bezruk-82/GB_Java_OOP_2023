package model.student;

import model.group.IGroupItem;

public class Student implements Comparable<Student>, IGroupItem
{
    private final long id;
    private String name;
    private int age;

    public Student(long id, String name, int age)
    {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public long getId() { return this.id; }
    @Override
    public int getAge() { return this.age; }
    public void setAge(int age) { this.age = age; }
    @Override
    public String getName() { return this.name; }
    public void setName(String name) { this.name = name; }


    @Override
    public String toString()
    {
        return String.format("%d - %s %d years", id, name, age);
    }

    @Override
    public int compareTo(Student obj)
    {
        return this.name.compareTo(obj.name);
    }
}