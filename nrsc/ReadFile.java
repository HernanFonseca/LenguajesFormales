import java.io.File;

import java.util.*;
public class ReadFile{
    public List<String> ReadTxt(String path) {
    	int cont=0; 
    	Tabla_Hash Cnt = new Tabla_Hash(1);
        List<String> input=new ArrayList<String>();
        String [] palabras= new String[]{};
        try {
            File file = new File(path);
            Scanner reader = new Scanner(file);
            while (reader.hasNextLine()) {
                String data = reader.nextLine();
                palabras=data.split("\\s+", 2);
                for (String palabra : palabras) {
                    input.add(palabra);
                    cont++;
                }
            }
            reader.close();
            Cnt.LIMIT(cont);
        } catch (Exception e) {
            System.out.println("File not found");
            e.printStackTrace();
        }
        return input;
    }
}