package clases;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author puntodeventa-jlat
 */
public class Usuario {
    
    private int idUsuario;
    private String usuario;
    private String passwd;
    
    //definicion de permisos
     
    private boolean archivo;
    private boolean iniciarSesion;
    private boolean cerrarSesion;
    private boolean registroDeUsuario;
    private boolean salirDeAplicacion;
    private boolean clientes;
    private boolean registroDeClientes;
    private boolean pagos;
    private boolean registrosDePagos;
    private boolean emisionesDeOrdenes;
    private boolean Reportes;
    private boolean reporteDeIngresos;
    private boolean reporteDePagos;
    private boolean reporteDeOrdenes;
    private boolean herramientas;
    private boolean calculadora;
    private boolean respladarBd;
    private boolean restaurarBd;
    private boolean ayuda;
    private boolean mostrarAyuda;
    private boolean acercade;
    
    //consultas sql
    public static String NOMBRE_TABLA = "tblusuario";
    public static String SELECCIONAR_TODO = "select * from "+Usuario.NOMBRE_TABLA;
    

    public Usuario() {
    }

    public Usuario(String usuario, String passwd) {
        this.usuario = usuario;
        this.passwd = passwd;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public boolean isArchivo() {
        return archivo;
    }

    public void setArchivo(boolean archivo) {
        this.archivo = archivo;
    }

    public boolean isIniciarSesion() {
        return iniciarSesion;
    }

    public void setIniciarSesion(boolean iniciarSesion) {
        this.iniciarSesion = iniciarSesion;
    }

    public boolean isCerrarSesion() {
        return cerrarSesion;
    }

    public void setCerrarSesion(boolean cerrarSesion) {
        this.cerrarSesion = cerrarSesion;
    }

    public boolean isRegistroDeUsuario() {
        return registroDeUsuario;
    }

    public void setRegistroDeUsuario(boolean registroDeUsuario) {
        this.registroDeUsuario = registroDeUsuario;
    }

    public boolean isSalirDeAplicacion() {
        return salirDeAplicacion;
    }

    public void setSalirDeAplicacion(boolean salirDeAplicacion) {
        this.salirDeAplicacion = salirDeAplicacion;
    }

    public boolean isClientes() {
        return clientes;
    }

    public void setClientes(boolean clientes) {
        this.clientes = clientes;
    }

    public boolean isRegistroDeClientes() {
        return registroDeClientes;
    }

    public void setRegistroDeClientes(boolean registroDeClientes) {
        this.registroDeClientes = registroDeClientes;
    }

    public boolean isPagos() {
        return pagos;
    }

    public void setPagos(boolean pagos) {
        this.pagos = pagos;
    }

    public boolean isRegistrosDePagos() {
        return registrosDePagos;
    }

    public void setRegistrosDePagos(boolean registrosDePagos) {
        this.registrosDePagos = registrosDePagos;
    }

    public boolean isEmisionesDeOrdenes() {
        return emisionesDeOrdenes;
    }

    public void setEmisionesDeOrdenes(boolean emisionesDeOrdenes) {
        this.emisionesDeOrdenes = emisionesDeOrdenes;
    }

    public boolean isReportes() {
        return Reportes;
    }

    public void setReportes(boolean Reportes) {
        this.Reportes = Reportes;
    }

    public boolean isReporteDeIngresos() {
        return reporteDeIngresos;
    }

    public void setReporteDeIngresos(boolean reporteDeIngresos) {
        this.reporteDeIngresos = reporteDeIngresos;
    }

    public boolean isReporteDePagos() {
        return reporteDePagos;
    }

    public void setReporteDePagos(boolean reporteDePagos) {
        this.reporteDePagos = reporteDePagos;
    }

    public boolean isReporteDeOrdenes() {
        return reporteDeOrdenes;
    }

    public void setReporteDeOrdenes(boolean reporteDeOrdenes) {
        this.reporteDeOrdenes = reporteDeOrdenes;
    }

    public boolean isHerramientas() {
        return herramientas;
    }

    public void setHerramientas(boolean herramientas) {
        this.herramientas = herramientas;
    }

    public boolean isCalculadora() {
        return calculadora;
    }

    public void setCalculadora(boolean calculadora) {
        this.calculadora = calculadora;
    }

    public boolean isRespladarBd() {
        return respladarBd;
    }

    public void setRespladarBd(boolean respladarBd) {
        this.respladarBd = respladarBd;
    }

    public boolean isRestaurarBd() {
        return restaurarBd;
    }

    public void setRestaurarBd(boolean restaurarBd) {
        this.restaurarBd = restaurarBd;
    }

    public boolean isAyuda() {
        return ayuda;
    }

    public void setAyuda(boolean ayuda) {
        this.ayuda = ayuda;
    }

    public boolean isMostrarAyuda() {
        return mostrarAyuda;
    }

    public void setMostrarAyuda(boolean mostrarAyuda) {
        this.mostrarAyuda = mostrarAyuda;
    }

    public boolean isAcercade() {
        return acercade;
    }

    public void setAcercade(boolean acercade) {
        this.acercade = acercade;
    }   
    
    
    //metodos estaticos de consulta
    public static String getAnterior(int idUser)
    {
        return Usuario.SELECCIONAR_TODO+" where ClvUsuario < "+idUser+" limit 1";
    }
    public static String getSiguiente(int idUser)
    {
        return Usuario.SELECCIONAR_TODO+" where ClvUsuario > "+idUser+" limit 1";
    }
    
    public static String getPrimero()
    {
        return Usuario.SELECCIONAR_TODO+" limit 1";
    }
     
    public static String getUltimo()
    {
        return Usuario.SELECCIONAR_TODO+" order by ClvUsuario desc limit 1";
    }
    
    public int grabar()
    {
        String sql = "INSERT INTO tblusuario (Usuario, passwd,Archivo,IniciarSesion,CerrarSesion,"+
             "RegistroDeUsuario,SalirDeAplicacion,Clientes,RegistroDeClientes,Pagos,"+
             "RegistroDePagos,EmisionesOrdenes,Reportes,ReporteDeIngresos,ReporteDePagos,"+
             "ReporteDeOrdenes,Herramientas,Calculadora,RespaldarBd,RestaurarBd,"+
             "Ayuda,MostrarAyuda,AcercaDe)"+
       "VALUES ('"+this.usuario+"','"+this.passwd+"',"+this.archivo+","+this.iniciarSesion+","+this.cerrarSesion+","+this.registroDeUsuario+","+
        this.salirDeAplicacion+", "+this.clientes+","+this.registroDeClientes+","+this.pagos+","+this.registrosDePagos+","+this.emisionesDeOrdenes+","+
        this.Reportes+","+this.reporteDeIngresos+","+this.reporteDePagos+","+this.reporteDeOrdenes+","+this.herramientas+","+this.calculadora+","+
        this.respladarBd+","+this.restaurarBd+","+this.ayuda+","+this.mostrarAyuda+","+this.acercade+")";
        return Conexion.guardarRegistro(sql);
    }
    
    public int actualizar()
    {
        String sql = "UPDATE tblusuario SET "+
                    "Usuario = '"+this.usuario+"',"+
                    "passwd = '"+this.passwd+"',"+
                    "Archivo = "+this.archivo+","+
                    "IniciarSesion = "+this.iniciarSesion+","+
                    "CerrarSesion = "+this.cerrarSesion+","+
                    "RegistroDeUsuario = "+this.registroDeUsuario+","+
                    "SalirDeAplicacion = "+this.salirDeAplicacion+","+
                    "Clientes = "+this.clientes+","+
                    "RegistroDeClientes = "+this.registroDeClientes+","+
                    "Pagos = "+this.pagos+","+
                    "RegistroDePagos = "+this.registrosDePagos+","+
                    "EmisionesOrdenes = "+this.emisionesDeOrdenes+","+
                    "Reportes = "+this.Reportes+","+
                    "ReporteDeIngresos = "+this.reporteDeIngresos+","+
                    "ReporteDePagos = "+this.reporteDePagos+","+
                    "ReporteDeOrdenes = "+this.reporteDeOrdenes+","+
                    "Herramientas = "+this.herramientas+","+
                    "Calculadora = "+this.calculadora+","+
                    "RespaldarBd = "+this.respladarBd+","+
                    "RestaurarBd = "+this.restaurarBd+","+
                    "Ayuda = "+this.ayuda+","+
                    "MostrarAyuda = "+this.mostrarAyuda+","+
                    "AcercaDe = "+this.acercade+
                   " WHERE ClvUsuario = "+this.idUsuario;
        return Conexion.guardarRegistro(sql);
    }
    
    public int borrar()
    {
        String sql = "DELETE FROM tblusuario WHERE ClvUsuario = "+this.idUsuario;
        return Conexion.guardarRegistro(sql);
    }
    
    public int cambiarNombreDeUsuario(String user)
    {
        String sql = "UPDATE tblusuario SET Usuario = "+user+" WHERE ClvUsuario = "+this.idUsuario;
        int gr = Conexion.guardarRegistro(sql);
        if(gr==1)
        {
            this.usuario = user;
            return gr;
        }
        return 0;
    }
    
    public int cambiarPassword(String pass)
    {
        String sql = "UPDATE tblusuario SET passwd = "+pass+" WHERE ClvUsuario = "+this.idUsuario;
        int gr = Conexion.guardarRegistro(sql);
        if(gr==1)
        {
            this.passwd = pass;
            return gr;
        }
        return 0;
    }
    
    public static ArrayList<Usuario> getUsuarios()
    {
        ResultSet users = Conexion.getRegistros(Usuario.SELECCIONAR_TODO);
        ArrayList<Usuario> ListaUsuarios = new ArrayList();
        try{
            while(users.next())
            {
                Usuario usuario = new Usuario();
                usuario.setIdUsuario(users.getInt(1));//idusuario
                usuario.setUsuario(users.getString(2));//usuario
                usuario.setPasswd(users.getString(3));//contraseña
                usuario.setArchivo(users.getBoolean(4));//archivo
                usuario.setIniciarSesion(users.getBoolean(5));
                usuario.setCerrarSesion(users.getBoolean(6));
                usuario.setRegistroDeUsuario(users.getBoolean(7));
                usuario.setSalirDeAplicacion(users.getBoolean(8));
                usuario.setClientes(users.getBoolean(9));
                usuario.setRegistroDeClientes(users.getBoolean(10));
                usuario.setPagos(users.getBoolean(11));
                usuario.setRegistrosDePagos(users.getBoolean(12));
                usuario.setEmisionesDeOrdenes(users.getBoolean(13));
                usuario.setReportes(users.getBoolean(14));
                usuario.setReporteDeIngresos(users.getBoolean(15));
                usuario.setReporteDePagos(users.getBoolean(16));
                usuario.setReporteDeOrdenes(users.getBoolean(17));
                usuario.setHerramientas(users.getBoolean(18));
                usuario.setCalculadora(users.getBoolean(19));
                usuario.setRespladarBd(users.getBoolean(20));
                usuario.setRestaurarBd(users.getBoolean(21));
                usuario.setAyuda(users.getBoolean(22));
                usuario.setMostrarAyuda(users.getBoolean(23));
                usuario.setAcercade(users.getBoolean(24));
                ListaUsuarios.add(usuario);
            }
            users.close();
            Conexion.con.close();
        }catch(SQLException ex){ex.printStackTrace();}
        return ListaUsuarios;
    }
    
    public static ArrayList<Usuario> getBuscar(String nombre)
    {
        ResultSet users = Conexion.getRegistros(Usuario.SELECCIONAR_TODO+" where Usuario like '"+nombre+"%'");
        ArrayList<Usuario> ListaUsuarios = new ArrayList();
        try{
            while(users.next())
            {
                Usuario usuario = new Usuario();
                usuario.setIdUsuario(users.getInt(1));//idusuario
                usuario.setUsuario(users.getString(2));//usuario
                usuario.setPasswd(users.getString(3));//contraseña
                usuario.setArchivo(users.getBoolean(4));//archivo
                usuario.setIniciarSesion(users.getBoolean(5));
                usuario.setCerrarSesion(users.getBoolean(6));
                usuario.setRegistroDeUsuario(users.getBoolean(7));
                usuario.setSalirDeAplicacion(users.getBoolean(8));
                usuario.setClientes(users.getBoolean(9));
                usuario.setRegistroDeClientes(users.getBoolean(10));
                usuario.setPagos(users.getBoolean(11));
                usuario.setRegistrosDePagos(users.getBoolean(12));
                usuario.setEmisionesDeOrdenes(users.getBoolean(13));
                usuario.setReportes(users.getBoolean(14));
                usuario.setReporteDeIngresos(users.getBoolean(15));
                usuario.setReporteDePagos(users.getBoolean(16));
                usuario.setReporteDeOrdenes(users.getBoolean(17));
                usuario.setHerramientas(users.getBoolean(18));
                usuario.setCalculadora(users.getBoolean(19));
                usuario.setRespladarBd(users.getBoolean(20));
                usuario.setRestaurarBd(users.getBoolean(21));
                usuario.setAyuda(users.getBoolean(22));
                usuario.setMostrarAyuda(users.getBoolean(23));
                usuario.setAcercade(users.getBoolean(24));
                ListaUsuarios.add(usuario);
            }
            users.close();
            Conexion.con.close();
        }catch(SQLException ex){ex.printStackTrace();}
        if(ListaUsuarios.isEmpty())
            return null;
        
        return ListaUsuarios;
    }
    public static Usuario Login(String user, String passwd)
    {
        String sql = Usuario.SELECCIONAR_TODO+" where Usuario = '"+user+"' and passwd = '"+passwd+"'";
        ResultSet users = Conexion.getRegistros(sql);
        Usuario usuario = null;
           try{
            while(users.next())
            {
                usuario = new Usuario();
                usuario.setIdUsuario(users.getInt(1));//idusuario
                usuario.setUsuario(users.getString(2));//usuario
                usuario.setPasswd(users.getString(3));//contraseña
                usuario.setArchivo(users.getBoolean(4));//archivo
                usuario.setIniciarSesion(users.getBoolean(5));
                usuario.setCerrarSesion(users.getBoolean(6));
                usuario.setRegistroDeUsuario(users.getBoolean(7));
                usuario.setSalirDeAplicacion(users.getBoolean(8));
                usuario.setClientes(users.getBoolean(9));
                usuario.setRegistroDeClientes(users.getBoolean(10));
                usuario.setPagos(users.getBoolean(11));
                usuario.setRegistrosDePagos(users.getBoolean(12));
                usuario.setEmisionesDeOrdenes(users.getBoolean(13));
                usuario.setReportes(users.getBoolean(14));
                usuario.setReporteDeIngresos(users.getBoolean(15));
                usuario.setReporteDePagos(users.getBoolean(16));
                usuario.setReporteDeOrdenes(users.getBoolean(17));
                usuario.setHerramientas(users.getBoolean(18));
                usuario.setCalculadora(users.getBoolean(19));
                usuario.setRespladarBd(users.getBoolean(20));
                usuario.setRestaurarBd(users.getBoolean(21));
                usuario.setAyuda(users.getBoolean(22));
                usuario.setMostrarAyuda(users.getBoolean(23));
                usuario.setAcercade(users.getBoolean(24));                
            }
            users.close();
            Conexion.con.close();
        }catch(SQLException ex){ex.printStackTrace();}
           return usuario;
    }
    
    
    
}
