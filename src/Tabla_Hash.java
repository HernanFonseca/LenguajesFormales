//import java.util.ArrayList;
//import java.util.Arrays;

public class Tabla_Hash {
	

	public static Integer i=-1, n=-1;
	public static Integer pass = 0;
	public static String contents[][] = new String[6][4];
	//public static String Errors;								//Solo comprobación esta acción la realiza el manejador de errores

	
//  HASH METHOD
	public void SHOW_TABLE() {
		//System.out.println("i: " + i);
		if(i==0) {
			System.out.println("\nAlmacenado de datos a la tabla de símbolos\n");
			System.out.println("CLAVE:\t    |\tNOMBRE/SÍMBOLO:\t\t|\tTIPO:     \t\t|\tINSTANCIA:\t|" );
		}
		

		System.out.println("" + contents[i][3] + " \t" + contents[i][0] + "   \t\t\t" + contents[i][1] + "\t\t\t" + contents[i][2]);
		
		//if(i==5)
			//System.out.println("\n\nError Léxico en: " + Errors);
	}
	
	
//	MAIN	
	public void RECEIVE_DATA (String input, String Tipo) {
		int j, diferent = 0;
		int hashCode;

		i++;
		if(Tipo != "NULL") {
			
			for(int b= 0;b < contents.length; b++) {					//Validar si el token ya existe en la tabla
				
				if(input.equals(contents[b][0])) {
					
					diferent = 1;}
			}
			if(diferent != 1){										
				
				n++;
				for(j = 0; j<4; j++) {
				
					if(j==0) {
						contents[i][j] = input;						//Nombre
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
					}
					else if(j==2) {
						contents[i][j] = String.valueOf(n+1) ;
					}
					else if(j==3) {
						hashCode = input.hashCode();						
						contents[i][j] = Integer.toString(hashCode) ;
					}

				}
				SHOW_TABLE();
				
			}
			diferent = 0;
			
		}
		else {
			System.out.print("\t\t<<Indefinido>>\n");
			//Errors = input;
		}


	}
	
}