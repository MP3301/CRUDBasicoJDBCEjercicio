package datos;

import com.mysql.cj.protocol.Resultset;

import java.sql.*;

public class Conexion {

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/testdbJDBC?useSSL=true&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";

    private final static String JDBC_USER = "root";

    private final static String JDBC_PASSWORD = null;

    public static Connection getConnection() throws SQLException {

      return DriverManager.getConnection(JDBC_URL,JDBC_USER,JDBC_PASSWORD);

    }

    public static void closeRs(ResultSet rs) throws SQLException {

        rs.close();

    }

    public static void closeStatement(PreparedStatement smtm) throws SQLException {

        smtm.close();

    }


    public static void closeConn(Connection conn) throws SQLException {
        conn.close();
    }


}
