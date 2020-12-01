//import java.util.regex.*;
import java.util.*;

public class App {


    public static class Token {
        public final String t;
        public final Palabra p;

        public Token(String t, Palabra p) {
            this.t = t;     // token
            this.p = p;     // item de palabra
        }
    }


    public static void main(String[] args) throws Exception {
        int pass = 0; 
        List<Palabra> palabras = new ArrayList<>();
        List<Token> tokens = new ArrayList<Token>();

        String path ="3.txt";
        Lexer analizadorLexico = new Lexer();
        ReadFile fileReader = new ReadFile();
        palabras = fileReader.ReadTxt(path);
         
        
        for (Palabra item : palabras) {
            String token = analizadorLexico.tokenize(item.palabra);
            if(token != null){
                tokens.add(new Token(token, item));
            } else {
                //// ERROR LÉXICO
                LexicException(path, item.linea, item.index,
                                fileReader.getContent(item.linea - 1));
                System.exit(1); // para que no imprima lo que sigue
            }
        }
        
        System.out.println("Tokens:");
        if(pass==0) 
        {
        String previous = "";
        for (Token token : tokens) {
            System.out.print(token.t + ": " + token.p.palabra);
            System.out.println("");
            if ((previous.equals("") && !token.t.startsWith("CONT"))
                    || (previous.startsWith("CONT") && !token.t.startsWith("CONT"))
                    || previous.startsWith(token.t.substring(4))) {
            } else {
                //// ERROR SINTÁCTICO
                SintaxException(path, token.p.linea, token.p.index,
                                fileReader.getContent(token.p.linea - 1));
                System.exit(1); // para que no siga
            }
            previous = token.t;
        }
    }
    pass = 0;
    }
    public static void SintaxException(String path, int linea, int index, String palabra) {
        String message = "\nError en la linea " + linea + ":";
        message += "\n\t" + palabra + "\n\t" + " ".repeat(index) + "^";
        message += "\nError sintáctico: sintáxis inválida";
        message += "\n\ten " + path + ":" + linea + "," + index;
        System.out.println(message);
    }

    public static void LexicException(String path, int linea, int index, String palabra) {
        String message = "\nError en la linea " + linea + ":";
        message += "\n\t" + palabra + "\n\t" + " ".repeat(index) + "^";
        message += "\nError léxico: palabra inválida";
        message += "\n\ten " + path + ":" + linea + "," + index;
        System.out.println(message);
    }
}