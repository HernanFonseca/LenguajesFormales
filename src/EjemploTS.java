import java.util.*;
import java.util.Scanner;

public class EjemploTS 
{
    public static class Token 
    {
        public final String t;
        public final String c; // contents

        public Token(String t, String c) 
        {
            this.t = t;
            this.c = c;
        }
    }
    public method Tabla() 
    {
        //EJEMPLOS
        int opc;
        String c = "vacio",d ="vacio";
        String ejemplo[] = {"Nombre:","Gabriel","Mendoza","Correo:","Gablienando","@","hotmail",".com","Telefono","6969","-","6969"};
        int nejemplo[] = {1,2,3,4,5,6,7,8,9,10,11,12};
        System.out.println("╔════════════════════╗");
        System.out.println("║  TABLA DE SIMBOLOS ║");
        System.out.println("╠════════════════════╣");
        System.out.println("║   Nombre/Simbolo   ║");
        System.out.println("╠════════════════════╣");
        for (int i = 0; i < 12; i++)
        {
        System.out.println("║"+ejemplo[i]);
        }
        System.out.println("╚════════════════════╝");
        System.out.println("╔════════════════════╗");
        System.out.println("║  TABLA DE SIMBOLOS ║");
        System.out.println("╠════════════════════╣");
        System.out.println("║     Dirección      ║");
        System.out.println("╠════════════════════╣");
        for (int i = 0; i < 12; i++)
        {
        System.out.println("║"  +nejemplo[i]);
        }
        System.out.println("╚════════════════════╝");
        System.out.println("╔════════════════════╗");
        System.out.println("║  TABLA DE SIMBOLOS ║");
        System.out.println("╠════════════════════╣");
        System.out.println("║       Tipo         ║");
        System.out.println("╠════════════════════╣");
        for (int i = 0; i < 12; i++)
        {
        System.out.println("║"+d);
        }
        System.out.println("╚════════════════════╝");
        System.out.println("╔════════════════════╗");
        System.out.println("║  TABLA DE SIMBOLOS ║");
        System.out.println("╠════════════════════╣");
        System.out.println("║       Clave        ║");
        System.out.println("╠════════════════════╣");
        for (int i = 0; i < 12; i++)
        {
        System.out.println("║"+c);
        }
        System.out.println("╚════════════════════╝");
    }

    public static void main(String[] args)  throws Exception 
    {  
        int opc;
        List<String> palabras = new ArrayList<String>();
        List<Token> tokens = new ArrayList<Token>();
    
        String path ="test.txt";
        Lexer analizadorLexico = new Lexer();
        ReadFile fileReader = new ReadFile();  
    
        palabras = fileReader.ReadTxt(path);
        String previous = "";
        System.out.println("╔══════════════════════════════════════════════════════╗");
        System.out.println("║----------------TABLA DE SIMBOLOS---------------------║");
        System.out.println("╠══════════════╦═════════╦═════════════════╦═══════════╣");
        System.out.println("║Nombre/Simbolo║Direccion║       Tipo      ║   Clave   ║");
        System.out.println("╠══════════════╬═════════╬═════════════════╬═══════════╣");
        for(Token token : tokens) 
        {
            if( (previous.equals("") && !token.t.startsWith("CONT")) || (previous.startsWith("CONT") && !token.t.startsWith("CONT")) || previous.startsWith(token.t.substring(4)) ) 
            {
            }
            previous = token.t;
        System.out.println("║              ║         ║                 ║           ║");
        }
        System.out.println("╚══════════════╩═════════╩═════════════════╩═══════════╝");
        Scanner teclado = new Scanner(System.in);    
        System.out.println("Que desea realizar?");
        System.out.println("1.Insertar en la tabla");
        System.out.println("2.Buscar en la tabla");
        System.out.println("3.Comparar elmentos en la tabla");
        opc = teclado.nextInt();

        switch(opc)
        {
            case 1:
            System.out.println("*********INSERTAR**************");
            //TEXTO
            break;

            case 2:
            System.out.println("**********BUSCAR**************");
            //TEXTO
            break;

            case 3:
            System.out.println("*********COMPARAR**************");
            //TEXTO
            break;
        }

    } 
 }

