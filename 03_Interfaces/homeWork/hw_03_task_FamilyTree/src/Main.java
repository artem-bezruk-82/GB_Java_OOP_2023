// Курс: Java. Объектно-ориентированное программирование
// Урок 2. Абстракция. Интерфейсы
// Домашняя работа

// Задание
// Реализовать интерфейс Iterable для дерева.
// Создать методы сортировки списка людей перед выводом, например по имени или по дате рождения (не менее 2)
// Создать пакетную структуру для проекта

import FilesHandling.*;
import Human.*;

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
        Family romanovFamily = new Family("Romanov");
        romanovFamily.AddFamilyMember(mikhail);
        romanovFamily.AddFamilyMember(evdokia);
        romanovFamily.AddFamilyMember(irina);
        fh.save(romanovFile, romanovFamily);
        romanovFamily = null;

        romanovFamily = (Family) fh.read(romanovFile);
        romanovFamily.AddFamilyMember(alexey);
        romanovFamily.AddFamilyMember(anna);
        romanovFamily.AddFamilyMember(tatyana);
        fh.save(romanovFile, romanovFamily);

        System.out.println(romanovFamily);

        System.out.println("Sorted by birth date");
        romanovFamily.sortByBirthDate();
        System.out.println(romanovFamily);

        System.out.println("Sorted by death date");
        romanovFamily.sortByDeathDate();
        System.out.println(romanovFamily);
    }
}