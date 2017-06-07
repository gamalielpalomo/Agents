/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author gamaa_000
 */
public class FileTools
{

    public static boolean moveFile( String filename )
    {
        boolean result = false;
        File file = new File( filename );
        if ( file.exists() )
        {
            System.out.println("Moving "+filename);
            Path currentRelativePath = Paths.get( "" );
            String newDir = currentRelativePath.toAbsolutePath().toString()
                    + File.separator + "src" + File.separator
                    + "parser" + File.separator + file.getName();
            File oldFile = new File( newDir );
            oldFile.delete();
            if ( file.renameTo( new File( newDir ) ) )
            {
                result = true;
            }

        }
        else
        {
            System.out.println( "\nCan't move file " + filename + " [file not found]\n" );
        }
        return result;
    }
}
