import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {
        List<String> lineas=new ArrayList<String>();
        String path ="";
        System.out.println("Hello, World!");
        ReadFile fileReader = new ReadFile();
        lineas=fileReader.ReadTxt(path);
        
    }
}
