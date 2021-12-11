package clases.empleado;

import javax.swing.JOptionPane;

public class EmpleadoPlanilla extends Empleado{
	
	private double salarioMensual;
	private double porcentajeADicionalPorHoraExtra;
	
	
	@Override
	public void registrarDatos() {
		super.registrarDatos();
		
		try {
			salarioMensual=Double.parseDouble(JOptionPane.showInputDialog("Ingrese el salario Mensual"));
			porcentajeADicionalPorHoraExtra=Double.parseDouble(JOptionPane.showInputDialog("Ingrese el porcentaje Adicional por Hora Extra"));
		} catch (Exception e) {
			System.out.println("Debe ingresar un dato numerico en salario mensual y en porcentaje adicional");
		}
		
	}
	
	@Override
	public void imprimirDatosPersona(String datos) {
		super.imprimirDatosPersona(datos);
		
		datos="Salario mensual: "+salarioMensual+"\n";
		datos+="Porcentaje Adicional Por Hora Extra: "+porcentajeADicionalPorHoraExtra+"\n";
		
		System.out.println(datos);
	}




	public double getSalarioMensual() {
		return salarioMensual;
	}
	public void setSalarioMensual(double salarioMensual) {
		this.salarioMensual = salarioMensual;
	}
	public double getPorcentajeADicionalPorHoraExtra() {
		return porcentajeADicionalPorHoraExtra;
	}
	public void setPorcentajeADicionalPorHoraExtra(double porcentajeADicionalPorHoraExtra) {
		this.porcentajeADicionalPorHoraExtra = porcentajeADicionalPorHoraExtra;
	}
	
	
	
}
