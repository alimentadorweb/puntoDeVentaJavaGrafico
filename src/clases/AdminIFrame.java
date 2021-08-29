package clases;

import java.beans.PropertyVetoException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JLayeredPane;

/**
 * importare
 * @author El APRENDIZ www.elaprendiz.net63.net
 */
public class AdminIFrame {
    
    public static void mostrarVentanaFactura(JDesktopPane dp,JInternalFrame vnt)
    {        
        if(vnt != null && !vnt.isShowing())
       {
           vnt.show();
           dp.remove(vnt);
            try{
                dp.add(vnt, JLayeredPane.DEFAULT_LAYER); 
            }catch(IllegalArgumentException ex){               
                dp.add(vnt, JLayeredPane.DEFAULT_LAYER); 
            }    
       }
        
        if(vnt == null)
        {          
          dp.add(vnt, JLayeredPane.DEFAULT_LAYER);
        } 
       activarVentana(dp,vnt);     
    }
    
    private static void activarVentana(JDesktopPane dp,JInternalFrame vnt)
    {
        try {
            vnt.setSelected(true);            
        } catch (PropertyVetoException ex) {
            ex.printStackTrace();
        }
        dp.setPosition(vnt, 0);
    }
    
    
}
