package clases;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author puntodeventa-jlat
 */
public class ModelTablaClientes extends AbstractTableModel{

    private String[] nombreColumnas = {"Nombre","Direccion","Telefono","Rfc","Colonia",
                                        "Comunidad","Municipio","Cod. Postal","Tarifa",
                                        "Fec. de Resgistro"};
    private ArrayList<Cliente> clientes;
    
     public ModelTablaClientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }

    public ModelTablaClientes() {
        clientes = Cliente.getClientes();
    }  
    
    public ModelTablaClientes(String nombreBuscar) {
        clientes = Cliente.getCliente(nombreBuscar);
    }
    
    @Override
    public int getRowCount() {
        return clientes.size();
    }

    @Override
    public int getColumnCount() {
        return nombreColumnas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Cliente cliente = clientes.get(rowIndex);
        switch(columnIndex)
        {
            case 0: return cliente.getNombre();
            case 1: return cliente.getDireccion();
            case 2: return cliente.getTelefono();
            case 3: return cliente.getRfc();
            case 4: return cliente.getColonia();
            case 5: return cliente.getComunidad();
            case 6: return cliente.getMunicipio();
            case 7: return cliente.getCodigoPostal();
            case 8: return cliente.getTarifa();
            case 9: return cliente.getFormatearFecha(cliente.getFechaRegistro(),"dd/MM/yyyy");
            default: return null;    
                
        }
    }
    
    @Override
    public String getColumnName(int column) {
        return nombreColumnas[column];
    }
    
    public int Eliminar(int rowIndex)
    {
        Cliente cliente = clientes.get(rowIndex);
        clientes.remove(rowIndex);
        int borrar = cliente.borrar();
        this.fireTableRowsDeleted(clientes.size(), clientes.size());
        return borrar;
    }
    
    public Cliente getCliente(int indice)
    {
        return clientes.get(indice);
    }
    
    
    public boolean estVacio()
    {
        if(clientes == null)
            return true;
        return false;
    }
    
}
