import java.util.ArrayList;
import java.util.List;

public class ZooNoise implements ISoundable
{
    List<ISoundable> _sounds;

    public ZooNoise(List<ISoundable> sounds)
    {
        _sounds = sounds;
    }

    public ZooNoise()
    {
        this(new ArrayList<>());
    }

    public void Sound()
    {
        for (ISoundable item: _sounds)
            item.Sound();
    }
}
