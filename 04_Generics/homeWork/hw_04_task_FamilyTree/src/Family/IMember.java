package Family;

import Human.Human;

import java.time.LocalDate;

public interface IMember
{
    String getName();
    public LocalDate getBirthDate();
    public LocalDate getDeathDate();

    IMember getFather();
    IMember getMother();
}
