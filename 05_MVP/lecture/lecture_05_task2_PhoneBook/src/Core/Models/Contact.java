package Core.Models;

public class Contact
{
    String name;
    String surname;
    Long phone;
    String description;

    public void setSurname(String surname) { this.surname = surname; }

    public void setName(String name) { this.name = name; }

    public void setPhone(long phone) throws Exception {
        if (phone < 10000000000L || phone > 99999999999L)
            throw new Exception("Value is out of 10000000000...99999999999 range");

        this.phone = phone;
    }

    public void setDescription(String description) { this.description = description; }

    public String getName() { return name; }

    public String getSurname() { return surname; }

    public long getPhone() { return phone; }

    public String getDescription() { return description; }

    @Override
    public boolean equals(Object obj)
    {
        Contact temp = (Contact) obj;
        return this.name == temp.name && this.surname == temp.surname;
    }

    @Override
    public String toString()
    {
        return String.format("%s %s, +%d, %s", this.name, this.surname, this.phone, this.description);
    }
}
