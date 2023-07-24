package ec.edu.intsuperior.modelo;
import java.sql.*;


public class conexion {

    String bd = "arduino_java";
    String url = "jdbc:mysql://localhost/" + bd;
    String user = "David";
    String password = "1751531466";
    String driver = "com.mysql.cj.jdbc.Driver";
    Connection cx;

    public conexion() {
    }

    public Connection obtenerConexion() {
        try {

            Class.forName(driver);
            cx = DriverManager.getConnection(this.url, this.user, this.password);
            
            System.out.println("Conectado a la BD");

        } catch (ClassNotFoundException | SQLException ex) {

            System.out.println("No se conecto a BD");
            //Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cx;

    }

//    public static void main(String[] args) {
//        conexion conexion = new conexion();
//        conexion.obtenerConexion();
//    }

}
