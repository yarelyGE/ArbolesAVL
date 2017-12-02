package Alumno;
import java.util.Comparator;

public class Alumno implements Comparable<Alumno>, Comparator<Alumno>{
	
	String nombre = null;
	double promedio = 0.0d;
	
	public Alumno(String nom, Double prom){
		this.nombre = nom;
		this.promedio = prom;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getPromedio() {
		return promedio;
	}
	public void setPromedio(double promedio) {
		this.promedio = promedio;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Nombre: " + this.nombre + " Promedio: " + this.promedio;
	}
	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}
	@Override
	public int compare(Alumno o1, Alumno o2) {
		return 0;
	}
	@Override
	public int compareTo(Alumno o) {
		if(this.promedio == o.promedio) return 0;
		else if (this.promedio > o.promedio) return 1;
		return -1;
	}
}