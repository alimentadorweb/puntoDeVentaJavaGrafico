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
public class Orden {
    
    private int NroOrden;
    private Date fecha;
    private Cliente cliente; //NroCuenta
    private String tipo;
    private String inspector;
    private String motivoCorte;
    
     //consultas sql
    public static String NOMBRE_TABLA = "tblorden";
    public static String SELECCIONAR_TODO = "select * from "+Orden.NOMBRE_TABLA;

    public Orden() {
    }

    public Orden(int NroOrden) {
        this.NroOrden = NroOrden;
    }

    public Orden(int NroOrden, Date fecha, Cliente cliente, String tipo, String inspector, String motivoCorte) {
        this.NroOrden = NroOrden;
        this.fecha = fecha;
        this.cliente = cliente;
        this.tipo = tipo;
        this.inspector = inspector;
        this.motivoCorte = motivoCorte;
    }

    public Orden(Date fecha, Cliente cliente, String tipo, String inspector, String motivoCorte) {
        this.fecha = fecha;
        this.cliente = cliente;
        this.tipo = tipo;
        this.inspector = inspector;
        this.motivoCorte = motivoCorte;
    }

    

    public int getNroOrden() {
        return NroOrden;
    }

    public void setNroOrden(int NroOrden) {
        this.NroOrden = NroOrden;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getInspector() {
        return inspector;
    }

    public void setInspector(String inspector) {
        this.inspector = inspector;
    }

    public String getMotivoCorte() {
        return motivoCorte;
    }

    public void setMotivoCorte(String motivoCorte) {
        this.motivoCorte = motivoCorte;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
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
        String sql = "INSERT INTO tblorden ("+
             "Fecha,NoCuenta,"+
             "Tipo, Inspector,MotivoCorte)"+
            "VALUES ('"+this.getFormatearFecha(this.fecha,null)+"',"+
                    this.cliente.getNumeroCuenta()+",'"+this.tipo+"',"+
                    "'"+this.inspector+"','"+this.motivoCorte+"')";
        return Conexion.guardarRegistro(sql);
    }

    public int actualizar(){
        String sql = "UPDATE tblorden SET "+
                      "Fecha = '"+this.getFormatearFecha(this.fecha,null)+"',"+
                      "NoCuenta = "+this.cliente.getNumeroCuenta()+","+
                      "Tipo = '"+this.tipo+"',"+
                      "Inspector = '"+this.inspector+"',"+
                      "MotivoCorte = '"+this.motivoCorte+"'"+
                      " WHERE NoOrden = "+this.NroOrden;
        return Conexion.guardarRegistro(sql); 
    }
    
    public int borrar(){
        String sql = "DELETE FROM tblorden WHERE NoOrden = "+this.NroOrden;
        return Conexion.guardarRegistro(sql);
    }
    
    public static ArrayList<Orden> getOrdenes(){
        ResultSet ordenes = Conexion.getRegistros(Orden.SELECCIONAR_TODO);
        ArrayList<Orden> ListaOrdenes= new ArrayList();
         try{
            while(ordenes.next())
            {
                Orden orden = new Orden();
                orden.setNroOrden(ordenes.getInt(1));
                orden.setFecha(ordenes.getDate(2));
                orden.setCliente(Cliente.getCliente(ordenes.getInt(3)));
                orden.setTipo(ordenes.getString(4));
                orden.setInspector(ordenes.getString(5));
                orden.setMotivoCorte(ordenes.getString(6));
                
                ListaOrdenes.add(orden);
            }
            ordenes.close();
            Conexion.con.close();
        }catch(SQLException ex){ex.printStackTrace();}
        return ListaOrdenes;
    }
    
    public static ArrayList<Orden> getOrdenes(String fechaInicia,String fechaFinal,String nombreCliente){
        String idClientes = "";
        if(nombreCliente != null)
        {
            if(!nombreCliente.isEmpty())
            {                
                ArrayList<Cliente> clientes = Cliente.getCliente(nombreCliente);
                if(clientes.size()>0)
                {
                    idClientes = " and NoCuenta in "+Orden.getIdClientes(clientes);
                }
                
            }
        }
        
        ResultSet ordenes = Conexion.getRegistros(Orden.SELECCIONAR_TODO+" where Fecha between '"+fechaInicia+"' and '"+fechaFinal+"'"+idClientes);
        ArrayList<Orden> ListaOrdenes= new ArrayList();
         try{
            while(ordenes.next())
            {
                Orden orden = new Orden();
                orden.setNroOrden(ordenes.getInt(1));
                orden.setFecha(ordenes.getDate(2));
                orden.setCliente(Cliente.getCliente(ordenes.getInt(3)));
                orden.setTipo(ordenes.getString(4));
                orden.setInspector(ordenes.getString(5));
                orden.setMotivoCorte(ordenes.getString(6));
                
                ListaOrdenes.add(orden);
            }
            ordenes.close();
            Conexion.con.close();
        }catch(SQLException ex){ex.printStackTrace();}
        return ListaOrdenes;
    }
    
    
    
    public static ArrayList<Orden> getOrden(String nombre)
    {        
        ArrayList<Cliente> clientes = Cliente.getCliente(nombre);
        if(clientes == null)
            return null;
        String idClientes = getIdClientes(clientes);
        ResultSet ordenes = Conexion.getRegistros(Orden.SELECCIONAR_TODO+" where NoCuenta in "+idClientes);
        System.out.println(Orden.SELECCIONAR_TODO+" where NoCuenta in "+idClientes);
        ArrayList<Orden> ListaOrdenes= new ArrayList();
         try{
            while(ordenes.next())
            {
                Orden orden = new Orden();
                orden.setNroOrden(ordenes.getInt(1));
                orden.setFecha(ordenes.getDate(2));
                orden.setCliente(Cliente.getCliente(ordenes.getInt(3)));
                orden.setTipo(ordenes.getString(4));
                orden.setInspector(ordenes.getString(5));
                orden.setMotivoCorte(ordenes.getString(6));
                
                ListaOrdenes.add(orden);
            }
            ordenes.close();
            Conexion.con.close();
        }catch(SQLException ex){ex.printStackTrace();}
       
         if(ListaOrdenes.size()>0)
            return ListaOrdenes;
         return null;
    }
    
    private static String getIdClientes(ArrayList<Cliente> clientes){
        String ids = "(";
        for(int i = 0;i<clientes.size();i++)
        {
            if(i<clientes.size()-1)
                ids += clientes.get(i).getNumeroCuenta()+",";
            else
               ids += clientes.get(i).getNumeroCuenta();
        }
        ids += ")";
        return ids;
    }
            
            
    
    public static ArrayList<Orden> getOrden(int id)
    {
        ResultSet ordenes = Conexion.getRegistros(Orden.SELECCIONAR_TODO+" where NoCuenta ="+id);
        ArrayList<Orden> ListaOrdenes= new ArrayList();
         try{
            while(ordenes.next())
            {
                Orden orden = new Orden();
                orden.setNroOrden(ordenes.getInt(1));
                orden.setFecha(ordenes.getDate(2));
                orden.setCliente(Cliente.getCliente(ordenes.getInt(3)));
                orden.setTipo(ordenes.getString(4));
                orden.setInspector(ordenes.getString(5));
                orden.setMotivoCorte(ordenes.getString(6));
                
                ListaOrdenes.add(orden);
            }
            ordenes.close();
            Conexion.con.close();
        }catch(SQLException ex){ex.printStackTrace();}
       
         if(ListaOrdenes.size()>0)
            return ListaOrdenes;
         return null;
    }
    
    public static Orden getOrdenUnico(int idOrden)
    {
        ResultSet ordenes = Conexion.getRegistros(Orden.SELECCIONAR_TODO+" where NoOrden ="+idOrden);
        Orden orden = null;
        try{
            while(ordenes.next())
            {
                orden = new Orden();
                orden.setNroOrden(ordenes.getInt(1));
                orden.setFecha(ordenes.getDate(2));
                orden.setCliente(Cliente.getCliente(ordenes.getInt(3)));
                orden.setTipo(ordenes.getString(4));
                orden.setInspector(ordenes.getString(5));
                orden.setMotivoCorte(ordenes.getString(6));                
            }
            ordenes.close();
            Conexion.con.close();
        }catch(SQLException ex){ex.printStackTrace();}
       
         return orden;
    }
    
}
