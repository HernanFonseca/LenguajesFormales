import java.util.Arrays;

public class FuncionHash 
{
    String [] array;
	int SizeList; 
	static int limit = 8;


public FuncionHash(int size) 
{	
    SizeList = size; 
    array = new String[size]; 
    Arrays.fill(array, "-1");		//Permite rellenar la lista con valores iniciales en este caso -1
}

public void HASH_FUNCTION(String[] arrayString, String[] array) 
{
    int i;
    for (i=0; i<arrayString.length; i++) 
    {	
        //Asignación de celda
        String content = arrayString[i];
        int posArray = Integer.parseInt(content)%limit; 
        System.out.println("Indice: " + posArray + " Contenido: " + content);
        
        //	COLISIONS MANAGEMENT
        while(array[posArray] != "-1") 
        {
            posArray++;
            System.out.println("Colision en Indice "+(posArray-1)+" se asignaría al índice: "+posArray);
            //System.out.println("Colisión, se asigna a la siguiente celda");
            posArray%=SizeList;
        }
        array[posArray] = content; 
    }
}

public void SHOW_LIST() 
{
    int increase = 0, i, j;
    for (i= 0; i<1; i++) 
    {
        increase +=8;
        for (j = 0; j < 71; j++) 
        {
            System.out.print("-");
        }
        System.out.println("");
        for (j = increase -8; j < increase; j++) 
        {
            System.out.format("| %3s " + " ", j);
        }
        System.out.println("|");
        for (j = 0; j < 71; j++) 
        {
            System.out.print("-");
        }
        System.out.println();
        for (j = increase -8; j < increase; j++) 
        {
            if (array[j].equals("-1"))
                System.out.print("|     ");
            else 
                System.out.print(String.format("| %3s "+" ", array[j]));
        }
        System.out.println("|");
        for (j = 0; j < 71; j++) 
        {
            System.out.print("-");
        }
        System.out.println();
    }
}
public String SEARCH_KEY(String content) 
{
    int pasArray = Integer.parseInt(content)%7;
    int n=0;
    while (array[pasArray]!="-1") 
    {
        if (array[pasArray]==content) 
        {
            System.out.println("Contenido: " + content + "  Ubicación: " + pasArray);
            return array[pasArray];
        }
        pasArray++; 
        pasArray%=SizeList;
        n++;
        if (n > 7)
            break;
    }
    return null; 
}

public static void main(String[] args) 
{
    FuncionHash hash = new FuncionHash(limit);
    String[] contents = {"20","33","21","10","12","14","56","100"};
    hash.HASH_FUNCTION(contents, hash.array);
    hash.SHOW_LIST();
    String search = hash.SEARCH_KEY("10");
    if(search == null)
        System.out.println("Contenido no existente");
}

}