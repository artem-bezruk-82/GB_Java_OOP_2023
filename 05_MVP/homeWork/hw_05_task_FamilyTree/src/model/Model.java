package model;

import FilesHandling.FileHandler;
import model.Family.Family;
import model.Human.Human;

public class Model
{
    private Family<Human> family;
    private String filePath;

    private int currentMemberIndex;

    public Model(String filePath)
    {
        this.filePath = filePath;
        load();
        this.currentMemberIndex = -1;
    }

    public void load()
    {
        FileHandler fh = new FileHandler();
        this.family = (Family<Human>) fh.read(filePath);
        if (this.family == null)
            this.family = new Family<>();
    }

    public void save()
    {
        FileHandler fh = new FileHandler();
        fh.save(this.filePath, this.family);
    }

    public Family<Human> getFamily() { return this.family; }


    public int getCurrentMemberIndex()
    {
        return this.currentMemberIndex;
    }

    public void setCurrentMemberIndex(int index)
    {
        if (index >= 0 && index < family.getSize())
            this.currentMemberIndex = index;
    }

    public Human getCurrentMember()
    {
        if (currentMemberIndex >= 0 && currentMemberIndex < family.getSize())
            return family.getFamilyMember(currentMemberIndex);
        else
        {
            return null;
        }
    }


}
