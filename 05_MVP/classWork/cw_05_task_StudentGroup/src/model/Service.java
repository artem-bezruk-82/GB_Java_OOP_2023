package model;

import model.group.StudyGroup;
import model.student.Student;

public class Service
{
    private long id;
    private StudyGroup<Student> studyGroup;

    public Service()
    {
        studyGroup = new StudyGroup();
    }

    public boolean AddStudent(String name, int age)
    {
        Student student = new Student(id++, name, age);
        if (studyGroup.AddStudent(student))
            return true;
        return false;
    }

    public void SortByName()
    {
        studyGroup.SortByName();
    }

    public void SortByAge()
    {
        studyGroup.SortByAge();
    }

    public String GetStudentsInfo()
    {
        StringBuilder sb = new StringBuilder();
        for (Student student : studyGroup)
            sb.append(String.format("%s\n", student.toString()));

        return sb.toString();
    }

    @Override
    public String toString()
    {
        return studyGroup.toString();
    }
}
