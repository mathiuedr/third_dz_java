import FormatExceptions.FioFormatException;

public class FIO_Processor {
    String name,surname,patronymic;

    /**
     * Create FIO_Processor with FIO string
     * @param FIO FIO string in format "surname name patronymic"
     * @throws FioFormatException if FIO string isn`t in the right format
     */
    public FIO_Processor(String FIO) throws FioFormatException {
        String[] splitted = FIO.split(" ");
        if(splitted.length !=3) throw new FioFormatException("FIO should be in format: surname name patronymic");
        this.surname = splitted[0];
        this.name = splitted[1];
        this.patronymic = splitted[2];
    }

    /**
     * Default constructor
     * @throws FioFormatException always
     */
    public FIO_Processor() throws FioFormatException {
        this("");
    }

    /**
     * Get sex of human that have entered FIO
     * @return String "М" if male, "Ж" if female, "ОПРЕДЕЛИТЬ_НЕ_УДАЛОСЬ" if sex is undefined
     */
    public String getSex (){
        if(patronymic.charAt(patronymic.length() -2)=='и'&&patronymic.charAt(patronymic.length() -1)=='ч'){
            return "М";
        } else if (patronymic.charAt(patronymic.length() -2)=='н'&&patronymic.charAt(patronymic.length() -1)=='а') {
            return "Ж";
        }
        else {
            return "ОПРЕДЕЛИТЬ_НЕ_УДАЛОСЬ";
        }
    }

    /**
     * Get initials of person with entered FIO
     */
    public String getInitials (){
        return surname + " " + name.charAt(0) + "." + patronymic.charAt(0) + ".";
    }
}
