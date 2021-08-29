package clases;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author puntodeventa-jlat
 */
public class ModelTablaPagos extends AbstractTableModel{

    private String[] nombreColumnas = {"Cliente","Fec. Cubierta","Meses Transcurridos","Fec de Pago","Rezago",
                                        "Pago Calculado","Recargo","Total","Fec. de Registro",
                                        };
    private ArrayList<Pago> pagos;
    
    
    public ModelTablaPagos(ArrayList<Pago> pagos) {
        this.pagos = pagos;
    }

    public ModelTablaPagos() {
        pagos = Pago.getPagos();
    }  
    
    public ModelTablaPagos(String nombreBuscar) {
        pagos = Pago.getPagos(nombreBuscar);
    }
    
    
    @Override
    public int getRowCount() {
       return pagos.size();
    }

    @Override
    public int getColumnCount() {
        return nombreColumnas.length;
    }

    @Override
    public String getColumnName(int column) {
        return nombreColumnas[column];
    }
    
    public Pago getPago(int index)
    {
        return pagos.get(index);
    }

    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Pago pago = pagos.get(rowIndex);
        switch(columnIndex)
        {
            
            case 0: return pago.getNroCuenta().getNombre();
            case 1: return pago.getFormatearFecha(pago.getFechaCubierta(), "dd/MM/yyyy");
            case 2: return pago.getMesesTranscurridos();
            case 3: return pago.getFormatearFecha(pago.getFechaDePago(), "dd/MM/yyyy");
            case 4: return pago.getRezago();
            case 5: return pago.getPagoCalculado();
            case 6: return pago.getRecargo();
            case 7: return pago.getTotal();
            case 8: return pago.getFormatearFecha(pago.getFechaDeRegistro(), "dd/MM/yyyy");    
            default: return null;
        }
    }
    
    public boolean estVacio()
    {
        if(pagos == null)
            return true;
        return false;
    }
    
}
