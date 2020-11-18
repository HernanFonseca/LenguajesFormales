import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadFile{
    public public static String[] ReadTxt(String path) {
        String[] input=new ArrayList<String>;

        try {
            File file = new File(path);
            Scanner reader = new Scanner(file);
            while (reader.hasNextLine()) {
                String data = reader.nextLine();
                input.add(data);
            }
        } catch (Exception e) {
            System.out.println("File not found");
            e.printStackTrace();
        }
    }
}