package clases;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author puntodeventa-jlat
 */
public class ModelTablaReporteOrdenes extends ModelTablaOrdenes{

    private String[] nombreColumnas = {"Fecha","Cliente","Tipo","Inspector"};
    private ArrayList<Orden> ordenes;
    public ModelTablaReporteOrdenes(Date fechaInicio, Date fechaFinal) {
        ordenes = Orden.getOrdenes(getFormatearFecha(fechaInicio, null), getFormatearFecha(fechaFinal, null), null);
    }
    
      public ModelTablaReporteOrdenes(Date fechaInicio, Date fechaFinal,String nombreCliente) {
        ordenes = Orden.getOrdenes(getFormatearFecha(fechaInicio, null), getFormatearFecha(fechaFinal, null), nombreCliente);
    }
   
    @Override
    public String getColumnName(int column) {
        return this.nombreColumnas[column];
    }
    
    @Override
    public int getColumnCount() {
        return nombreColumnas.length;
    }

    @Override
    public int getRowCount() {
        return ordenes.size(); 
    }
    
    
    
    @Override
    public boolean estVacio() {
        return this.ordenes.isEmpty();
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
            default: return null;
        }
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
     
     public void limpiar()
     {
         ordenes.clear();
         this.fireTableRowsDeleted(ordenes.size(), ordenes.size());
     }
}
