package bad;

import java.util.ArrayList;
import java.util.List;

public class Report
{
    private List<ReportItem> items;

    public void calculate()
    {
        items = new ArrayList<>();
        items.add(new ReportItem("First", (float)5));
        items.add(new ReportItem("Second", (float)6));
    }

    public void output()
    {
        PrintReport printReport = new PrintReport();
        printReport.output(items);
    }

}
