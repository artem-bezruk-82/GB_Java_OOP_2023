import products.Bottle;
import products.Product;
import vending.VendingMachine;

public class Main
{
    public static void main(String[] args)
    {
        VendingMachine vm = new VendingMachine();
        try
        {
            vm.AddProduct(new Product("product1", 25.0));
            vm.AddProduct(new Bottle("bottle2", 15.0, 1.5));
            vm.AddProduct(new Product("product3", 45.0));
            vm.AddProduct(new Bottle("bottle4", 76.0, 0.5));
        }
        catch (Exception exc)
        {
            System.out.println(exc.getMessage());
        }
        System.out.println(vm);
    }
}