//package project;
//import java.util.regex.*;
import java.util.*;

public class App 
{
    public static class Token {
        public final String t;
        public final String c; // contents

        public Token(String t, String c) {
            this.t = t;
            this.c = c;
        }
    }
    //CODIGO DEL MENU ----- APP
    public static void main(String[] args) throws Exception 
    {
    	int pass = 1;
        List<String> palabras = new ArrayList<String>();										
        List<Token> tokens = new ArrayList<Token>();

        String path ="test.txt";
        Lexer analizadorLexico = new Lexer();
        ReadFile fileReader = new ReadFile();
        Funcion_Tablahash TablaHash = new Funcion_Tablahash(1);
        palabras=fileReader.ReadTxt(path);
 //________________________________________________________________________________       
        String[] ListaTokens = new String[palabras.size()];										//String
         ListaTokens = palabras.toArray(ListaTokens);											//Pasar la lista a un array													//Enviar datos
 //________________________________________________________________________________          
        //System.out.println(palabras);
        for (String palabra : palabras) 
        {
            String token=analizadorLexico.tokenize(palabra);
            if(token!=null)
            {
                tokens.add(new Token(token, palabra));
            }
            else
            {
                System.out.println("ERROR LÉXICO");
                pass = 0;
                tokens = new ArrayList<Token>();
                break;
            }
        }  
        System.out.println("\nTokens:");
        String previous="";
        for(Token token : tokens) 
        {
            System.out.print(token.t + ": " + token.c);
            System.out.println("");
            if(token.t.startsWith("CONT") && !token.t.equals("CONTNOMBRE") && previous.startsWith("CONT"))
            {
                System.out.println("ERROR SINTÁCTICO EN EL TOKEN: "+token.t);
                pass=0;
                break;
            }
            if(previous.equals("") && token.t.startsWith("CONT"))
            {
                System.out.println("ERROR SINTÁCTICO EN EL TOKEN: "+token.t);
                pass= 0;
                break;
            }
            previous=token.t;
        }
        if(pass != 0)
        TablaHash.RECEIVE_DATA(ListaTokens);	
    }
}