import java.util.*;
public class TablaDeSimbolos 
{
    public static class Token 
    {
        public final String t;
        public final Palabra p;

        public Token(String t, Palabra p) 
        {
            this.t = t;     // token
            this.p = p;     // item de palabra
        }
    }
    public static void main(String[] args) 
    {
        List<Palabra> palabras = new ArrayList<>();
        String path ="test.txt";
        //Lexer analizadorLexico = new Lexer();
        ReadFile fileReader = new ReadFile();
        palabras = fileReader.ReadTxt(path);
        final int FILAS = palabras.size();
        final int COLUMNAS = 4;
        String[][] Tabla = new String[FILAS][COLUMNAS];
        Tabla[0][0] = "       Simbolo";
        Tabla[0][1] = "          Dirección";
        Tabla[0][2] = "        Tipo";
        Tabla[0][3] = "             Clave";
        System.out.println("                          TABLA DE SIMBOLOS ");

        //Carga las letras en la matriz
        for(int f=1; f<FILAS; f++) 
        {
            for(int c=0; c<COLUMNAS; c++) 
            {
                if (Tabla[f][c] == Tabla[f][0])
                {
                
                Tabla[f][c] = "       Contenido";
                }
                if (Tabla[f][c] == Tabla[f][1])
                {
                Tabla[f][c] = "       Contenido2";
                }
                if (Tabla[f][c] == Tabla[f][2])
                {
                Tabla[f][c] = "       Contenido3";
                }
                else 
                {
                Tabla[f][c] = "       Contenido4";
                }
            }
        }
 
        //Mostrar en pantalla la matriz
        for(int f=0; f<FILAS; f++) 
        {
            for(int c=0; c<COLUMNAS; c++) 
            {
                System.out.print(Tabla[f][c]+" ");
            }
            System.out.println();
        }
    }
}
