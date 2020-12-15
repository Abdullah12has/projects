package labguide14_q1b;


public class Cal {

    public static String calculate(String n, String den) {
        String msg = "";
        int nume, denomi, myresult;
        
       
        try {
            nume = Integer.parseInt(n);
            denomi = Integer.parseInt(den);
            myresult = nume / denomi;
            msg = "\nResult: " + nume + " / " + denomi + " = " + myresult;
        } catch (NumberFormatException numberFormatException) {
            msg = "\nException:" + numberFormatException;
            msg += "\nYou must enter integers.\nPlease try again.\n";

        } catch (ArithmeticException arithmeticException) {
            msg = "\nException:" + arithmeticException;
            msg += "\nZero is an invalid denominator.\nPlease try again\n";
        }

        return msg;
    }
}
