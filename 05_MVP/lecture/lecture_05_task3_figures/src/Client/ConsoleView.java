package Client;

import java.util.Scanner;

import Core.Views.IView;

public class ConsoleView implements IView {
    Scanner in = new Scanner(System.in);

    public String get() {
        return in.next();
    };

    @Override
    public void set(String value) {
        System.out.println(value);

    }
}
