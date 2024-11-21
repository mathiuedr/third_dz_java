import java.util.Scanner;
import FormatExceptions.FioFormatException;
import FormatExceptions.DateFormatException;
public class Main {
    public static void main(String[] args)  {
        Scanner in = new Scanner(System.in);
        String FIO = in.nextLine();
        String date = in.nextLine();
        try {
            Date_Processor dp = new Date_Processor(date);
            FIO_Processor fp = new FIO_Processor(FIO);
            System.out.println(fp.getInitials());
            System.out.println(fp.getSex());
            System.out.println(Date_Processor.formatAge(dp.getAge()));
        } catch (DateFormatException e) {
            System.out.println("Bad data format");
            System.out.println(e);
        }
        catch (FioFormatException e){
            System.out.println("Bad FIO format");
            System.out.println(e);
        }
    }
}