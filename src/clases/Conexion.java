package clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author puntodeventa-jlat
 */
public class Conexion {   
    
    public static String bd = "puntoventas-jlat";
    public static String login = "root";
    public static String password = "";
    public static String url = "jdbc:mysql://localhost:3306/" + Conexion.bd;
    public Statement stmt;//consultas
    public static Connection con;
    public ResultSet rs;
    public ResultSetMetaData rsMeta;
    public static void Conectar()
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            con = DriverManager.getConnection(url, login, password);
            System.out.println("CONEXION EXITOSA");
        }
        catch(Exception e)
        {
            System.out.println("ERROR DE CONEXION: " + e.getMessage());
        }

    }
    
    /**
     * 
     * @param sql sentencia sql como insertar, actualizar y eliminar
     * @return 0 si no hubo ningun cambio, devuelve 1 si hubo algun cambio 
     * en los registros
     */
    public static int guardarRegistro(String sql)
    {
        Conexion.Conectar();
        try{
            Statement st = Conexion.con.createStatement();
            int eu = st.executeUpdate(sql);
            st.close();
            Conexion.con.close();
            return eu;
            
        }catch(SQLException ex){           
          ex.printStackTrace();
        }           
        return 0;
    }
    
    public static ResultSet getRegistros(String sql)
    {
        Conexion.Conectar();
        try{
            Statement st = Conexion.con.createStatement();
            ResultSet eq = st.executeQuery(sql);            
            return eq;
            
        }catch(SQLException ex){           
          ex.printStackTrace();
        }
        
        return null;
    }

    
}
