package vending;

import products.Product;

import java.util.ArrayList;
import java.util.List;

public class VendingMachine
{
    private static int counter = 0;
    private int _id;
    private List<Product> _productsList;

    public VendingMachine()
    {
        SetId();
        _productsList = new ArrayList<>();
    }

    public static int GetCounter() { return counter; }

    public int GetId() { return _id; }

    private void SetId()
    {
        counter++;
        _id = counter;
    }

    public  void AddProduct(Product product)
    {
        _productsList.add(product);
    }

    @Override
    public String toString()
    {
        return String.format("id: %d; %s", _id, _productsList.toString());
    }
}
