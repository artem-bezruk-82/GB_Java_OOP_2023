package Human;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;

public class Human implements Serializable
{
    private static int fertilePeriodWomanStart = 15;
    private static int fertilePeriodWomanEnd = 50;
    private static int fertilePeriodManStart = 13;
    private static int fertilePeriodManEnd = 80;
    public enum GenderEnum
    {
        Man,
        Woman,
        Unknown
    }

    private String name;
    private String surname;
    private LocalDate birthDate;
    private LocalDate deathDate;
    private GenderEnum gender;
    private Human father;
    private Human mother;

    public Human(String name, String surname, GenderEnum gender, LocalDate birthDate, LocalDate deathDate,
                 Human father, Human mother)
            throws Exception
    {
        this.name = name;
        this.surname = surname;
        this.gender = gender;
        SetLifeDates(birthDate, deathDate);

        if (father != null)
            SetParent(father);
        else this.father = null;

        if (mother != null)
            SetParent(mother);
        else this.mother = null;

    }

    public Human(String name, String surname, GenderEnum gender, LocalDate birthDate, LocalDate deathDate)
            throws Exception
    {
        this(name, surname, gender, birthDate, deathDate, null, null);
    }

    public Human(String name, String surname, GenderEnum gender, LocalDate birthDate, Human father, Human mother)
            throws Exception
    {
        this(name, surname, gender, birthDate, null, father, mother);
    }


    public Human(String name, String surname, GenderEnum gender, LocalDate birthDate) throws Exception
    {
        this(name, surname, gender, birthDate, null, null, null);
    }

    public Human() throws Exception
    {
        this("","", GenderEnum.Unknown, null);
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getSurname() { return surname; }
    public void setSurname(String surname) { this.surname = surname; }
    public GenderEnum getGender() { return gender; }
    public LocalDate getBirthDate() { return birthDate; }

    public LocalDate getDeathDate() { return deathDate; }

    public Human getFather() { return father; }
    public Human getMother() { return mother; }

    private void SetLifeDates(LocalDate birthDate, LocalDate deathDate) throws Exception
    {
        if (birthDate != null && deathDate != null)
        {
            if (birthDate.isAfter(deathDate))
                throw new Exception("Birthdate can not follow by death date");
        }
        this.birthDate = birthDate;
        this.deathDate = deathDate;
    }

    public int GetAge()
    {
        return Period.between(birthDate, LocalDate.now()).getYears();
    }

    public void SetParent(Human parent) throws Exception
    {
        if (parent != this)
        {
            if (parent.gender == GenderEnum.Man)
            {
                if (father == null)
                {
                    if (parent.deathDate != null)
                    {
                        if (parent.deathDate.isBefore(birthDate))
                        {
                            if ((Period.between(parent.deathDate, birthDate).getMonths() > 9))
                                throw new Exception(String.format("%s can not be father as soon as he had died before %s was born",
                                        parent.name, name));
                        }
                    }

                    if (parent.birthDate != null)
                    {
                        if (parent.birthDate.isAfter(birthDate))
                            throw new Exception(String.format("%s can not be father as soon as he is younger than %s",
                                    parent.name, name));

                        else if (Period.between(parent.birthDate, birthDate).getYears() < fertilePeriodManStart ||
                                Period.between(parent.birthDate, birthDate).getYears() > fertilePeriodManEnd)
                            throw new Exception(String.format("%s can not be father as soon as he was outside %d...%d years old",
                                    parent.name, fertilePeriodManStart, fertilePeriodManEnd));
                    }
                    father = parent;
                }
                else
                {
                    throw new Exception("This person has already had father");
                }

            }

            if (parent.gender == GenderEnum.Woman)
            {
                if (mother == null)
                {
                    if (parent.deathDate != null)
                    {
                        if (parent.deathDate.isBefore(birthDate))
                            throw new Exception(String.format("%s can not be mother as soon as she had died before %s was born",
                                    parent.name, name));
                    }

                    if (parent.birthDate != null)
                    {
                        if (parent.birthDate.isAfter(birthDate))
                            throw new Exception(String.format("%s can not be mother as soon as she is younger than %s",
                                    parent.name, name));

                        if (Period.between(parent.birthDate, birthDate).getYears() < fertilePeriodWomanStart ||
                                Period.between(parent.birthDate, birthDate).getYears() > fertilePeriodWomanEnd)
                            throw new Exception(String.format("%s can not be mother as soon as she was outside %d...%d years old",
                                    parent.name, fertilePeriodWomanStart, fertilePeriodWomanEnd));
                    }
                    mother = parent;
                }
                else
                {
                    throw new Exception("This person has already had mother");
                }
            }
        }
        else
        {
            throw new Exception("This person can not be own parent");
        }
    }

    @Override
    public String toString()
    {
        return String.format("%s %s %s %s",
                name, surname, (birthDate == null ? "" : "- " + birthDate.toString()),
                (deathDate == null ? "" : "- " + deathDate.toString()));
    }
}