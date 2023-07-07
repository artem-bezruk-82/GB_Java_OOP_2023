// Курс: Java. Объектно-ориентированное программирование
// Урок 2. Абстракция. Интерфейсы
// Домашняя работа

// Задание
// Подумайте и используйте интерфейсы.
// Дополнить проект методами записи в файл и чтения из файла.
// Для этого создать отдельный класс и реализовать в нем нужные методы.
// Для данного класса сделайте интерфейс, который и используйте в своей программе.

import java.time.LocalDate;

public class Main
{
    public static void main(String[] args)
    {
        Human mikhail = null;
        Human evdokia = null;
        Human irina = null;
        Human alexey = null;
        Human anna = null;
        Human tatyana = null;
        try
        {
            mikhail = new Human("Mikhail Fedorovich", "Romanov", Human.GenderEnum.Man,
                    LocalDate.of(1596, 7, 22), LocalDate.of(1645, 7, 23));
            evdokia = new Human("Evdokia Lukianovna", "Streshneva", Human.GenderEnum.Woman,
                    LocalDate.of(1608, 1, 1), LocalDate.of(1645, 8, 28));
            irina = new Human("Irina Mikhailovna", "Romanova", Human.GenderEnum.Woman,
                    LocalDate.of(1627, 4, 22), LocalDate.of(1679, 4, 8),
                    mikhail, evdokia);
            alexey = new Human("Alexey Mikhailovich", "Romanov", Human.GenderEnum.Man,
                    LocalDate.of(1629,3,29), LocalDate.of(1676,2,8),
                    mikhail, evdokia);
            anna = new Human("Anna Mikhailovna", "Romanova", Human.GenderEnum.Woman,
                    LocalDate.of(1630, 7, 24), LocalDate.of(1692, 11, 6),
                    mikhail, evdokia);
            tatyana = new Human("Tatyana Mikhailovna", "Romanova", Human.GenderEnum.Woman,
                    LocalDate.of(1636, 1, 15), LocalDate.of(1706, 9, 4),
                    mikhail, evdokia);
        }
        catch (Exception exception)
        {
            System.out.println(exception.getMessage());
        }

        FileHandler fh = new FileHandler();


        String romanovFile = "romanov.dat";
        Family romanovfamily = new Family("Romanov");
        romanovfamily.AddFamilyMember(mikhail);
        romanovfamily.AddFamilyMember(evdokia);
        romanovfamily.AddFamilyMember(irina);
        fh.Save(romanovFile, romanovfamily);
        romanovfamily = null;

        romanovfamily = (Family) fh.Read(romanovFile);
        romanovfamily.AddFamilyMember(alexey);
        romanovfamily.AddFamilyMember(anna);
        romanovfamily.AddFamilyMember(tatyana);
        fh.Save(romanovFile, romanovfamily);

        System.out.println(romanovfamily);
    }
}