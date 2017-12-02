import Alumno.Alumno;

public class ProbarAVLThree {

	public static void main(String[] args) {
		AVLTree<Integer> arbolAVL = new AVLTree<Integer>();
		
		AVLTree<String> nom = new AVLTree<String>();
		
		AVLTree<Alumno> alumns = new AVLTree<Alumno>();

        Integer elemento1 = new Integer("1");
        Integer elemento2 = new Integer("2");
        Integer elemento3 = new Integer("3");
        Integer elemento4 = new Integer("4");
        Integer elemento5 = new Integer("5");
        Integer elemento6 = new Integer("6");
        Integer elemento7 = new Integer("7");
        Integer elemento8 = new Integer("15");
        Integer elemento9 = new Integer("14");
        Integer elemento10 = new Integer("8");
        Integer elemento11 = new Integer("10");
        Integer elemento12 = new Integer("9");
        Integer elemento13 = new Integer("12");
        Integer elemento14 = new Integer("11");
        Integer elemento15 = new Integer("13");

        arbolAVL.insert(elemento1);
        arbolAVL.insert(elemento2);
        arbolAVL.insert(elemento3);
        arbolAVL.insert(elemento4);
        arbolAVL.insert(elemento5);
        arbolAVL.insert(elemento6);
        arbolAVL.insert(elemento7);
        arbolAVL.insert(elemento8);
        arbolAVL.insert(elemento9);
        arbolAVL.insert(elemento10);
        arbolAVL.insert(elemento11);
        arbolAVL.insert(elemento12);
        arbolAVL.insert(elemento13);
        arbolAVL.insert(elemento14);
        arbolAVL.insert(elemento15);
        arbolAVL.imprimirPorNiveles();
        
        System.out.println("\n");
        
        nom.insert("Ricardo");
        nom.insert("Alonso");
        nom.insert("Jose");
        nom.insert("Valles");
        nom.insert("Yarely");
        nom.insert("Laura");
        nom.insert("Jacqueline");
        nom.imprimirXaltura();
        
        System.out.println("\n");
        
        alumns.insert(new Alumno("Petra",8.5));
		alumns.insert(new Alumno("Konseptsion",5.0));
		alumns.insert(new Alumno("Poncho",6.0));
		alumns.insert(new Alumno("Alonso",8.0));
		alumns.insert(new Alumno("Meca",7.5));
		alumns.imprimir();
	}

}