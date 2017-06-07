/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parser;

import Agent.Instruction;
import java.io.StringReader;

/**
 *
 * @author gamaa_000
 */
public class Interpreter
{

    public static Instruction generateInstruction( String phrase )
    {
        Instruction instruction = null;
        SyntacticAnalyzer sa = new SyntacticAnalyzer( new LexicalAnalyzer( new StringReader( phrase ) ) );
        try
        {
            sa.parse();
            instruction = sa.action_obj.instruction;
        }
        catch ( Exception e )
        {
            System.out.println( "[Interpreter]: Exception" );
        }
        return instruction;
    }
}
