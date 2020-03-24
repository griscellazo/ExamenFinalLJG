package manufacturing;

import java.sql.SQLException;
import java.util.ArrayList;

public class Main_manufacturing {


		public static void main(String[] args) {
			// TODO Auto-generated method stub
			System.out.println("---------------Ejercicio 1------------------");
			System.out.println("Mostrar el nombre del cliente con ordenes en status done"); 
			Conector_manufacturing instancia = Conector_manufacturing.getInstancia();
			try{
			ArrayList<String> listaVendors = instancia.getVendors();
			for (String name:listaVendors) {
				System.out.println(name);
				
			}
			}catch(SQLException e) {
				e.printStackTrace();
				
			}
			System.out.println("---------------Ejercicio 2-----------------"); 
			System.out.println("Mostrar el costo y tipo de transporte  de las ordenes de cliente con nombre 'x'"); 
			try{
				ArrayList<String> listaCostoYTrans = instancia.getCostoYTrans();
				for (String CostoYTrans:listaCostoYTrans) {
					System.out.println(CostoYTrans);
					
				}
				}catch(SQLException e) {
					e.printStackTrace();
					
				}
			System.out.println("---------------Ejercicio 3-----------------"); 
			System.out.println("Mostrar los emails de los empleados sin asistencia "); 
			try{
				ArrayList<String> listaEmpleados = instancia.getEmpleados();
				for (String empleados:listaEmpleados) {
					System.out.println(empleados);
					
				}
				}catch(SQLException e) {
					e.printStackTrace();
					
				}
		}
		}

	
