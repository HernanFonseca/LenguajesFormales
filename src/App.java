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

    public static void main(String[] args) {

        List<Palabra> palabras = new ArrayList<>();
        List<Token> tokens = new ArrayList<Token>();
        
        String path ="./4.txt";
        Lexer analizadorLexico = new Lexer();
        ReadFile fileReader = new ReadFile();
        
        palabras = fileReader.ReadTxt(path);
        //System.out.println(palabras);
        for (Palabra item : palabras) {
            String token = analizadorLexico.tokenize(item.palabra);
            if(token != null){
                tokens.add(new Token(token, item));
            } else {
                //// ERROR LÉXICO
                new LexicException(path, item.linea, item.index, fileReader.getContent(item.linea-1)); // se puede agregar el parámetro de # linea
                System.exit(1); // para que no imprima lo que sigue
            }
        }

        System.out.println("Tokens:");
        String previous = "";
        for(Token token : tokens) {
            System.out.print(token.t + ": " + token.p.palabra);
            System.out.println("");
            if( (previous.equals("") && !token.t.startsWith("CONT")) ||
                (previous.startsWith("CONT") && !token.t.startsWith("CONT")) ||
                previous.startsWith(token.t.substring(4)) ) {
            } else {
                //// ERROR SINTÁCTICO
                new SintaxException(path, token.p.linea, token.p.index, fileReader.getContent(token.p.linea-1)); // se puede agregar el parámetro de # linea
                System.exit(1); // para que no siga
            }
            previous = token.t;
        }
    }
}
