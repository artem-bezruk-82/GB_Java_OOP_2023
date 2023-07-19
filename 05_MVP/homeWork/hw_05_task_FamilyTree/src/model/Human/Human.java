package model.Human;

import model.Family.IMember;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;

public class Human implements Serializable, IMember
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
        setLifeDates(birthDate, deathDate);

        if (father != null)
            setParent(father);
        else this.father = null;

        if (mother != null)
            setParent(mother);
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

    public void setGender(GenderEnum gender) throws Exception {
        if (this.gender != GenderEnum.Unknown)
            throw new Exception("Gender have already been defined.");

        this.gender = gender;
    }

    @Override
    public LocalDate getBirthDate() { return birthDate; }
    @Override
    public LocalDate getDeathDate() { return deathDate; }

    @Override
    public Human getFather() { return father; }
    @Override
    public Human getMother() { return mother; }

    public void setBirthDate(LocalDate birthDate) throws Exception {
        if (this.deathDate != null)
        {
            if (birthDate.isAfter(this.deathDate))
                throw new Exception("Birthdate can not follow death date");
        }

        if (this.mother != null)
        {
            if (birthDate.isBefore(this.mother.birthDate))
                throw new Exception("Person could not be born before his(her) mother");
            if (Period.between(this.mother.birthDate, birthDate).getYears() < fertilePeriodWomanStart)
                throw new Exception("Person could not be born due to his(her) mother was too yang");
            if (Period.between(this.mother.birthDate, birthDate).getYears() > fertilePeriodWomanEnd)
                throw new Exception("Person could not be born due to his(her) mother was too old");
            if (birthDate.isAfter(this.mother.deathDate))
                throw new Exception("Person could not be born after his(her) mother had died");
        }

        if (this.father != null)
        {
            if (birthDate.isBefore(this.father.birthDate))
                throw new Exception("Person could not be born before his(her) father");
            if (Period.between(this.father.birthDate, birthDate).getYears() < fertilePeriodManStart)
                throw new Exception("Person could not be born due to his(her) father was too yang");
            if (Period.between(this.father.birthDate, birthDate).getYears() > fertilePeriodManEnd)
                throw new Exception("Person could not be born due to his(her) father was too old");
            if (Period.between(this.father.deathDate, birthDate).getMonths() > 9)
                throw new Exception("Person could not be born after his(her) father had died");
        }

        this.birthDate = birthDate;
    }

    public void setDeathDate(LocalDate deathDate) throws Exception {
        if (this.birthDate != null)
        {
            if (deathDate.isBefore(this.birthDate))
                throw new Exception("Death date cannot happen early than birth date");
        }
        this.deathDate = deathDate;
    }

    private void setLifeDates(LocalDate birthDate, LocalDate deathDate) throws Exception
    {
        if (birthDate != null && deathDate != null)
        {
            if (birthDate.isAfter(deathDate))
                throw new Exception("Birthdate can not follow death date");
        }
        this.birthDate = birthDate;
        this.deathDate = deathDate;
    }

    public int getAge()
    {
        return Period.between(birthDate, LocalDate.now()).getYears();
    }

    public void setParent(Human parent) throws Exception
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
                name, surname, (birthDate == null ? "" : "- " + birthDate),
                (deathDate == null ? "" : "- " + deathDate));
    }
}