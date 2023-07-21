package model;

import FilesHandling.FileHandler;
import model.Family.Family;
import model.Human.Human;

public class Model
{
    private Family<Human> family;
    private String filePath;

    public Model(String filePath)
    {
        this.family = new Family<>();
        this.filePath = filePath;
        load();


    }

    public void load()
    {
        FileHandler fh = new FileHandler();
        this.family = (Family<Human>) fh.read(filePath);
    }

    public void save()
    {
        FileHandler fh = new FileHandler();
        fh.save(this.filePath, this.family);
    }

    public Family<Human> getFamily() { return this.family; }



}
