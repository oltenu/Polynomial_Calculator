package logic.utility;

public class DoubleFormat {
    //source: https://stackoverflow.com/questions/703396/how-to-nicely-format-floating-numbers-to-string-without-unnecessary-decimal-0s
    public static String formatDouble(double number){
        if(number == (int) number)
            return String.format("%s", (int)number);
        else
            return String.format("%s", number);
    }
}
