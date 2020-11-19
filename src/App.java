
import java.util.regex.*;

import java.util.*;

public class App {

    public static void main(String[] args) throws Exception {

        List<String> palabras=new ArrayList<String>();
        List<String> tokens=new ArrayList<String>();
        
        String path ="./test.txt";
        Lexer analizadorLexico = new Lexer();
        ReadFile fileReader = new ReadFile();
        
        palabras=fileReader.ReadTxt(path);
        //System.out.println(palabras);
        for (String palabra : palabras) {
            String token=analizadorLexico.tokenize(palabra);
            tokens.add(token);
        }
    }
}
