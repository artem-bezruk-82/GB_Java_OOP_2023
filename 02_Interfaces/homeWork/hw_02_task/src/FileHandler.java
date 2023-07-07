import java.io.Serializable;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.FileInputStream;

public class FileHandler implements ISaveble, IReadable
{
    @Override
    public void Save(String filePath, Serializable object)
    {
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath)))
        {
            oos.writeObject(object);
        }
        catch(Exception exception)
        {
            System.out.println(exception.getMessage());
        }
    }

    @Override
    public Serializable Read(String filePath)
    {
        Serializable object = null;
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath)))
        {
            object = (Serializable)ois.readObject();
        }
        catch(Exception ex)
        {

            System.out.println(ex.getMessage());
        }
        return object;
    }
}
