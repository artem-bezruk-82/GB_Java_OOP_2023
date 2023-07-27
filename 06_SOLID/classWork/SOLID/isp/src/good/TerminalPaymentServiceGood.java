package good;

public class TerminalPaymentServiceGood implements IPayableCreditCard, IPayableWebMoney
{
    @Override
    public void payWebMoney(int amount)
    {
        System.out.printf("Terminal pay by Web-money %d\n", amount);
    }

    @Override
    public void payCreditCard(int amount)
    {
        System.out.printf("Terminal pay by Credit card %d\n", amount);
    }
}
