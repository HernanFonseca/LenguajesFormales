import java.io.File;

import java.util.*;
public class ReadFile{
    public List<String> ReadTxt(String path) {
        List<String> input=new ArrayList<String>();
        String [] palabras= new String[]{};
        try {
            File file = new File(path);
            Scanner reader = new Scanner(file);
            while (reader.hasNextLine()) {
                String data = reader.nextLine();
                palabras=data.split(" ");
                for (String palabra : palabras) {
                    input.add(palabra);
                }
            }
            reader.close();
        } catch (Exception e) {
            System.out.println("File not found");
            e.printStackTrace();
        }
        return input;
    }
}