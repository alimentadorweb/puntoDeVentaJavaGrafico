package clases;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author puntodeventa-jlat
 */
public class ModelTablaUsuarios extends AbstractTableModel{

    private String[] nombreColumnas = {"Usuario","Contraseña","Archivo","Iniciar Sesion","Cerrar Sesion",
                                        "Reg. de Usuarios","Salir de Aplicacion","Clientes","Reg. de Clientes",
                                        "Pagos","Reg. de Pagos","Emisiones de Ordenes","Reportes","Rep. de Ingresos",
                                        "Rep. de Pagos","Rep. de Ordenes","Herramientas","Calculadora",
                                        "Respaldar BD","Restaurar BD","Ayuda","Mostrar Ayuda","Acerca de"};
    private ArrayList<Usuario> usuarios;
    public ModelTablaUsuarios(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public ModelTablaUsuarios() {
        usuarios = Usuario.getUsuarios();
    }  
    
    public ModelTablaUsuarios(String nombreBuscar) {
        usuarios = Usuario.getBuscar(nombreBuscar);
    }
        
    @Override
    public int getRowCount() {
        return usuarios.size();
    }
    
    public boolean estVacio()
    {
        if(usuarios == null)
            return true;
        return false;
    }

    @Override
    public int getColumnCount() {
        return nombreColumnas.length;
    }

    @Override
    public String getColumnName(int column) {
        return nombreColumnas[column];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if(columnIndex == 0 || columnIndex == 1)
            return Object.class;
        else
            return Boolean.class;
    }
    
    public int Eliminar(int rowIndex)
    {
        Usuario user = usuarios.get(rowIndex);
        usuarios.remove(rowIndex);
        int borrar = user.borrar();
        this.fireTableRowsDeleted(usuarios.size(), usuarios.size());
        return borrar;
    }
    
    public Usuario getUsuario(int indice)
    {
        return usuarios.get(indice);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Usuario user = usuarios.get(rowIndex);
        switch(columnIndex)
        {
            case 0:return user.getUsuario();                
            case 1:return user.getPasswd();
            case 2:return user.isArchivo();
            case 3:return user.isIniciarSesion();
            case 4:return user.isCerrarSesion();
            case 5:return user.isRegistroDeUsuario();
            case 6:return user.isSalirDeAplicacion();
            case 7:return user.isClientes();
            case 8:return user.isRegistroDeClientes();
            case 9:return user.isPagos(); 
            case 10:return user.isRegistrosDePagos();
            case 11:return user.isEmisionesDeOrdenes();
            case 12:return user.isReportes();
            case 13:return user.isReporteDeIngresos();
            case 14:return user.isReporteDePagos();
            case 15:return user.isReporteDeOrdenes();
            case 16:return user.isHerramientas();
            case 17:return user.isCalculadora();
            case 18:return user.isRespladarBd();
            case 19:return user.isRestaurarBd();
            case 20:return user.isAyuda();
            case 21:return user.isMostrarAyuda();
            case 22:return user.isAcercade();
            default: return null;
               
        }
    }
    
}
