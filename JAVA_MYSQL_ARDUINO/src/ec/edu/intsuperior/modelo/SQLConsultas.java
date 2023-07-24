package ec.edu.intsuperior.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SQLConsultas extends conexion {

    ///INCIO SESION

    public int inicioUsuario(String usuarios) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = obtenerConexion();

        String sql = "SELECT count(id_usuario) from usuario where usu_user=?";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, usuarios);
            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
            return 1;

        } catch (SQLException ex) {
            Logger.getLogger(SQLConsultas.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println(ex);
            return 1;

        }

    }

    //// INGRESO DATOS EN ESTADO

    public boolean estadoPuerta(estado est) {
        PreparedStatement ps = null;
        Connection con = obtenerConexion();

        String estado = "insert into estado (est_fecha, est_estado) "
                + "values(concat(? ?),?)";
//        String estado = "UPDATE estado SET est_fecha= ?, est_estado=? WHERE id_estado =1";

        try {
            ps = con.prepareStatement(estado);
            ps.setString(1, est.getEst_fecha());
            ps.setString(2, est.getEst_estado());

            ps.execute();
            return true;

        } catch (SQLException ex) {
            System.err.println(ex);
            return false;
        } finally {
            try {
                con.close();

            } catch (SQLException e) {
                System.err.println(e);
            }
        }

    }

}
