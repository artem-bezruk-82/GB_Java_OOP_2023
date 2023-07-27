import bad.InternetPaymentService;
import bad.TerminalPaymentService;
import good.InternetPaymentServiceGood;
import good.TerminalPaymentServiceGood;

public class Main
{
    public static void main(String[] args)
    {
        System.out.println("\n*** Bad practice ***");
        InternetPaymentService internetPaymentService = new InternetPaymentService();
        TerminalPaymentService terminalPaymentService = new TerminalPaymentService();
        try
        {
            internetPaymentService.payWebMoney(10);
            internetPaymentService.payCreditCard(10);
            internetPaymentService.payPhoneNumber(10);

            terminalPaymentService.payWebMoney(10);
            terminalPaymentService.payCreditCard(10);
            terminalPaymentService.payPhoneNumber(10);
        }
        catch (Exception exc)
        {
            exc.printStackTrace();
            System.out.println(exc.getMessage());
        }

        System.out.println("\n*** Good practice ***");
        InternetPaymentServiceGood internetPaymentServiceGood = new InternetPaymentServiceGood();
        TerminalPaymentServiceGood terminalPaymentServiceGood = new TerminalPaymentServiceGood();

        internetPaymentServiceGood.payWebMoney(10);
        internetPaymentServiceGood.payCreditCard(10);
        internetPaymentServiceGood.payPhoneNumber(10);

        terminalPaymentServiceGood.payWebMoney(10);
        terminalPaymentServiceGood.payCreditCard(10);

    }
}