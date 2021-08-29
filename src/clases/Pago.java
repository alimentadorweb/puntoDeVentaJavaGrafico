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
public class Pago {
    private int clvFolio;
    private Cliente NroCuenta;
    private Date fechaCubierta;
    private int mesesTranscurridos;
    private Date fechaDePago;
    private double rezago;
    private double pagoCalculado;
    private double recargo;
    private double total;
    private Date fechaDeRegistro;
    
    //consultas sql
    public static String NOMBRE_TABLA = "tblpago";
    public static String SELECCIONAR_TODO = "select * from "+Pago.NOMBRE_TABLA;

    public Pago(int clvFolio, Cliente NroCuenta) {
        this.clvFolio = clvFolio;
        this.NroCuenta = NroCuenta;
    }

    public Pago(int clvFolio, Cliente NroCuenta, Date fechaCubierta, int mesesTranscurridos, Date fechaDePago, double rezago, double pagoCalculado, double recargo, double total, Date fechaDeRegistro) {
        this.clvFolio = clvFolio;
        this.NroCuenta = NroCuenta;
        this.fechaCubierta = fechaCubierta;
        this.mesesTranscurridos = mesesTranscurridos;
        this.fechaDePago = fechaDePago;
        this.rezago = rezago;
        this.pagoCalculado = pagoCalculado;
        this.recargo = recargo;
        this.total = total;
        this.fechaDeRegistro = fechaDeRegistro;
    }

    public Pago() {
    }    
    

    public int getClvFolio() {
        return clvFolio;
    }

    public void setClvFolio(int clvFolio) {
        this.clvFolio = clvFolio;
    }

    public Cliente getNroCuenta() {
        return NroCuenta;
    }

    public void setNroCuenta(Cliente NroCuenta) {
        this.NroCuenta = NroCuenta;
    }

    public Date getFechaCubierta() {
        return fechaCubierta;
    }

    public void setFechaCubierta(Date fechaCubierta) {
        this.fechaCubierta = fechaCubierta;
    }

    public int getMesesTranscurridos() {
        return mesesTranscurridos;
    }

    public void setMesesTranscurridos(int mesesTranscurridos) {
        this.mesesTranscurridos = mesesTranscurridos;
    }

    public Date getFechaDePago() {
        return fechaDePago;
    }

    public void setFechaDePago(Date fechaDePago) {
        this.fechaDePago = fechaDePago;
    }

    public double getRezago() {
        return rezago;
    }

    public void setRezago(double rezago) {
        this.rezago = rezago;
    }

    public double getPagoCalculado() {
        return pagoCalculado;
    }

    public void setPagoCalculado(double pagoCalculado) {
        this.pagoCalculado = pagoCalculado;
    }

    public double getRecargo() {
        return recargo;
    }

