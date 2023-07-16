package model;

public class SumModel extends CalcModel
{
    @Override
    public void setValueA(int value)
    {
        this.valueA = value;
    }

    @Override
    public void setValueB(int value)
    {
        this.valueB = value;
    }

    @Override
    public int getResult()
    {
        return this.valueA + this.valueB;
    }

    @Override
    public String toString()
    {
        return String.format("%d + %d", valueA, valueB);
    }
}
