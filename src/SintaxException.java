public class SintaxException {
    String message;

    public SintaxException(String path, int linea, int index, String palabra) {
        message = "\nError en la linea " + linea + ":";
        message += "\n\t" + palabra + "\n\t" + " ".repeat(index) + "^";
        message += "\nError sintáctico: sintáxis inválida";
        message += "\n\ten " + path + ":" + linea + "," + index;
        System.out.println(message);
    }
}