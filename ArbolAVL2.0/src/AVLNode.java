public class AVLNode<T>implements Comparable<T> {
    public T dato;      	             // el dato del nodo
    public AVLNode<T> izquierdo;        // hijo izquierdo
    public AVLNode<T> derecho;         // hijo derecho
    public int height;                // altura

    // Constructors
    public AVLNode(T dato ){
        this( dato, null, null );
    }

    public AVLNode(T dato, AVLNode<T> izq, AVLNode<T> der ){
        this.dato = dato;
        this.izquierdo = izq;
        this.derecho = der;
        height   = 0;               // altura predeterminada
    }

	@Override
	public int compareTo(T arg0) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}
}