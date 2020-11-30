//package project;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import proyect.App.Token;

public class Funcion_Tablahash 
{
	
	String [] array;
	int SizeList;
	int location;
	static int limit = 7;
	
     //	CONSTRUCTOR
	public Funcion_Tablahash(int size) 
	{	
		SizeList = size; 
		array = new String[size]; 
		Arrays.fill(array, "-1");											//Permite rellenar la lista con valores iniciales en este caso -1
	}
	
    //  HASH METHOD
	public void HASH_FUNCTION(String[][] arrayString, String[] array) 
	{
		int i,j;
		String content = ""; 
		String [][]element = new String[7][3];									//creación de la variable local
		System.out.println("Almacenado de datos a la tabla de símbolos\n\n");
		for (i = 0; i < arrayString.length; i ++) {								//Recorrido por filas

			for (j = 0; j < arrayString[i].length; j++){						//asignación, recorrido por columnas
				element[i][j] = arrayString[i][j];								//principal
				content = element[i][0];										//para la clave
			}
			
			int posArray = Math.round(((float) content.charAt(0) + (float) content.charAt(content.length()-1))% array.length);				//Obtención de la clave
			System.out.println("CLAVE: " + posArray + " \tNOMBRE/SÍMBOLO: " + element[i][0] + "\t\t\tTIPO: " + element[i][1] + "\t\tINSTANCIA: " + element[i][2]);

				while(array[posArray] != "-1"){								//	COLISIONS MANAGEMENT
				posArray++;
				System.out.println("\tColision en Indice: "+(posArray-1)+" se asignaría al índice: "+posArray);
				posArray%=SizeList;											//Saca el módulo para la proxima clave
																			
			}
			array[posArray] = element[i][0];
		}
	}

     //SEARCH
	public String SEARCH_KEY(String content) 
	{
		int pasArray = Math.round(((float) content.charAt(0) + (float) content.charAt(content.length()-1))% array.length);
		int n=0;
		while (array[pasArray]!="-1") 
		{	
			if ((array[pasArray]).equals(content)) 
			{
				System.out.println("\nContenido: " + content + "  Ubicación: " + pasArray);
				return array[pasArray];
			}
			pasArray++; 
			pasArray%=SizeList;
			n++;
			if (n > 9)
				break;
		}
		return null; 
	}
		
   //CODIGO DEL RECEIVE_DATA----------- TABLA DE SÍMBOLOS
   public String RECEIVE_DATA (String [] Token) 
   {
	   int i=0, j=0;
	   
	   List<Token> tokens = new ArrayList<Token>();
	   Funcion_Tablahash hash = new Funcion_Tablahash(limit);
	   Lexer analizadorLexico = new Lexer();
	   String contents[][];
	   contents = new String[7][3];

	   for (i = 0; i<contents.length; i++)                     //Asignación de valores
	   {					
			for(j = 0; j<contents[i].length; j++) 
			{
				
				if(j==0) 
				{
					contents[i][j] = Token[i];					//Nombre
				}
				else if(j==1)
				{
					String token=analizadorLexico.tokenize(Token[i]);
					//if(token!=null){
					contents[i][j]=token;					//Valor tipo
					/*}else{
					System.out.println("ERROR LÉXICO");
					tokens = new ArrayList<Token>();
					break;
					}*/
				}
				else if(j==2) 
				{
					contents[i][j] = Integer.toString(i+1) ;
				}
			}
		}
	hash.HASH_FUNCTION(contents, hash.array);
	String search = hash.SEARCH_KEY("Nombre:");
	if(search == null)
		System.out.println("Contenido no existente");
	return null;
   	}	
}
