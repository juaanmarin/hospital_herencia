package clases;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import clases.empleado.EmpleadoEventual;
import clases.empleado.EmpleadoPlanilla;
import clases.empleado.Medico;

public class ModeloDatos {
	
	HashMap<String, Paciente> pacientesMap;
	HashMap<String, EmpleadoPlanilla> empleadoPlanillaMap;
	HashMap<String, EmpleadoEventual> empleadoEventualMap;
	HashMap<String, Medico> medicosMap;
	ArrayList<CitaMedica> citasList;
	
	public ModeloDatos() {
		pacientesMap=new HashMap<String, Paciente>();
		empleadoPlanillaMap=new HashMap<String, EmpleadoPlanilla>();
		medicosMap=new  HashMap<String, Medico>();
		empleadoEventualMap=new HashMap<String, EmpleadoEventual>();
		citasList=new ArrayList<CitaMedica>();
	}
	
	public void registrarPersona(Paciente miPaciente) {
		String igual=" ";
		for (String paciente : pacientesMap.keySet()) {
			if (paciente.equals(miPaciente.getNumeroDeDNI())) {
				igual="true";
			}
		}
		if (igual.equalsIgnoreCase("true")) {
			System.out.println("El paciente ya fue registrado");
		}else {
		pacientesMap.put(miPaciente.getNumeroDeDNI(), miPaciente);
		System.out.println("Se ha registrado el paciente "+miPaciente.getNombre()+" satisfactoriamente");
			}
		}

	
	public void registrarPersona(EmpleadoPlanilla miEmpPlanilla) {
		String igual="";
		for (String empleadoPlanilla : empleadoPlanillaMap.keySet()) {
			if (empleadoPlanilla.equals(miEmpPlanilla.getNumeroDeDNI())) {
				igual="true";
			}
		}
		if (igual.equalsIgnoreCase("true")) {
			System.out.println("El empleado por planilla ya se encuentra registrado");
		}else {
		empleadoPlanillaMap.put(miEmpPlanilla.getNumeroDeDNI(), miEmpPlanilla);
		System.out.println("Se ha registrado el empleado por planilla "+miEmpPlanilla.getNombre()+" satisfactoriamente");
		}
	}
	
	public void registrarPersona(EmpleadoEventual miEmpEventual) {
		String igual="";
		for (String empleadoEventual : empleadoEventualMap.keySet()) {
			if (empleadoEventual.equals(miEmpEventual.getNumeroDeDNI())) {
				igual="true";
			}
		}
		if (igual.equalsIgnoreCase("true")) {
			System.out.println("El empleado Eventual ya se encuentra registrado");
		}else {
		empleadoEventualMap.put(miEmpEventual.getNumeroDeDNI(), miEmpEventual);
		System.out.println("Se ha registrado el empleado eventual "+miEmpEventual.getNombre()+" satisfactoriamente");
		}
	}
	
	public void registrarPersona(Medico miMedico) {
		String igual="";
		for (String medico : medicosMap.keySet()) {
			if (medico.equals(miMedico.getNumeroDeDNI())) {
				igual="true";
			}
		}
		if (igual.equalsIgnoreCase("true")) {
			System.out.println("El medico  ya se encuentra registrado");
		}else {
		medicosMap.put(miMedico.getNumeroDeDNI(), miMedico);
		System.out.println("Se ha registrado el medico "+miMedico.getNombre()+" satisfactoriamente");
		}
	}
	
	public void imprimirPacientes() {
		if (pacientesMap.size()>0) {
			String msj="PACIENTES REGISTRADOS\n";
			Iterator<String> iterador=pacientesMap.keySet().iterator();
			
			while (iterador.hasNext()) {
				String clave = iterador.next();
				pacientesMap.get(clave).imprimirDatosPersona(msj);
				
			}
			
			}else {
				System.out.println("No hay pacientes registrados");
		}
		
		}
	
