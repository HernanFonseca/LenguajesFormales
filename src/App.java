import java.util.*;

public class App {


    
    public static void main(String[] args) throws Exception {

        List<String> palabras=new ArrayList<String>();
        String path ="./test.txt";

        ReadFile fileReader = new ReadFile();
        palabras=fileReader.ReadTxt(path);
        System.out.println(palabras);

    }
}
