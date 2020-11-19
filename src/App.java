
import java.util.regex.*;

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

            String pattern = "[a-z]{1}[a-z|0-9|_|-]*[@]" + ".*(hotmail|gmail|outlook|yahoo).*{1}[.]" + ".*(es|com|net|org|edu).*{1}";
            boolean matches = Pattern.matches(pattern, "edulinaro@gmail.com");
            System.out.println(matches);



        List<String> palabras=new ArrayList<String>();
        String path ="./test.txt";

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
        String previous="";
        for(Token token : tokens) {
            System.out.print(token.t + ": " + token.c);
            System.out.println("");
            if(token.t.startsWith("CONT") && !token.t.equals("CONTNOMBRE") && previous.startsWith("CONT")){
                System.out.println("PAPAYA SINTÁCTICA CON EL TOKEN: "+token.t);
            }
            previous=token.t;
        }
    }
}
