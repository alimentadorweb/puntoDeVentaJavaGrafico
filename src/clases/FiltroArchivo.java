package clases;

import java.io.File;
import javax.swing.filechooser.FileFilter;

/**
 *
 * @author puntodeventa-jlat
 */
public class FiltroArchivo extends FileFilter{

    @Override
    public boolean accept(File f) {
        return f.isDirectory() || f.getName().startsWith("mysqldump");
    }

    @Override
    public String getDescription() {
        return "Buscar Archivo: mysqldump.exe";
    }
    
}
