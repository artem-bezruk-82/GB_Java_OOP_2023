package bad;

public interface IPayable
{
    void payWebMoney(int amount);
    void payCreditCard(int amount);
    void payPhoneNumber(int amount) throws Exception;
}
