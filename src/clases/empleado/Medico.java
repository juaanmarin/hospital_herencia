package clases.empleado;

import javax.swing.JOptionPane;

public class Medico extends EmpleadoPlanilla{
	
	private String especialidad;
	private int numeroDeConsultorio;
	
	
	public void registrarDatos() {
		super.registrarDatos();
		
		especialidad=JOptionPane.showInputDialog("Ingrese la especialidad");
		try {
			numeroDeConsultorio=Integer.parseInt(JOptionPane.showInputDialog("num consultorio"));
		} catch (Exception e) {
			System.out.println("en numero de consultorio debe ingresar un dato numerico");
		}
		
	}
	
	public String getEspecialidad() {
		return especialidad;
	}
	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}
	public int getNumeroDeConsultorio() {
		return numeroDeConsultorio;
	}
	public void setNumeroDeConsultorio(int numeroDeConsultorio) {
		this.numeroDeConsultorio = numeroDeConsultorio;
	}
	
	

}
