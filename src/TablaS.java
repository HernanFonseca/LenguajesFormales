public class TablaS{

    private Nodo[] casillas;

    public TablaS(int numeroCasillas) {
        casillas = new Nodo[numeroCasillas];
        
    }

    public Nodo[] getCasillas() {
        return casillas;
    }
    
    public int algoritmoHash1 (String string){
        return Math.round(((float) string.charAt(0) + (float) string.charAt(string.length()-1))% casillas.length);
    }
    
    public void insertarNodo(String string){
        int posicion = algoritmoHash1(string);
        System.out.print(string + " sera insertado en la posicion " + posicion);
        if (casillas[posicion] == null){
            casillas[posicion] = new Nodo(string);
        }
        else {
            System.out.print("\tHubo colision ");
            colision(posicion, string);
        }
        System.out.println();
    }
    
    public void colision(int posicion, String string){
        Nodo nodo = ultimoNodo(casillas[posicion]);
        nodo.setSiguiente(new Nodo(string));
    }
    
    public Nodo ultimoNodo(Nodo nodo){
        while(true){
            if (nodo.getSiguiente() != null){
                nodo = nodo.getSiguiente();
            }
            else 
                break;
        }
        return nodo;
    }
    
    public int contarColisionesCasilla(Nodo nodo){
        if (nodo == null)
            return 0;
        int n = 0;
        while (true){
            if (nodo.getSiguiente() != null){
                n++;
                nodo = nodo.getSiguiente();
            }else
                break;
        }
        return n; 
    }
    
    public int contarColisiones(){
        int n = 0;
        for (Nodo nodo : casillas){
            n += contarColisionesCasilla(nodo);
        }
        return n;
    }
    
    public void verTabla(){
        for (Nodo nodo : casillas){
            if (nodo != null){
                System.out.println(nodo.getDato());
                while (nodo.getSiguiente() != null){
                    nodo = nodo.getSiguiente();
                    System.out.println("\t" + nodo.getDato());
                }
            }
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Simbolo    Tipo    Valor   *
        
        TablaS tabla = new TablaS(10);
        System.out.println("Inserciones");
        tabla.insertarNodo("primero");
        tabla.insertarNodo("segundo");
        tabla.insertarNodo("tercero");
        tabla.insertarNodo("cuarto");
        tabla.insertarNodo("quinto");
        tabla.insertarNodo("sexto");
        tabla.insertarNodo("septimo");
        tabla.insertarNodo("octavo");
        tabla.insertarNodo("noveno");
        tabla.insertarNodo("decimo");
        System.out.println();        
        System.out.println("Ver Tabla");
        tabla.verTabla();
        System.out.println("Numero de colisiones: " + tabla.contarColisiones());
    }
}