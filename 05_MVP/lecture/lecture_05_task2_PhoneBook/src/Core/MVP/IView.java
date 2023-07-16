package Core.MVP;

public interface IView
{
    String getName();
    String getSurname();
    String getDescription();

    void setName(String name);
    void setSurname(String surname);
    void setDescription(String description);
}
