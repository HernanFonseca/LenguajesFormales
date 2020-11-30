public class LexicException {
    String message;

    public LexicException(String path, int linea, int index, String palabra) {
        message = "\nError en la linea " + linea + ":";
        message += "\n\t" + palabra + "\n\t" + " ".repeat(index) + "^";
        message += "\nError léxico: palabra inválida";
        message += "\n\ten " + path + ":" + linea + "," + index;
        System.out.println(message);
    }
}