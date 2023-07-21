package Model;

import Family.Family;
import FilesHandling.FileHandler;
import Human.Human;

public class Model
{
    Family<Human> family;
    String filePath;

    public Model(String filePath)
    {
        this.filePath = filePath;
        load();

    }

    public void load()
    {
        FileHandler fh = new FileHandler();
        this.family = (Family<Human>) fh.read(filePath);
        if (this.family == null)
        {
            this.family = new Family<Human>();
        }
    }

    public void save()
    {
        FileHandler fh = new FileHandler();
        fh.save(this.filePath, this.family);
    }

    public Family<Human> getFamily() { return this.family; }
}
