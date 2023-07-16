package UI;

import javax.swing.text.View;
import java.util.Scanner;
import Core.MVP.IView;

public class ConsoleView implements IView
{
    Scanner in;
    public ConsoleView() {
        in = new Scanner(System.in);
    }
    @Override
    public String getName() {
        System.out.printf("FirstName: ");
        return in.nextLine();
    }

    @Override
    public void setName(String value) {
        System.out.printf("FirstName: %s\n", value);
    }

    @Override
    public String getSurname() {
        System.out.printf("LastName: ");
        return in.nextLine();
    }

    @Override
    public void setSurname(String value) {
        System.out.printf("LastName: %s\n", value);
    }

    @Override
    public String getDescription() {
        System.out.printf("Description: ");
        return in.nextLine();
    }

    @Override
    public void setDescription(String value) {
        System.out.printf("Description: %s\n", value);
    }
}
