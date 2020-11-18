import java.util.List;
import java.util.ArrayList;
import java.util.regex.*;

/*
 * Analizador Lexico para Formulario que tenemos
 */
public class Lexer {
    public static enum Type {
        // Los tipos de Token que se tienen
        NOMBRE, EMAIL, TELEFONO,
        CONTNOMBRE, CONTEMAIL, CONTTELEFONO;
    }
    public static class Token {
        public final Type t;
        public final String c; // contents

        public Token(Type t, String c) {
            this.t = t;
            this.c = c;
        }
        public String toString() {
            if(t == Type.CONTNOMBRE) {
                return c;
            }
            return t.toString();
        }
    }

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

    public static Boolean lexMail(String input) {
        String pattern = "([a-z][a-z|0-9|[_]|[-]]*)@" +
                        "(hotmail|gmail|outlook|yahoo)." +
                        "(es|com|net|org|edu)$";
        Boolean matches = Pattern.matches(pattern, input);
        return matches;
    }

    
    //Esta funcion se llama para cada palabra del read input que hernan hizo
    public static Token tokenize(String input){
        Boolean reservedEmail = lexReservedEmail(input);
        Boolean reservedPhone = lexReservedTelephone(input); 
        Boolean reservedName = lexReservedName(input);

        //Aqui va el if comparando todos estos bool y el que sea true asigna el input a ese token



    }
}