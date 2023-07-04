import java.time.LocalDate;
import java.time.Period;

public class Human
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

    private String _name;
    private String _surname;
    private LocalDate _birthDate;
    private LocalDate _deathDate;
    private GenderEnum _gender;
    private Human _father;
    private Human _mother;

    public Human(String name, String surname, GenderEnum gender, LocalDate birthDate, LocalDate deathDate,
                 Human father, Human mother)
            throws Exception
    {
        _name = name;
        _surname = surname;
        _gender = gender;
        SetLifeDates(birthDate, deathDate);

        if (father != null)
            SetParent(father);
        else _father = null;

        if (mother != null)
            SetParent(mother);
        else _mother = null;

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

    public String GetName() { return _name; }
    public void SetName(String name) { _name = name; }
    public String GetSurname() { return _surname; }
    public void SetSurname(String surname) { _surname = surname; }
    public GenderEnum GetGender() { return _gender; }
    public LocalDate GetBirthDate() { return _birthDate; }
    public Human GetFather() { return _father; }
    public Human GetMother() { return _mother; }

    private void SetLifeDates(LocalDate birthDate, LocalDate deathDate) throws Exception
    {
        if (birthDate != null && deathDate != null)
        {
            if (birthDate.isAfter(deathDate))
                throw new Exception();
        }
        _birthDate = birthDate;
        _deathDate = deathDate;
    }

    public int GetAge()
    {
        return Period.between(_birthDate, LocalDate.now()).getYears();
    }

    public void SetParent(Human parent) throws Exception
    {
        if (parent != this)
        {
            if (parent._gender == GenderEnum.Man)
            {
                if (_father == null)
                {
                    if (parent._deathDate != null)
                    {
                        if (parent._deathDate.isBefore(_birthDate))
                        {
                            if ((Period.between(parent._deathDate, _birthDate).getMonths() > 9))
                                throw new Exception(String.format("%s can not be father as soon as he had died before %s was born",
                                        parent._name, _name));
                        }
                    }

                    if (parent._birthDate != null)
                    {
                        if (parent._birthDate.isAfter(_birthDate))
                            throw new Exception(String.format("%s can not be father as soon as he is younger than %s",
                                    parent._name, _name));

                        else if (Period.between(parent._birthDate, _birthDate).getYears() < fertilePeriodManStart ||
                                Period.between(parent._birthDate, _birthDate).getYears() > fertilePeriodManEnd)
                            throw new Exception(String.format("%s can not be father as soon as he was outside %d...%d years old",
                                    parent._name, fertilePeriodManStart, fertilePeriodManEnd));
                    }
                    _father = parent;
                }
                else
                {
                    throw new Exception("This person has already had father");
                }

            }

            if (parent._gender == GenderEnum.Woman)
            {
                if (_mother == null)
                {
                    if (parent._deathDate != null)
                    {
                        if (parent._deathDate.isBefore(_birthDate))
                            throw new Exception(String.format("%s can not be mother as soon as she had died before %s was born",
                                    parent._name, _name));
                    }

                    if (parent._birthDate != null)
                    {
                        if (parent._birthDate.isAfter(_birthDate))
                            throw new Exception(String.format("%s can not be mother as soon as she is younger than %s",
                                    parent._name, _name));

                        if (Period.between(parent._birthDate, _birthDate).getYears() < fertilePeriodWomanStart ||
                                Period.between(parent._birthDate, _birthDate).getYears() > fertilePeriodWomanEnd)
                            throw new Exception(String.format("%s can not be mother as soon as she was outside %d...%d years old",
                                    parent._name, fertilePeriodWomanStart, fertilePeriodWomanEnd));
                    }
                    _mother = parent;
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
                _name, _surname, _birthDate.toString(), (_deathDate == null ? "" : "- " + _deathDate.toString()));
    }
}
