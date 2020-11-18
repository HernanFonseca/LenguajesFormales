public class App {
    public static void main(String[] args) throws Exception {
        String[] lineas=new String[];
        System.out.println("Hello, World!");
        ReadFile fileReader = new ReadFile();
        lineas=fileReader.readFile(path);
    }
}
