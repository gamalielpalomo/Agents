/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import java.io.File;
import tools.FileTools;

/**
 *
 * @author gamaa_000
 */
public class Builder
{

    public static void main( String args[] )
    {

        File lexFile = new File( "src/parser/LexicalAnalyzer.flex" );
        String[] syntaxArgs =
        {
            "-parser", "SyntacticAnalyzer", "src/parser/SyntacticAnalyzer.cup"
        };
        String synFile = "SyntacticAnalyzer.cup";
        jflex.Main.generate( lexFile );
        try
        {
            System.out.println( "Opening syntax" );
            java_cup.Main.main( syntaxArgs );
        }
        catch ( Exception e )
        {
        }

        if ( FileTools.moveFile( "SyntacticAnalyzer.java" ) && FileTools.moveFile( "sym.java" ) )
        {
            System.out.println( "Testing..." );
            String[] testInput =
            {
                "src/parser/input"
            };
            parser.SyntacticAnalyzer.main( testInput );
        }
    }

}
