//import java.util.regex.*;
import java.util.*;

public class App {

    public static class Token {
        public final String t;
        public final String c; // contents

        public Token(String t, String c) {
            this.t = t;
            this.c = c;
        }
    }

    public static void main(String[] args) throws Exception {

        List<String> palabras = new ArrayList<String>();
        List<Token> tokens = new ArrayList<Token>();
        
        String path ="./10.txt";
        Lexer analizadorLexico = new Lexer();
        ReadFile fileReader = new ReadFile();
        
        palabras = fileReader.ReadTxt(path);
        //System.out.println(palabras);
        for (String palabra : palabras) {
            String token = analizadorLexico.tokenize(palabra);
            if(token != null){
                tokens.add(new Token(token, palabra));
            } else {
                System.out.println("ERROR LÉXICO");
                tokens = new ArrayList<Token>();
                break;
            }
        }

        System.out.println("Tokens:");
        String previous = "";
        for(Token token : tokens) {
            System.out.print(token.t + ": " + token.c);
            System.out.println("");
            if( (previous.equals("") && token.t.equals("NOMBRE")) ||
                ((previous.equals("NOMBRE") || previous.equals("CONTNOMBRE")) && token.t.equals("CONTNOMBRE")) ||
                (previous.equals("CONTNOMBRE") && token.t.equals("EMAIL")) ||
                (previous.equals("EMAIL") && token.t.equals("CONTEMAIL")) ||
                (previous.equals("CONTEMAIL") && token.t.equals("TELEFONO")) ||
                (previous.equals("TELEFONO") && token.t.equals("CONTTELEFONO"))) {
            } else {
                System.out.println("ERROR SINTÁCTICO EN EL TOKEN: " + token.t);
                break;
            }
            
            previous = token.t;
        }
    }
}
