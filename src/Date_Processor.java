import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.Period;
import FormatExceptions.DateFormatException;
public class Date_Processor {
    LocalDate birth_date;

    /**
     * Process entered date
     * @param input string in format "dd.MM.yyyy"
     * @throws DateFormatException if string isn`t in the required format
     */
    public Date_Processor(String input) throws DateFormatException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        try {
            this.birth_date = LocalDate.parse(input, formatter);
        }
        catch (DateTimeParseException e){
            throw new DateFormatException("Date should be in format dd.mm.yyyy");
        }
    }

    /**
     * Default constructor
     * @throws DateFormatException always
     */
    public Date_Processor() throws DateFormatException {
        this("");
    }

    /**
     * Get age of person with date of birth entered while creating object
     * @return int age
     */
    public int getAge(){
        return Period.between(this.birth_date,LocalDate.now()).getYears();
    }

    /**
     * Format age to russian language format "год, года or лет"
     * @param age int age to format
     * @return string with age in right format
     */
    public static String formatAge(int age){
        StringBuilder sb = new StringBuilder();
        sb.append(age).append(" ");
        String age_str = Integer.toString(age);
        int last_symbol=Integer.parseInt(String.valueOf(age_str.charAt(age_str.length()-1)));
        if(last_symbol>1&&last_symbol<5){
            sb.append("года");
        } else if (last_symbol>=5 || last_symbol==0) {
            sb.append("лет");
        }else{
            sb.append("год");
        }
        return sb.toString();

    }
}
