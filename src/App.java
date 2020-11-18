public class App {
    public static void main(String[] args) throws Exception {
        String[] lineas=new String[];
        String path ="";
        System.out.println("Hello, World!");
        ReadFile fileReader = new ReadFile();
        lineas=fileReader.readFile(path);
    }
}
