//import java.util.ArrayList;
import java.util.Arrays;

public class Tabla_Hash {
	
	String [] array;
	int SizeList;
	public static Integer i=-1; 
	static int limit = 7;
	public static String contents[][] = new String[7][4];

	
//	CONSTRUCTOR
	public Tabla_Hash(int size) {	
		SizeList = size; 
		array = new String[size]; 
		Arrays.fill(array, "-1");											//Permite rellenar la lista con valores iniciales en este caso -1
	}

	
//  HASH METHOD
	public void HASH_FUNCTION(String[][] arrayString, String[] array) {
		int i,j;
		String content = ""; 
		String [][]element = new String[7][4];									//creación de la variable local
		System.out.println("\nAlmacenado de datos a la tabla de símbolos\n");
		System.out.println("CLAVE:   \tNOMBRE/SÍMBOLO: \t\t\tTIPO:   \t\tINSTANCIA: " );
		for (i = 0; i < arrayString.length; i ++) {								//Recorrido por filas
			
			for (j = 0; j < arrayString[i].length; j++){						//asignación, recorrido por columnas
				element[i][j] = arrayString[i][j];								//principal
				content = element[i][0];										//para la clave
			}

			int posArray = Math.round(((float) content.charAt(0) + (float) content.charAt(content.length()-1))% array.length);				//Obtención de la clave
			System.out.println("\t" + (contents[i][3]=Integer.toString(posArray)) + " \t" + element[i][0] + "  \t\t\t" + element[i][1] + "\t\t\t" + element[i][2]);

				while(array[posArray] != "-1"){								//	COLISIONS MANAGEMENT
				posArray++;
				//System.out.println("\t\tColision en Indice: "+(posArray-1)+" se asignaría al índice: "+posArray);		//Muestra las colisiones en consola
				posArray%=SizeList;											//Saca el módulo para la proxima clave
																			
			}
			array[posArray] = element[i][0];
		}
	}
	

//SEARCH
	public String SEARCH_KEY(String content) {
		int pasArray = Math.round(((float) content.charAt(0) + (float) content.charAt(content.length()-1))% array.length);
		int n=0;
		while (array[pasArray]!="-1") {
			
			if ((array[pasArray]).equals(content)) {
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
	
	
//	MAIN	
	public void RECEIVE_DATA (String input, String Tipo) {
		int j, a;
		//List<Token> tokens = new ArrayList<Token>();
		Tabla_Hash hash = new Tabla_Hash(limit);
		i++;
		a = i; 

			for(j = 0; j<3; j++) {
				
				if(j==0) {
					contents[i][j] = input;						//Nombre
					//System.out.println(contents[i][j]);
				}
				else if(j==1){

		            if(Tipo =="NOMBRE") 
		            	contents[i][j]="reservadaNombre";
		            else if(Tipo == "EMAIL")
		            	contents[i][j]="reservadaMail";
		            else if(Tipo == "TELEFONO") 
		            	contents[i][j]="reservadaNum";
		            else if(Tipo == "CONTNOMBRE") 
		            	contents[i][j]="contenidoNombre";
		            else if (Tipo =="CONTEMAIL") 
		            	contents[i][j]="contenidoMail";
		            else if (Tipo =="CONTTELEFONO") 
		            	contents[i][j]="contenidoNum";
		            break;
				}
				else if(j==2) {
					contents[i][j] = String.valueOf(a+1) ;
				}

			}

		if (i == 6) 
			hash.HASH_FUNCTION(contents, hash.array);
		//String search = hash.SEARCH_KEY("Nombre:");						//Permite buscar un token en particular y ubicarlo. 
		//if(search == null)
			//System.out.println("Contenido no existente");
	}
	
}