	public void imprimirEmpleadosEventuales() {
		if (empleadoEventualMap.size()>0) {
			String msj="EMPLEADOS EVENTUALES REGISTRADOS\n";
			
			for (String clave :  empleadoEventualMap.keySet()) {
				empleadoEventualMap.get(clave).imprimirDatosPersona(msj);
			}
		}else {
			System.out.println("No hay empleados eventuales registrados");
		}
	}
	
	
	public void imprimirEmpleadosPorPlanilla() {
		if (empleadoPlanillaMap.size()>0 || medicosMap.size()>0) {
			String msj="EMPLEADOS POR PLANILLA REGISTRADOS\n";
			if (empleadoPlanillaMap.size()==0) {
				System.out.println("EMPLEADOS POR PLANILLA REGISTRADOS\n");
			}
			for (EmpleadoPlanilla empleadoPlanilla : empleadoPlanillaMap.values()) {
				empleadoPlanilla.imprimirDatosPersona(msj);
			}
			imprimirMedicos();
			
		}else {
			System.out.println("No hay empleados por planilla registrados");
		}
		
	}
	
	public void imprimirMedicos() {
		if (medicosMap.size()>0) {
			String msj="MEDICOS REGISTRADOS\n";
			
			for (Map.Entry<String, Medico> elemento : medicosMap.entrySet()) {
		
				elemento.getValue().imprimirDatosPersona(msj);
			}
		}else {
			System.out.println("No hay medicos registrados");
		}
	}
	
	public Medico consultarMedicoPorNombre(String nombreMedico) {
		for (Medico medico : medicosMap.values()) {
			
			if (medico.getNombre().equalsIgnoreCase(nombreMedico)) {
				return medico;
			}
		}
		return null;
	}
	
	public Paciente consultarPacientePorDocumento(String documentoPaciente) {
		Paciente miPaciente=null;
		
		if (pacientesMap.containsKey(documentoPaciente)) {
			miPaciente=pacientesMap.get(documentoPaciente);
		}
		
		return miPaciente;
	}
	

	
	public void registrarCitaMedica(CitaMedica miCita) {
		citasList.add(miCita);
		System.out.println("Se ha registrado la cita Exitosamente\n");
		System.out.println(miCita.informacionCitaMedica());
	}
	

	public void imprimirCitasMedicasProgramadas() {
		String msj="CITAS MEDICAS PROGRAMADAS\n";
		CitaMedica miCita=null;
		
		System.out.println(msj+"\n");
		
		if (citasList.size()>0) {
			for (int i=0; i<citasList.size(); i++) {
				miCita=citasList.get(i);
				System.out.println(miCita.informacionCitaMedica());
			}
		}else {
			System.out.println("No existen citas programadas");
		}
		
	}
	
	public void imprimirPaciente(String documentoPaciente) {
		if (pacientesMap.size()>0) {
			if (pacientesMap.containsKey(documentoPaciente)) {
				pacientesMap.get(documentoPaciente).imprimirDatosPersona(documentoPaciente);
				
				}else {
					System.out.println("El documento no se encuentra registrado");
				}
			
				
		}else {
			System.out.println("No hay pacientes registrados");
					
			}
		}
	
	public void imprimirEmpleadoPlanilla(String documentoEmpleadoplanilla) {
		if (empleadoPlanillaMap.size()>0) {
			if (empleadoPlanillaMap.containsKey(documentoEmpleadoplanilla)) {
				empleadoPlanillaMap.get(documentoEmpleadoplanilla).imprimirDatosPersona(documentoEmpleadoplanilla);
				
				}else {
					System.out.println("El documento no se encuentra registrado");
				}
		}else {
			System.out.println("No hay Empleados Planilla registrados");
					
			}
		}
	
	public void imprimirEmpleadoEventual(String documentoEmpleadoEventual) {
		if (empleadoEventualMap.size()>0) {
			if (empleadoEventualMap.containsKey(documentoEmpleadoEventual)) {
				empleadoEventualMap.get(documentoEmpleadoEventual).imprimirDatosPersona(documentoEmpleadoEventual);
				
				}else {
					System.out.println("El documento no se encuentra registrado");
				}
		}else {
			System.out.println("No hay Empleados Eventuales registrados");
					
			}
		}
	
	public void imprimirMedico(String documentoMedico) {
		if (medicosMap.size()>0) {
			if (medicosMap.containsKey(documentoMedico)) {
				medicosMap.get(documentoMedico).imprimirDatosPersona(documentoMedico);
				
				}else {
					System.out.println("El documento no se encuentra registrado");
				}
		}else {
			System.out.println("No hay medicos registrados");
					
			}
		}
	
	
}

