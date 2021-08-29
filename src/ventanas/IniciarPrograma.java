package ventanas;

import javax.swing.JFrame;

/**
 *
 * @author puntodeventa-jlat
 */
public class IniciarPrograma {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JFrame vnt = new JFrame("Ingresar");              
                PantallaLogin dialog = new PantallaLogin(vnt, true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    
}
