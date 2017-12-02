public class AVLTree<T extends Comparable<T>> implements Comparable<T> {
    private AVLNode<T> root;

    public void insert(T x ){
        root = insert( x, root );
    }

    /*
     * x es una instancia de una clase que implementa Comparable
    */
    private AVLNode<T> insert(T x, AVLNode<T> t ){
        if( t == null )
            t = new AVLNode<T>( x, null, null );
        else if( x.compareTo( (T) t.dato ) <= 0 ) {
            t.izquierdo = insert( x, t.izquierdo );
            if( height( t.izquierdo ) - height( t.derecho ) == 2 )
                if( x.compareTo( (T) t.izquierdo.dato ) <= 0 )
                    t = rotateWithLeftChild( t ); /* Caso 1 */
                else
                    t = doubleWithLeftChild( t ); /* Caso 2 */
        }
        else if( x.compareTo( (T) t.dato ) >= 0 ) {
            t.derecho = insert( x, t.derecho );
            if( height( t.derecho ) - height( t.izquierdo ) == 2 )
                if( x.compareTo( (T) t.derecho.dato ) > 0 )
                    t = rotateWithRightChild( t ); /* Caso 4 */
                else
                    t = doubleWithRightChild( t ); /* Caso 3 */
        }
        else
            ; // Duplicado; no hago nada
        t.height = max( height( t.izquierdo ), height( t.derecho ) ) + 1;
        return t;
    }


    private static int max( int lhs, int rhs ){
        return lhs > rhs ? lhs : rhs;
    }


    private AVLNode<T> rotateWithLeftChild( AVLNode<T> k2 ){
    	AVLNode<T> k1 = k2.izquierdo;
        k2.izquierdo = k1.derecho;
        k1.derecho = k2;
        k2.height = max( height(k2.izquierdo), height(k2.derecho)) + 1;
        k1.height = max( height( k1.izquierdo ), k2.height ) + 1;
        return k1;
    }


    private AVLNode<T> rotateWithRightChild( AVLNode<T> k1 ){
    	AVLNode<T> k2 = k1.derecho;
        k1.derecho = k2.izquierdo;
        k2.izquierdo = k1;
        k1.height = max( height(k1.izquierdo), height(k1.derecho) ) + 1;
        k2.height = max( height( k2.derecho ), k1.height ) + 1;
        return k2;
    }


    private AVLNode<T> doubleWithLeftChild( AVLNode<T> k3 ){
        k3.izquierdo = rotateWithRightChild( k3.izquierdo );
        return rotateWithLeftChild( k3 );
    }


    private AVLNode<T> doubleWithRightChild( AVLNode<T> k1 ){
        k1.derecho = rotateWithLeftChild( k1.derecho );
        return rotateWithRightChild( k1 );
    }


    private int height( AVLNode<T> t ){
        return t == null ? -1 : t.height;
    }

    /*
     * Imprime el arbol con el recorrido InOrden
     */
    public void imprimir(){
        imprimir(root);
    }

    private void imprimir(AVLNode<T> nodo){
        if ( nodo != null ){
            imprimir(nodo.derecho);
            System.out.println("["+ nodo.dato + "]");
            imprimir(nodo.izquierdo);
        }
    }

    public void imprimirXaltura(){
        imprimirXaltura ( root );
    }

    /*
     * Imprime cada nodo linea por linea. Recorriendo el arbol desde
     * el Nodo más a la derecha hasta el nodo más a la izquierda,
     * y dejando una identacion de varios espacios en blanco segun su
     * altura en el arbol
     */
    private void imprimirXaltura(AVLNode<T> nodo){
        if ( nodo != null ){
            imprimirXaltura(nodo.derecho);
            System.out.println( replicate(" ",height(root) - height(nodo)) +"["+ nodo.dato + "]");
            imprimirXaltura(nodo.izquierdo);
        }
    }

    /*
     * Metodo estatico auxiliar que dada una cadena a y un enterto cnt
     * replica o concatena esa cadena a, cnt veces
     */
    private String replicate (String a, int cnt){
        String x = new String("");

        for ( int i = 0; i < cnt; i++ )
            x = x + a;
        return x;
    }

    /*
    * Obtiene la altura del arbol AVL
    */
    public int calcularAltura(){
        return calcularAltura(root);
    }

    private int calcularAltura(AVLNode<T> actual ){
       if (actual == null)
            return -1;
       else
            return 1 + Math.max(calcularAltura(actual.izquierdo), calcularAltura(actual.derecho));
    }

    // Imprime el arbol por niveles. Comienza por la raiz.
    public void imprimirPorNiveles(){
        imprimirPorNiveles(root);
    }

    // Imprime el arbol por niveles.
    @SuppressWarnings("unchecked")
	private void imprimirPorNiveles(AVLNode<T> nodo){
        // Mediante la altura calcula el total de nodos posibles del árbol
        // Y crea una array cola con ese tamaño
        int max = 0;
        int nivel = calcularAltura();

        for ( ; nivel >= 0; nivel--)
            max += Math.pow(2, nivel);
        max++;      // Suma 1 para no utilizar la posicion 0 del array

        AVLNode<T> cola[] = new AVLNode[ max ];

        // Carga en la pos 1 el nodo raiz
        cola[1] = nodo;
        int x = 1;

        // Carga los demas elementos del arbol,
        // Carga null en izq y der si el nodo es null
        // i aumenta de a 2 por q carga en izq y der los hijos
        // x aumenta 1, que son los nodos raiz - padre
        for (int i = 2; i < max; i += 2, x++){
            if (cola[x] == null){
                cola[i] = null;
                cola[i + 1] = null;
            }
            else{
                cola[i]   = cola[x].izquierdo;
                cola[i + 1] = cola[x].derecho;
            }
        }
        nivel = 0;
        int cont = 0;                       // contador para cada nivel
        int cantidad = 1;                   // cantidad de nodos por nivel
        int ultimaPosicion = 1;             // ultimaPosicion del nodo en la cola de cada nivel

        // Cuando i es = a 2^nivel hay cambio de nivel
        // 2 ^ 0 = 1 que es el nodo raiz
        for (int i = 1; i < max; i++){
            if(i == Math.pow(2, nivel)){
            	// Nodo raiz tiene nivel 1, por eso (nivel + 1)
            	System.out.print("\n Nivel " + (nivel) + ": ");
                nivel++;
            }
            if( cola[i] != null ){
                System.out.print("[" + cola[i].dato + "]");
                cont++;
            }
            if(ultimaPosicion == i  && cantidad == Math.pow(2, --nivel)){
                if(cantidad == 1)
                    System.out.print(" Cantidad de nodos: " + cont + " (raiz)");
                else
                    System.out.print(" Cantidad de nodos: " +  cont);
                cont = 0;
                cantidad *= 2;
                ultimaPosicion += (int)Math.pow(2, ++nivel);
            }
        }
    }

	@Override
	public int compareTo(T o) {
		// TODO Auto-generated method stub
		return 0;
	}
}