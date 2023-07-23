package good;

import bad.Report;

public class PrintReportGood implements IOutput
{

    @Override
    public void output(ReportGood report)
    {
        System.out.println("Output to printer");
        System.out.println(report);
    }
}
