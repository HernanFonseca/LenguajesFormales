package proyfinal;
import java.util.regex.Pattern;


/*
 * Analizador Lexico para Formulario que tenemos
 */
public class Lexer {

    public static Boolean lexReservedName(String input) {
        Boolean result = false;
        if (input.equals("Nombre:")){
            result = true;
        }
        return result;
    }

    public static Boolean lexReservedTelephone(String input){
        Boolean result = false;
        if (input.equals("Telefono:")){
            result = true;
        }
        return result;
    }

    public static Boolean lexReservedEmail(String input){
        Boolean result = false;
        if(input.equals("Email:")){
            result = true;
        }
        return result;
    }


    public static Boolean lexEmail(String input) {

        String pattern = "([A-z][a-z|0-9|[_]|[-]]*)@" +

                        "(hotmail|gmail|outlook|yahoo)." +
                        "(es|com|net|org|edu)$";
        Boolean matches = Pattern.matches(pattern, input);
        return matches;
    }

    public static Boolean lexName(String input){
        String pattern = "[a-z|A-Z]+(\\s[a-z|A-Z]+)*";
        boolean matches = Pattern.matches(pattern, input);
        return matches;
    }

    public static Boolean lexTelephone(String input){
        String pattern = "[6][0-9]{3}[-][0-9]{4}";
        boolean matches = Pattern.matches(pattern, input);
        return matches;
    }

    //Esta funcion se llama para cada palabra del read input que hernan hizo

    public String tokenize(String input){
        String type = null;
        Boolean reservedEmail = lexReservedEmail(input);
        Boolean reservedPhone = lexReservedTelephone(input); 
        Boolean reservedName = lexReservedName(input);
        Boolean name = lexName(input);
        Boolean email = lexEmail(input);
        Boolean telephone = lexTelephone(input);

        if(reservedEmail){
            return "EMAIL";
        }
        if(reservedPhone){
            return "TELEFONO";
        }
        if(reservedName){
            return "NOMBRE";
        }
        if(name){
            return "CONTNOMBRE";
        }
        if(email){
            return "CONTEMAIL";
        }
        if(telephone){
            return "CONTTELEFONO";
        }
        //System.out.println("ERROR LÉXICO EN: " + input);

        return type;
    }
}