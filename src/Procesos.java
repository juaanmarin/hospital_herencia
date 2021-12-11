import javax.swing.JOptionPane;

import clases.CitaMedica;
import clases.ModeloDatos;
import clases.Paciente;
import clases.empleado.EmpleadoEventual;
import clases.empleado.EmpleadoPlanilla;
import clases.empleado.Medico;

public class Procesos {
	
	ModeloDatos miModeloDatos;
	
	public Procesos() {
		miModeloDatos=new ModeloDatos();
		presentarMenuOpciones();
	}
	
	private void presentarMenuOpciones() {
		
		String menu="MENU HOSPITAL\n\n";
		menu+="1. Registrar Pacientes\n";
		menu+="2. Registrar Empleado\n";
		menu+="3. Registrar cita Medica\n";
		menu+="4. Imprimir Informacion\n";
		menu+="5. Salir\n";
		menu+="Ingrese una Opcion\n";
		
		int opcion=0;
		
		do {
			opcion=Integer.parseInt(JOptionPane.showInputDialog(menu));
			switch (opcion) {
			case 1: registrarPaciente();      break;
			case 2: registrarEmpleado();      break;
			case 3: registrarCitaMedica();      break;
			case 4: imprimirInformacion();      break;
			case 5: System.out.println("El sistema ha terminado!");   break;
			default: System.out.println("No existe el codigo, verifique nuevamente");
				break;
			}
		} while (opcion!=5);
	}

	private void registrarPaciente() {
		Paciente miPaciente=new Paciente();
		miPaciente.registrarDatos();
		
		miModeloDatos.registrarPersona(miPaciente);	
	}
	

	private void registrarEmpleado() {
		String menuTipoEmpleado="Registro de Empleado\n";
		menuTipoEmpleado+="1. Empleado Eventual\n";
		menuTipoEmpleado+="2. Empleado Por Planilla\n";
		menuTipoEmpleado+="Seleccione el tipo de empleado a registrar\n";
		
		int tipoEmpleado=Integer.parseInt(JOptionPane.showInputDialog(menuTipoEmpleado));
		
		switch (tipoEmpleado) {
		case 1:
			EmpleadoEventual miEmpleadoEventual=new EmpleadoEventual();
			miEmpleadoEventual.registrarDatos();
			miModeloDatos.registrarPersona(miEmpleadoEventual);			
			break;
		case 2:
			String resp=JOptionPane.showInputDialog("Ingrese si, si es un medico, de lo contrario es otro tipo de empleado");
			if (resp.equalsIgnoreCase("si")) {
				Medico miMedico=new Medico();
				miMedico.registrarDatos();
				miModeloDatos.registrarPersona(miMedico);
			}else {
				EmpleadoPlanilla miEmpleadoPlanilla=new EmpleadoPlanilla();
				miEmpleadoPlanilla.registrarDatos();
				miModeloDatos.registrarPersona(miEmpleadoPlanilla);
			}
			break;

		default: System.out.println("El tipo de empleado no es valido, intentelo nuevamente");
			break;
		}
		
	}

	
	private void imprimirInformacion() {
		
		String menuImprimir=" MENU IMPRESIONES\n";
		menuImprimir+="1. Listar Pacientes\n";
		menuImprimir+="2. Listar Empleados Eventuales\n";
		menuImprimir+="3. Listar Empleados Por Planilla\n";
		menuImprimir+="4. Listar Medicos\n";
		menuImprimir+="5. Listar citas medicas programadas\n";
		menuImprimir+="6. Buscar por documento\n\n";
		menuImprimir+="Ingrese una opcion\n";
		
		System.out.println("**********************************************");
		
		int opcion=Integer.parseInt(JOptionPane.showInputDialog(menuImprimir));
		
		switch (opcion) {
		case 1: miModeloDatos.imprimirPacientes(); break;
		case 2: miModeloDatos.imprimirEmpleadosEventuales(); break;
		case 3: miModeloDatos.imprimirEmpleadosPorPlanilla(); break;
		case 4: miModeloDatos.imprimirMedicos(); break;
		case 5: miModeloDatos.imprimirCitasMedicasProgramadas(); break;
		case 6: menuBusqueda(); break;
			
		default: System.out.println("No existe esa opcion");
			break;
		}
	}
	
	private void menuBusqueda() {
		String cad="QUE DESEA BUSCAR\n";
		cad+="1. pacientes\n";
		cad+="2. Empleado por Planilla\n";
		cad+="3. Empleado Eventual\n";
		cad+="4. Medicos\n\n";
		cad+="Elija una opcion de busqueda\n";
		
		int cod=Integer.parseInt(JOptionPane.showInputDialog(cad));
		switch (cod) {
		case 1: String documentoPaciente=JOptionPane.showInputDialog("ingrese el documento del paciente a buscar");
			miModeloDatos.imprimirPaciente(documentoPaciente);	
			break;
			
		case 2: String documentoEmpleadoPlanilla=JOptionPane.showInputDialog("ingrese el documento del empleado por planilla a buscar");
			miModeloDatos.imprimirEmpleadoPlanilla(documentoEmpleadoPlanilla);	
			break;
			
		case 3: String documentoEmpleadoEventual=JOptionPane.showInputDialog("ingrese el documento del empleado eventual a buscar");
		miModeloDatos.imprimirEmpleadoEventual(documentoEmpleadoEventual);	
		break;
		
		case 4: String documentoMedico=JOptionPane.showInputDialog("ingrese el documento del medico a buscar");
		miModeloDatos.imprimirMedico(documentoMedico);	
		break;
		

		default: System.out.println("codigo invalido");
			break;
		}
	}
	


	private void registrarCitaMedica() {
		String documentoPaciente=JOptionPane.showInputDialog("Ingrese el documento del paciente");
		
		Paciente pacienteEncontrado=miModeloDatos.consultarPacientePorDocumento(documentoPaciente);
		
		if (pacienteEncontrado!=null) {
			String nombreMedico=JOptionPane.showInputDialog("Ingrese el nombre del medico");
			Medico medicoEncontrado=miModeloDatos.consultarMedicoPorNombre(nombreMedico);
			
			if (medicoEncontrado!=null) {
				String servicios=JOptionPane.showInputDialog("Ingrese el servicio o motivo de la consulta");
				String fechaConsulta=JOptionPane.showInputDialog("Ingrese la fecha de la consulta");
				String horaConsulta=JOptionPane.showInputDialog("Ingrese la hora de la consulta");
				
				String lugar="La cita sera en el consultorio "+medicoEncontrado.getNumeroDeConsultorio();
				CitaMedica miCita=new CitaMedica(pacienteEncontrado, medicoEncontrado, servicios, fechaConsulta, horaConsulta, lugar);
				miModeloDatos.registrarCitaMedica(miCita);
			}else {
				System.out.println("El medico no se encuentra registrado en el sistema");
			}
		}else {
			System.out.println("El paciente no se encuentra registrado en el sistema");
		}
	}
	
	
}
