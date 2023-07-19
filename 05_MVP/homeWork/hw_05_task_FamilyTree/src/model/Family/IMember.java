package model.Family;

import java.time.LocalDate;

public interface IMember
{
    String getName();
    LocalDate getBirthDate();
    LocalDate getDeathDate();

    IMember getFather();
    IMember getMother();
}
