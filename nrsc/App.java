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
    	int pass = 0; 
        List<String> palabras = new ArrayList<String>();										
        List<Token> tokens = new ArrayList<Token>();

        String path ="test.txt";
        Lexer analizadorLexico = new Lexer();
        ReadFile fileReader = new ReadFile();
        
        palabras = fileReader.ReadTxt(path);
        
        for (String palabra : palabras) {
            String token = analizadorLexico.tokenize(palabra);
            if(token != null){
                tokens.add(new Token(token, palabra));
            } else{
                //System.out.println("ERROR LÉXICO");
                //tokens = new ArrayList<Token>();
                pass = 1;
            }
        }
        
        //System.out.println("\nTokens:");
        if(pass==0) {
        	String previous="";
        	for(Token token : tokens) {
        		//System.out.print(token.t + ": " + token.c);
        		System.out.println("");
        		if(token.t.startsWith("CONT") && !token.t.equals("CONTNOMBRE") && previous.startsWith("CONT")){
        			//System.out.println("ERROR SINTÁCTICO EN EL TOKEN: "+token.t);
        			break;
        		}
        		if(previous.equals("") && token.t.startsWith("CONT")){
        			//System.out.print("\tERROR SINTÁCTICO EN EL TOKEN: "+token.t);
        			break;
        		}
        		previous=token.t;
        	}
        }										//Enviar datos
        pass = 0;
    }
}