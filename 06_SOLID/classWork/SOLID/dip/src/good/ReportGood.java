package good;

import bad.PrintReport;
import bad.ReportItem;

import java.util.ArrayList;
import java.util.List;

public class ReportGood
{
    private List<ReportItem> items;
    private IOutput output;

    public ReportGood()
    {
        items = new ArrayList<>();
    }


    public void calculate()
    {
        items.add(new ReportItem("First", (float)5));
        items.add(new ReportItem("Second", (float)6));
    }

    public void setOutput(IOutput output) { this.output = output; }

    public void output()
    {
        output.output(this);
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        for (ReportItem reportItem: items)
            sb.append(String.format("%s - %f\n", reportItem.getDescription(), reportItem.getAmount()));
        return sb.toString();
    }

    public List<ReportItem> getItems() { return items; }
}
