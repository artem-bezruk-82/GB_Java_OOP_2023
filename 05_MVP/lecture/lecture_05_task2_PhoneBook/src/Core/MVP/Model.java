package Core.MVP;

import Core.Infrastructure.PhoneBook;
import Core.Models.Contact;

import java.io.*;

public class Model
{
    PhoneBook currentBook;
    private int currentIndex;
    private String path;

    public Model(String path)
    {
        currentBook = new PhoneBook();
        currentIndex = 0;
        this.path = path;
    }

    public Contact currentContact()
    {
        if (currentIndex >= 0)
            return currentBook.getContact(currentIndex);
        else
            return null;
    }

    public void load()
    {
        try
        {
            File file = new File(path);
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String fname = reader.readLine();
            while (fname != null)
            {
                String lname = reader.readLine();
                String description = reader.readLine();
                Contact contact = new Contact();
                contact.setName(fname);
                contact.setSurname(lname);
                contact.setDescription(description);
                this.currentBook.add(contact);
                fname = reader.readLine();
            }
            reader.close();
            fr.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void save()
    {
        try (FileWriter writer = new FileWriter(path, false))
        {
            for (int i = 0; i < currentBook.count(); i++)
            {
                Contact contact = currentBook.getContact(i);
                writer.append(String.format("%s\n", contact.getName()));
                writer.append(String.format("%s\n", contact.getSurname()));
                writer.append(String.format("%s\n", contact.getDescription()));
            }
            writer.flush();
            writer.close();
        }
        catch (IOException ex)
        {
            System.out.println(ex.getMessage());
        }
    }

    public PhoneBook currentBook() {
        return this.currentBook;
    }

    public int getCurrentIndex() {
        return this.currentIndex;
    }

    public void setCurrentIndex(int value) {
        this.currentIndex = value;
    }

}
