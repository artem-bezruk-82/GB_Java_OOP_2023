import java.util.ArrayList;

public class Main
{
    public static void main(String[] args)
    {
        ArrayList<ISoundable> sounds = new ArrayList<>();

        Dog dog = new Dog();
        dog.SetName("Zhuchka");
        sounds.add(dog);

        Cat cat = new Cat();
        cat.SetName("Murka");
        sounds.add(cat);

        sounds.add(new Radio());

        ZooNoise zooNoise = new ZooNoise(sounds);
        zooNoise.Sound();
    }
}