package FilesHandling;

import java.io.Serializable;

public interface ISaveble
{
    void save(String filePath, Serializable object);
}
