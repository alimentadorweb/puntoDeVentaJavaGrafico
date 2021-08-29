package clases;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author puntodeventa-jlat
 */
public class Cliente {
    
    private int NumeroCuenta;
    private String nombre;
    private String direccion;
    private String telefono;
    private String rfc;
    private String colonia;
    private String comunidad;
    private String municipio;
    private String codigoPostal;
    private String tarifa;
    private Date fechaRegistro;
    
    //consultas sql
    public static String NOMBRE_TABLA = "tblcliente";
    public static String SELECCIONAR_TODO = "select * from "+Cliente.NOMBRE_TABLA;

    public Cliente(int NumeroCuenta, String nombre, String direccion, String telefono, String rfc, String colonia, String comunidad, String municipio, String codigoPostal, String tarifa, Date fechaRegistro) {
        this.NumeroCuenta = NumeroCuenta;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.rfc = rfc;
        this.colonia = colonia;
        this.comunidad = comunidad;
        this.municipio = municipio;
        this.codigoPostal = codigoPostal;
        this.tarifa = tarifa;
        this.fechaRegistro = fechaRegistro;
    }

    public Cliente() {
    }

    public Cliente(String nombre, String direccion, String telefono, String rfc, String colonia, String comunidad, String municipio, String codigoPostal, String tarifa, Date fechaRegistro) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.rfc = rfc;
        this.colonia = colonia;
        this.comunidad = comunidad;
        this.municipio = municipio;
        this.codigoPostal = codigoPostal;
        this.tarifa = tarifa;
        this.fechaRegistro = fechaRegistro;
    }
    
    public int getNumeroCuenta() {
        return NumeroCuenta;
    }

    public void setNumeroCuenta(int NumeroCuenta) {
        this.NumeroCuenta = NumeroCuenta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public String getComunidad() {
        return comunidad;
    }

    public void setComunidad(String comunidad) {
        this.comunidad = comunidad;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getTarifa() {
        return tarifa;
    }

    public void setTarifa(String tarifa) {
        this.tarifa = tarifa;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
    
    public String getFormatearFecha(Date fecha, String formato)
    {   
        SimpleDateFormat sdf = null;
        if(formato == null)
            sdf = new SimpleDateFormat("yyyy-MM-dd");
        else
          sdf = new SimpleDateFormat(formato);  
        return sdf.format(fecha);
    }
    
    public int grabar()
    {
        String sql = "INSERT INTO tblcliente ( "+
	     "Nombre, Direccion,Telefono,"+
             "Rfc, Colonia,Comunidad,Municipio,"+
             "CodigoPostal,Tarifa, FechaRegistro)"+
             "VALUES ('"+this.nombre+"','"+this.direccion+"',"+
             "'"+this.telefono+"','"+this.rfc+"','"+this.colonia+"','"+this.comunidad+"',"+
             "'"+this.municipio+"','"+this.codigoPostal+"','"+this.tarifa+"',"+
             "'"+this.getFormatearFecha(this.fechaRegistro,null)+"')";
        return Conexion.guardarRegistro(sql);
    }

    public int actualizar(){
        String sql = "UPDATE tblcliente SET Nombre = '"+this.nombre+"',"+
                      "Direccion = '"+this.direccion+"',"+
                      "Telefono = '"+this.telefono+"',"+
                      "Rfc = '"+this.rfc+"',"+
                      "Colonia = '"+this.colonia+"',"+
                      "Comunidad = '"+this.comunidad+"',"+
                      "Municipio = '"+this.municipio+"',"+
                      "CodigoPostal = '"+this.codigoPostal+"',"+
                      "Tarifa = '"+this.tarifa+"',"+
                      "FechaRegistro = '"+this.getFormatearFecha(this.fechaRegistro,null)+"'"+
                     " WHERE NoCuenta = "+this.NumeroCuenta;
        return Conexion.guardarRegistro(sql); 
    }
    
    public int borrar(){
        String sql = "DELETE FROM tblcliente WHERE NoCuenta = "+this.NumeroCuenta;
        return Conexion.guardarRegistro(sql);
    }
    
    public static ArrayList<Cliente> getClientes(){
        ResultSet clientes = Conexion.getRegistros(Cliente.SELECCIONAR_TODO);
        ArrayList<Cliente> ListaClientes= new ArrayList();
         try{
            while(clientes.next())
            {
                Cliente cliente = new Cliente();
                cliente.setNumeroCuenta(clientes.getInt(1));
                cliente.setNombre(clientes.getString(2));
                cliente.setDireccion(clientes.getString(3));
                cliente.setTelefono(clientes.getString(4));
                cliente.setRfc(clientes.getString(5));
                cliente.setColonia(clientes.getString(6));
                cliente.setComunidad(clientes.getString(7));
                cliente.setMunicipio(clientes.getString(8));
                cliente.setCodigoPostal(clientes.getString(9));
                cliente.setTarifa(clientes.getString(10));
                cliente.setFechaRegistro(clientes.getDate(11));
                ListaClientes.add(cliente);
            }
            clientes.close();
            Conexion.con.close();
        }catch(SQLException ex){ex.printStackTrace();}
        return ListaClientes;
    }
    
    public static ArrayList<Cliente> getCliente(String nombre)
    {
        ResultSet clientes = Conexion.getRegistros(Cliente.SELECCIONAR_TODO+" where Nombre like '"+nombre+"%'");
        ArrayList<Cliente> ListaClientes= new ArrayList();
         try{
            while(clientes.next())
            {
                Cliente cliente = new Cliente();
                cliente.setNumeroCuenta(clientes.getInt(1));
                cliente.setNombre(clientes.getString(2));
                cliente.setDireccion(clientes.getString(3));
                cliente.setTelefono(clientes.getString(4));
                cliente.setRfc(clientes.getString(5));
                cliente.setColonia(clientes.getString(6));
                cliente.setComunidad(clientes.getString(7));
                cliente.setMunicipio(clientes.getString(8));
                cliente.setCodigoPostal(clientes.getString(9));
                cliente.setTarifa(clientes.getString(10));
                cliente.setFechaRegistro(clientes.getDate(11));
                ListaClientes.add(cliente);
            }
            clientes.close();
            Conexion.con.close();
        }catch(SQLException ex){ex.printStackTrace();}
         if(ListaClientes.size()>0)
            return ListaClientes;
         return null;
    }
    
    public static Cliente getCliente(int idCliente)
    {
        ResultSet clientes = Conexion.getRegistros(Cliente.SELECCIONAR_TODO+" where NoCuenta = "+idCliente);
        Cliente cliente = null;
        try{
            while(clientes.next())
            {
                cliente = new Cliente();
                cliente.setNumeroCuenta(clientes.getInt(1));
                cliente.setNombre(clientes.getString(2));
                cliente.setDireccion(clientes.getString(3));
                cliente.setTelefono(clientes.getString(4));
                cliente.setRfc(clientes.getString(5));
                cliente.setColonia(clientes.getString(6));
                cliente.setComunidad(clientes.getString(7));
                cliente.setMunicipio(clientes.getString(8));
                cliente.setCodigoPostal(clientes.getString(9));
                cliente.setTarifa(clientes.getString(10));
                cliente.setFechaRegistro(clientes.getDate(11));                
            }
            clientes.close();
            Conexion.con.close();
        }catch(SQLException ex){ex.printStackTrace();}
         
         return cliente;
    }
    
    public static Cliente getClientePorNombre(String nombre)
    {
        ResultSet clientes = Conexion.getRegistros(Cliente.SELECCIONAR_TODO+" where Nombre like '"+nombre+"%' limit 1");
         Cliente cliente = null;
        try{
            while(clientes.next())
            {
                cliente = new Cliente();
                cliente.setNumeroCuenta(clientes.getInt(1));
                cliente.setNombre(clientes.getString(2));
                cliente.setDireccion(clientes.getString(3));
                cliente.setTelefono(clientes.getString(4));
                cliente.setRfc(clientes.getString(5));
                cliente.setColonia(clientes.getString(6));
                cliente.setComunidad(clientes.getString(7));
                cliente.setMunicipio(clientes.getString(8));
                cliente.setCodigoPostal(clientes.getString(9));
                cliente.setTarifa(clientes.getString(10));
                cliente.setFechaRegistro(clientes.getDate(11));
               
            }
            clientes.close();
            Conexion.con.close();
        }catch(SQLException ex){ex.printStackTrace();}
         
         return  cliente;
    }
}
