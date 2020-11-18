
import java.util.regex.*;

import java.util.*;

public class App {

    public static void main(String[] args) throws Exception {

        

            String pattern = "[a-z]{1}[a-z|0-9|_|-]*[@]" + ".*(hotmail|gmail|outlook|yahoo).*{1}[.]" + ".*(es|com|net|org|edu).*{1}";
            boolean matches = Pattern.matches(pattern, "edulinaro@gmail.com");
            System.out.println(matches);



        List<String> palabras=new ArrayList<String>();
        String path ="./test.txt";

        ReadFile fileReader = new ReadFile();
        palabras=fileReader.ReadTxt(path);
        System.out.println(palabras);

    }
}
