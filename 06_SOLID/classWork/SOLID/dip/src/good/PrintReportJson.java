package good;

import bad.Report;
import bad.ReportItem;

public class PrintReportJson implements IOutput
{

    @Override
    public void output(ReportGood report)
    {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for (ReportItem reportItem : report.getItems())
        {
            stringBuilder.append("{");
            stringBuilder.append(String.format("\"description\":\"%s\",", reportItem.getDescription().toString()));
            stringBuilder.append(String.format("\"amount\":%f,", reportItem.getAmount()));
            stringBuilder.append("}");
        }
        stringBuilder.append("]");

        System.out.println("Print to JSON");
        System.out.println(stringBuilder);
    }
}
