public class Palabra {
    public final String palabra;
    public final int linea, index;

    public Palabra(String palabra, int linea, int index) {
        this.palabra = palabra;     // token
        this.linea = linea;     // cadena
        this.index = index;
    }
}