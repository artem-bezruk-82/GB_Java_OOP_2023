import java.io.Serializable;

public interface ISaveble
{
    void Save(String filePath, Serializable object);
}
