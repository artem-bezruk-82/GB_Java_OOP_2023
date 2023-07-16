package Core.Infrastructure;

import Core.Models.Contact;

import java.util.ArrayList;
import java.util.List;

public class PhoneBook
{
    private List<Contact> contacts;

    public PhoneBook()
    {
        this.contacts = new ArrayList<>();
    }

    public boolean add(Contact contact)
    {
        if(!this.contacts.contains(contact))
        {
            this.contacts.add(contact);
            return true;
        }
        return false;
    }

    public Contact getContact(int index)
    {
        return this.contacts.get(index);
    }

    public boolean remove(Contact contact)
    {
        if (this.contacts.contains(contact))
        {
            remove(contact);
            return true;
        }
        return false;
    }

    private boolean contains(int index)
    {
        return this.contacts != null && this.contacts.size() > index;
    }

    public List<Contact> getContacts() {return this.contacts; }

    public int count() {return this.contacts.size(); }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        for (Contact contact : this.contacts)
            sb.append(String.format("%s\n",contact.toString()));
        return sb.toString();
    }
}