    public void setRecargo(double recargo) {
        this.recargo = recargo;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Date getFechaDeRegistro() {
        return fechaDeRegistro;
    }

    public void setFechaDeRegistro(Date fechaDeRegistro) {
        this.fechaDeRegistro = fechaDeRegistro;
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
        String sql = "INSERT INTO tblpago ("+
             "NoCuenta,FechaCubierta,MesesTranscurridos,"+
             "FechaDePago,Rezago,PagoCalculado,"+
             "Recargo,Total,FechaDeRegistro)"+
             "VALUES ("+this.NroCuenta.getNumeroCuenta()+","+
             "'"+this.getFormatearFecha(this.fechaCubierta, null)+"',"+this.mesesTranscurridos+",'"+this.getFormatearFecha(this.fechaDePago, null)+"',"+
             this.rezago+","+this.pagoCalculado+","+this.recargo+","+
             this.total+",'"+this.getFormatearFecha(this.fechaDeRegistro, null)+"')";
        return Conexion.guardarRegistro(sql);
    }

    public int actualizar(){
        String sql = "UPDATE tblpago "+
                    "SET NoCuenta = "+this.NroCuenta.getNumeroCuenta()+","+
                    "FechaCubierta = '"+this.getFormatearFecha(this.fechaCubierta, null)+"',"+
                    "MesesTranscurridos = "+this.mesesTranscurridos+","+
                    "FechaDePago = '"+this.getFormatearFecha(this.fechaDePago, null)+"',"+
                    "Rezago = "+this.rezago+","+
                    "PagoCalculado = "+this.pagoCalculado+","+
                    "Recargo = "+this.recargo+","+
                    "Total = "+this.total+","+
                    "FechaDeRegistro = '"+this.getFormatearFecha(this.fechaDeRegistro, null)+"'"+
                    " WHERE ClvFolio = "+this.clvFolio;
        return Conexion.guardarRegistro(sql); 
    }
    
    public int borrar(){
        String sql = "DELETE FROM tblpago WHERE ClvFolio = "+this.clvFolio;
        return Conexion.guardarRegistro(sql);
    }
    
    public static ArrayList<Pago> getPagos(){
        ResultSet pagos = Conexion.getRegistros(Pago.SELECCIONAR_TODO);
        ArrayList<Pago> ListaPagos= new ArrayList();
         try{
            while(pagos.next())
            {
                Pago pago = new Pago();
                pago.setClvFolio(pagos.getInt(1));
                pago.setNroCuenta(Cliente.getCliente(pagos.getInt(2)));
                pago.setFechaCubierta(pagos.getDate(3));
                pago.setMesesTranscurridos(pagos.getInt(4));
                pago.setFechaDePago(pagos.getDate(5));
                pago.setRezago(pagos.getDouble(6));
                pago.setPagoCalculado(pagos.getDouble(7));
                pago.setRecargo(pagos.getDouble(8));
                pago.setTotal(pagos.getDouble(9));
                pago.setFechaDeRegistro(pagos.getDate(10));
                ListaPagos.add(pago);
            }
            pagos.close();
            Conexion.con.close();
        }catch(SQLException ex){ex.printStackTrace();}
        return ListaPagos;
    }
    
    public static ArrayList<Pago> getPagos(String fechaInicio, String FechaFinal){
        ResultSet pagos = Conexion.getRegistros(Pago.SELECCIONAR_TODO+" where FechaDeRegistro >= '"+fechaInicio+"' and FechaDeRegistro<='"+FechaFinal+"'");
        ArrayList<Pago> ListaPagos= new ArrayList();
         try{
            while(pagos.next())
            {
                Pago pago = new Pago();
                pago.setClvFolio(pagos.getInt(1));
                pago.setNroCuenta(Cliente.getCliente(pagos.getInt(2)));
                pago.setFechaCubierta(pagos.getDate(3));
                pago.setMesesTranscurridos(pagos.getInt(4));
                pago.setFechaDePago(pagos.getDate(5));
                pago.setRezago(pagos.getDouble(6));
                pago.setPagoCalculado(pagos.getDouble(7));
                pago.setRecargo(pagos.getDouble(8));
                pago.setTotal(pagos.getDouble(9));
                pago.setFechaDeRegistro(pagos.getDate(10));
                ListaPagos.add(pago);
            }
            pagos.close();
            Conexion.con.close();
        }catch(SQLException ex){ex.printStackTrace();}
        return ListaPagos;
    }
    
    
    public static ArrayList<Pago> getPagos(String nombreCliente)
    {
        Cliente cliente = Cliente.getClientePorNombre(nombreCliente);
        if(cliente == null)
            return null;
        ResultSet pagos = Conexion.getRegistros(Pago.SELECCIONAR_TODO+" where NoCuenta = "+cliente.getNumeroCuenta());
        ArrayList<Pago> ListaPagos= new ArrayList();
         try{
            while(pagos.next())
            {
                Pago pago = new Pago();
                pago.setClvFolio(pagos.getInt(1));
                pago.setNroCuenta(Cliente.getCliente(pagos.getInt(2)));
                pago.setFechaCubierta(pagos.getDate(3));
                pago.setMesesTranscurridos(pagos.getInt(4));
                pago.setFechaDePago(pagos.getDate(5));
                pago.setRezago(pagos.getDouble(6));
                pago.setPagoCalculado(pagos.getDouble(7));
                pago.setRecargo(pagos.getDouble(8));
                pago.setTotal(pagos.getDouble(9));
                pago.setFechaDeRegistro(pagos.getDate(10));
                ListaPagos.add(pago);
            }
            pagos.close();
            Conexion.con.close();
        }catch(SQLException ex){ex.printStackTrace();}
         if(ListaPagos.size()>0)
            return ListaPagos;
         return null;
    }
    
    
}
