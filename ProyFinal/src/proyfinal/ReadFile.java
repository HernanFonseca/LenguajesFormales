package proyfinal;
import java.util.*;

public class ReadFile {
    List<String> content = new ArrayList<>();

    public List<Palabra> ReadTxt(String text) 
    {
        int cont=0;
        Tabla_Hash Cnt = new Tabla_Hash(1);
        List<Palabra> input = new ArrayList<>();
        String [] palabras = new String[]{};
        
        try {
            Scanner reader = new Scanner(text);
            int linea = 1;
            while (reader.hasNextLine()) 
            {
                String data = reader.nextLine();
                content.add(data);
                palabras = data.split("\\s+", 2);
                for (String palabra : palabras) 
                {
                    input.add(new Palabra(palabra, linea, data.indexOf(palabra)));
                    cont++; 
                }
                linea++;
            }
            reader.close();
            Cnt.LIMIT(cont);
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