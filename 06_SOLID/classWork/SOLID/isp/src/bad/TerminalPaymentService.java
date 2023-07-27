package bad;

public class TerminalPaymentService implements IPayable
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

    @Override
    public void payPhoneNumber(int amount) throws Exception
    {
        throw new Exception("not implemented");
    }
}
