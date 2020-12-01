import java.io.File;

import java.util.*;

public class ReadFile {
    List<String> content = new ArrayList<>();

    public List<Palabra> ReadTxt(String path) 
    {
        List<Palabra> input = new ArrayList<>();
        String [] palabras = new String[]{};
        
        try {
            File file = new File(path);
            Scanner reader = new Scanner(file);
            int linea = 1;
            while (reader.hasNextLine()) {
                String data = reader.nextLine();
                content.add(data);
                palabras = data.split("\\s+", 2);
                for (String palabra : palabras) {
                    input.add(new Palabra(palabra, linea, data.indexOf(palabra)));
                }
                linea++;
            }
            reader.close();
        } catch (Exception e) {
            System.out.println("File not found");
            e.printStackTrace();
        }
        return input;
    }

    public String getContent(int linea) {
        return content.get(linea);
    }
}