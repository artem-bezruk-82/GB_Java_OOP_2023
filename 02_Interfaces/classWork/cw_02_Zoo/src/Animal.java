public abstract class Animal implements ISoundable
{
    protected String _name;

    public String GetName() { return _name; }
    public void SetName(String name) { _name = name; }

    public abstract void Sound();
}
