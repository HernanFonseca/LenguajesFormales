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
        
        String path ="./test.txt";
        Lexer analizadorLexico = new Lexer();
        ReadFile fileReader = new ReadFile();
        
        palabras=fileReader.ReadTxt(path);
        //System.out.println(palabras);
        for (String palabra : palabras) {
            String token=analizadorLexico.tokenize(palabra);
            if(token!=null){
                tokens.add(new Token(token, palabra));
            }else{
                System.out.println("PAPAYA LEXICA");
                tokens = new ArrayList<Token>();
                break;
            }
        }
        System.out.println("Tokens:");
        for(Token token : tokens) {
            System.out.print(token.t + ": " + token.c);
            System.out.println("");
        }
    }
}
