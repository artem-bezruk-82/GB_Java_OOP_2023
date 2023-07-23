import bad.Report;
import good.PrintReportGood;
import good.PrintReportJson;
import good.ReportGood;

public class Main
{
    public static void main(String[] args)
    {
        System.out.println("*** Bad practice ***");
        Report report = new Report();
        report.calculate();
        report.output();

        System.out.println("\n*** Good practice ***");
        ReportGood reportGood = new ReportGood();
        reportGood.calculate();
        reportGood.setOutput(new PrintReportGood());
        reportGood.output();
        reportGood.setOutput(new PrintReportJson());
        reportGood.output();
    }
}