package clases.empleado;

import javax.swing.JOptionPane;

public class EmpleadoEventual extends Empleado{
	private double honorariosPorHora;
	private String fechaTerminoContrato;
	
	
	
	
	@Override
	public void registrarDatos() {
		super.registrarDatos();
		
		try {
			honorariosPorHora=Double.parseDouble(JOptionPane.showInputDialog("Ingrese el salario Mensual"));
		} catch (Exception e) {
			System.out.println(" en honorarios por hora Debe ingresar un dato numerico");
		}
		
		fechaTerminoContrato=JOptionPane.showInputDialog("Ingrese fecha termino contrato (dd/mm/aaaa)");
	}
	
	@Override
	public void imprimirDatosPersona(String datos) {
		super.imprimirDatosPersona(datos);
		
		datos= "Honorarios Por Hora: "+honorariosPorHora+"\n";
		datos+="Fecha Termino Del contrato: "+fechaTerminoContrato+"\n";
		
		System.out.println(datos);
	}





	public double getHonorariosPorHora() {
		return honorariosPorHora;
	}
	public void setHonorariosPorHora(double honorariosPorHora) {
		this.honorariosPorHora = honorariosPorHora;
	}
	public String getFechaTerminoContrato() {
		return fechaTerminoContrato;
	}
	public void setFechaTerminoContrato(String fechaTerminoContrato) {
		this.fechaTerminoContrato = fechaTerminoContrato;
	}
	
	

}
