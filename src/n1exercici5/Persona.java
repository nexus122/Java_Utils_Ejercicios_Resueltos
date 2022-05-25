package n1exercici5;

import java.io.Serializable;

public class Persona implements Serializable{
    private String nombre;
    private int edad;
    
    public Persona(String nombre,int edad) {
        this.nombre=nombre;
        this.edad=edad;
    }
    public String getNombre() {
        return nombre;
    }
	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", edad=" + edad + "]";
	}
    
}
 