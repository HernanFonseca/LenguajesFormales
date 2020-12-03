package proyfinal;

import java.util.Arrays;
import javax.swing.table.DefaultTableModel;

public class Tabla_Hash 
{
	public static Integer i=-1, n=-1;
	public static Integer pass = 0;
	public static String contents[][] = new String[6][4];
        public static String orden[][] = new String [6][3];
	public static String [] array = new String[6];
	public int SizeList;
	public static int R;
	public static int posArray;
	
//	CONSTRUCTOR
	public Tabla_Hash(int size) 
	{	
		SizeList = size; 
		if(i<0)
		Arrays.fill(array, "-1");											//Permite rellenar la lista con valores iniciales en este caso -1
	}

	public void LIMIT(int size) 
	{
		if(i<0)
			R = size - 1; 
	}
        
        public void ClearOrden(){                       //Vaciar matriz orden[][]
            for(int k = 0; k<orden.length; k++)
                for(int j=0; j<orden[k].length; j++)
                    orden[k][j] = "  "; 
        }
        

//  HASH METHOD
	public void HASH_FUNCTION() 
	{																					//Recorrido por filas			
		posArray = Math.round(((float) contents[i][0].charAt(0) + (float) contents[i][0].charAt(contents[i][0].length()-1))% array.length);				//Obtención de la clave					
		while(array[posArray] != "-1")
		{	//	COLISIONS MANAGEMENT
				posArray++;
				posArray%=SizeList;																										//Saca el módulo para la proxima clave																		
		}
		array[posArray] = contents[i][0];
		contents[i][3] = Integer.toString(posArray);
	}

//	SHOW DATA TABLE	
	public void SHOW_TABLE() 
	{       int K=0;
		if(i==0) 
		{
			System.out.println("\nAlmacenado de datos a la tabla de símbolos\n");
			System.out.println("CLAVE:\t    |\tNOMBRE/SÍMBOLO:\t\t|\tTIPO:     \t\t|\tINSTANCIA:\t|" );
		}
		if(i==R) 
		{
			for(int i= 0; i<array.length; i++)
			{
				for(int j = 0; j<array.length; j++) 
				{
					if(array[i] == contents[j][0])       //Comprueba las posiciones del hash
                                        {
                                                    orden[K][0] = contents[j][0];       //Asigna el Token 
                                                    orden[K][1] = contents[j][1];       //Asigna el Tipo
                                                    orden[K][2] = contents[j][2];       //Asigna la Instancia
                                                    K++;

						System.out.println("" + contents[j][3] + " \t" + contents[j][0] + "   \t\t\t" + contents[j][1] + "\t\t\t" + contents[j][2]);
                                        }
				}
			}
                       for(int m=0; m<contents.length; m++){
                            for(int n = 0; n<contents[m].length; n++){ 
                              contents[m][n] = "  ";                    //Inicializar el contenido 
                            }
                       }
                       Arrays.fill(array, "-1");                        //Inicializa el arrays del hash a -1
                       i=-1;
                       n=-1;
                }
	}
	
//	DATA INPUT
	public void RECEIVE_DATA (String input, String Tipo) 
	{
		int j, diferent = 0;
		Tabla_Hash hash = new Tabla_Hash(6);

		i++;
		if(Tipo != "NULL") 
		{
			for(int b= 0;b < contents.length; b++) 
			{					//Validar si el token ya existe en la tabla
				if(input.equals(contents[b][0]))
				{
					diferent = 1;
				}
			}
			if(diferent != 1)
			{										
				n++;
				for(j = 0; j<4; j++) 
				{
					if(j==0) 
					{
						contents[i][j] = input;						//Nombre
					}
					else if(j==1)
					{
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
					}
					else if(j==2) 
					{
						contents[i][j] = String.valueOf(n+1) ;
					}
					else if(j==3) 
					{						
						hash.HASH_FUNCTION();
					}
				}
				SHOW_TABLE();		
			}
			diferent = 0;	
		}
	}	
}