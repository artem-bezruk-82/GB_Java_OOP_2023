package FilesHandling;

import java.io.Serializable;

public interface IReadable
{
    Serializable read(String filePath);
}
