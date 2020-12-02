import java.util.*;


public class EjemploTS 
{
    //Esto esta para evitar que los elementos se reestackee cuando vuelvas a llamar "Tablas()"
    static List<String> palabras = new ArrayList<String>();
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
    public void Tabla() 
    {
        //DE MOMENTO ESTA INDEFINIDO
        String c= "Indefinido",d ="indefinido";
        //Este contador da la posiciones de los elementos detectados,esta a "-1" porque tome en cuenta la posicion 0 ya que uso listas.
        int contador = -1;
        System.out.println("╔════════════════════╗");
        System.out.println("║  TABLA DE SIMBOLOS ║");
        System.out.println("╠════════════════════╣");
        System.out.println("║   Nombre/Simbolo   ║");
        System.out.println("╠════════════════════╣");
        //Obtener en pantalla todos los datos del fichero
        for (int i = 0; i < palabras.size(); i++)
        {
            System.out.println("║"+palabras.get(i));
        }
        System.out.println("╚════════════════════╝");
        System.out.println("╔════════════════════╗");
        System.out.println("║  TABLA DE SIMBOLOS ║");
        System.out.println("╠════════════════════╣");
        System.out.println("║     Dirección      ║");
        System.out.println("╠════════════════════╣");
        //Establecer la posicion de el elemento 
        for (int i = 0; i < palabras.size(); i++)
        {
            contador = contador + 1;
            System.out.println("║"  +contador);
        }
        System.out.println("╚════════════════════╝");
        System.out.println("╔════════════════════╗");
        System.out.println("║  TABLA DE SIMBOLOS ║");
        System.out.println("╠════════════════════╣");
        System.out.println("║       Tipo         ║");
        System.out.println("╠════════════════════╣");
        //Tengo un asunto que resolver con el tipo les cuento, miren al momento de recoger los datos del fichero la lectura se realizar pero... Hay elementos como
        // al escribir el correo electronico es toma "CorreoEjemplo@gmail.com" como un todo, el objetivo es obtener:
        //    "CorreoEjemplo" ;         "@"        ;       "gmail"      ;      ".com"
        //ejemplo.add(Usuario);ejemplo.add(Simbolo);ejemplo.add(Dominio);ejemplo.add(Tipo);
        // Para solucionarlo tengo dos ideas cambiar la manera en la que leemos el fichero (Que es la mas tediosa, o eso creo yo)
        // o comprarla con una lista de simbolos,numeros,tipos,dominios etc etc. Necesito entender un poco mas la lectura.
        for (int i = 0; i < palabras.size(); i++)
        {
        //System.out.println("║"+tokens.get());
        }
        System.out.println("╚════════════════════╝");
        System.out.println("╔════════════════════╗");
        System.out.println("║  TABLA DE SIMBOLOS ║");
        System.out.println("╠════════════════════╣");
        System.out.println("║       Clave        ║");
        System.out.println("╠════════════════════╣");
        //De momento Edwin es el que esta buscando la manera de establecer el HASH, estamos buscando adaptar el programa para arreglos multidimensionales
        for (int i = 0; i < palabras.size(); i++)
        {
            System.out.println("║"+d);
        }
        System.out.println("╚════════════════════╝");
    }

    public static void main(String[] args)  
    {  

        List<Palabra> palabras = new ArrayList<>();
        //List<Token> tokens = new ArrayList<Token>();
        
        String path ="test.txt";
        Lexer analizadorLexico = new Lexer();
        ReadFile fileReader = new ReadFile();
        
        palabras = fileReader.ReadTxt(path);
        System.out.println(palabras);

        for (Palabra item : palabras) 
        {
            String token = analizadorLexico.tokenize(item.palabra);
            if(token != null)
            {
                //tokens.add(new Token(token, item));
            } else 
            {
                //// ERROR LÉXICO
                new LexicException(path, item.linea, item.index, fileReader.getContent(item.linea-1));
                System.exit(1); // para que no imprima lo que sigue
            }
        }

        EjemploTS Obtener = new EjemploTS(); 
        Obtener.Tabla();
        
    } 
}
 

