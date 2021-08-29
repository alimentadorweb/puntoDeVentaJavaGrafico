package clases;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author puntodeventa-jlat
 */
public class ModelTablaOrdenes extends AbstractTableModel{

     private String[] nombreColumnas = {"Fecha","Cliente","Tipo","Inspèctor",
                                        "Motivo Corte"};
    private ArrayList<Orden> ordenes;
    
    public ModelTablaOrdenes(ArrayList<Orden> ordenes) {
        this.ordenes = ordenes;
    }

    public ModelTablaOrdenes() {
        ordenes = Orden.getOrdenes();
    }  
    
    public ModelTablaOrdenes(String nombreBuscar) {
        ordenes = Orden.getOrden(nombreBuscar);
    }
    
    @Override
    public int getRowCount() {
        return this.ordenes.size();
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
    public Object getValueAt(int rowIndex, int columnIndex) {
        Orden orden = ordenes.get(rowIndex);
        switch(columnIndex)
        {
            case 0:return orden.getFormatearFecha(orden.getFecha(), "dd/MM/yyyy");
            case 1:return orden.getCliente().getNombre();
            case 2:return orden.getTipo();
            case 3:return orden.getInspector();
            case 4:return orden.getMotivoCorte();
            default: return null;
        }
    }
    
    public int Eliminar(int rowIndex)
    {
        Orden orden = ordenes.get(rowIndex);
        ordenes.remove(rowIndex);
        int borrar = orden.borrar();
        this.fireTableRowsDeleted(ordenes.size(), ordenes.size());
        return borrar;
    }
    
    public Orden getOrden(int indice)
    {
        return ordenes.get(indice);
    }
    
    
    public boolean estVacio()
    {
        if(ordenes == null)
            return true;
        return false;
    }
    
}
