package datos;

import com.mysql.cj.protocol.Resultset;
import domain.Nombre;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NombreDAO {

    private static final String SQL_SELECT ="SELECT * FROM nombre";

    private static final String SQL_INSERT ="INSERT INTO nombre(Usuario,Nombre, Apellido , Id) VALUES(?,?,?,?)";

    private static final String SQL_UPDATE ="UPDATE nombre SET Usuario = ?,Nombre = ?, Apellido = ? WHERE Id = ?";

    private static final String SQL_DELETE ="DELETE FROM nombre WHERE Id = ?";
    public List<Nombre> seleccionar(){
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        Nombre nombre = null;
        List<Nombre> nombres = new ArrayList<>();

        try {
            con = Conexion.getConnection();
            stm = con.prepareStatement(SQL_SELECT);
            rs = stm.executeQuery();

            while (rs.next()){
                int Id = rs.getInt("Id");
                String Nombre = rs.getString("Nombre");
                String Apellido = rs.getString("Apellido");
                String Usuario = rs.getString("Usuario");
                nombre = new Nombre(Usuario,Nombre,Apellido,Id);

                nombres.add(nombre);

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            try {

                Conexion.closeRs(rs);
                Conexion.closeStatement(stm);
                Conexion.closeConn(con);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return nombres;
    }


    public int insertar(Nombre nombre){
        Connection con = null;
        PreparedStatement smt = null;
        int registros = 0;
        try {
            con = Conexion.getConnection();
            smt = con.prepareStatement(SQL_INSERT);
            smt.setString(1,nombre.getUsuario());
            smt.setString(2,nombre.getNombre());
            smt.setString(3,nombre.getApellido());
            smt.setInt(4,nombre.getId());




            registros = smt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

finally {
            try {
                Conexion.closeStatement(smt);
                Conexion.closeConn(con);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }
        return registros;
    }



    public int actualizar(Nombre nombre){
        Connection con = null;
        PreparedStatement smt = null;
        int registros = 0;
        try {
            con = Conexion.getConnection();
            smt = con.prepareStatement(SQL_UPDATE);
            smt.setString(1,nombre.getUsuario());
            smt.setString(2,nombre.getNombre());
            smt.setString(3,nombre.getApellido());
            smt.setInt(4,nombre.getId());




            registros = smt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        finally {
            try {
                Conexion.closeStatement(smt);
                Conexion.closeConn(con);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }
        return registros;
    }



    public int eliminar(Nombre nombre){
        Connection con = null;
        PreparedStatement smt = null;
        int registros = 0;
        try {
            con = Conexion.getConnection();
            smt = con.prepareStatement(SQL_DELETE);
            smt.setInt(1,nombre.getId());
            registros = smt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        finally {
            try {
                Conexion.closeStatement(smt);
                Conexion.closeConn(con);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }
        return registros;
    }





}
