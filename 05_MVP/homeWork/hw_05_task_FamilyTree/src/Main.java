// Курс: Java. Объектно-ориентированное программирование
// Урок 5. Паттерн MVP
// Домашняя работа

// Задание
// Реализовать паттерн MVP в вашем проекте с семейным деревом.


import view.family.ConsoleUIFamily;

public class Main {
    public static void main(String[] args)
    {
        ConsoleUIFamily consoleUIFamily = new ConsoleUIFamily("family.dat");
        consoleUIFamily.start();
    }
}