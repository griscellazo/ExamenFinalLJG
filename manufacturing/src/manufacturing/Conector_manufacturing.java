package manufacturing;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import manufacturing.Conector_manufacturing;

public class Conector_manufacturing {
	private static Connection con;
	private static Conector_manufacturing INSTANCE = null;

	private Conector_manufacturing(){ 
		
	}
	
	
	private synchronized static void crearInstancia() {
		if(INSTANCE == null) {
			INSTANCE = new Conector_manufacturing();
			crearConexion();
		}
	}
	
	public static Conector_manufacturing getInstancia() {
		if (INSTANCE == null ) {
			crearInstancia(); 
		}
		return INSTANCE;	
	}


	private static void crearConexion() {
		String host = "127.0.0.1";
		String user = "root";
		String password = "Aylin.cielito1";
		String dataBase = "manufacturing";
		try {
			// Importando la libreria de conexion de mysql
			Class.forName("com.mysql.jdbc.Driver");
			// Url de conexion
			String urlConexion = "jdbc:mysql://"+host+"/"+dataBase+"?user="+user+"&password="+password;
			con = DriverManager.getConnection(urlConexion);
			System.out.println("Estas conectado a la Base de Datos");
			
		}catch (Exception e) {
			System.out.println("Error al conectar a la base de datos");
		}
	}
	//-------------------------- Ejercicio 1-----------------------------
	public ArrayList<String> getVendors() throws SQLException {
		ArrayList<String> listaVendors = new ArrayList<String>(); 
		PreparedStatement ps = con.prepareStatement("select distinct name\r\n" + 
				"from clients\r\n" + 
				"inner join orders on clients.username = orders.clientusername and orders.status = 'Done'");
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			listaVendors.add(rs.getString("Name"));
		}
		rs.close();
		return listaVendors;	
	}
	//-------------------------- Ejercicio 2-----------------------------
	public ArrayList<String> getCostoYTrans() throws SQLException {
		ArrayList<String> listaCostoYTrans= new ArrayList<String>(); 
		PreparedStatement ps = con.prepareStatement("select name, modeoftransport, cost\r\n" + 
				"from clients \r\n" + 
				"inner join delivery on clients.username = delivery.clntusername\r\n" + 
				"inner join product on delivery.item = producttype\r\n" + 
				"where clients.name ='New Client 1'");
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			listaCostoYTrans.add(rs.getString ("name") + " " +rs.getString("modeoftransport")+" "+ rs.getString("cost"));
		}
		rs.close();
		return listaCostoYTrans;
	}

	//-------------------------- Ejercicio 3-----------------------------
	public ArrayList<String> getEmpleados() throws SQLException {
		ArrayList<String> listaEmpleados= new ArrayList<String>(); 
		PreparedStatement ps = con.prepareStatement(
				"select distinct email\r\n" + 
				"from employee\r\n" + 
				"left join attendance on employee.username = attendance.empusername\r\n" + 
				"where attendance.value is null");
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			listaEmpleados.add(rs.getString("email"));
		}
		rs.close();
		return listaEmpleados;
}
}
