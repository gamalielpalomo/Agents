
//----------------------------------------------------
// The following code was generated by CUP v0.11a beta 20060608
// Wed Aug 16 15:27:08 CDT 2017
//----------------------------------------------------

package parser;

import java_cup.runtime.*;
import java.io.FileReader;
import Agenda.Event;
import Agent.Instruction;
import Agent.Knowledge;

/** CUP v0.11a beta 20060608 generated parser.
  * @version Wed Aug 16 15:27:08 CDT 2017
  */
public class SyntacticAnalyzer extends java_cup.runtime.lr_parser {

  /** Default constructor. */
  public SyntacticAnalyzer() {super();}

  /** Constructor which sets the default scanner. */
  public SyntacticAnalyzer(java_cup.runtime.Scanner s) {super(s);}

  /** Constructor which sets the default scanner. */
  public SyntacticAnalyzer(java_cup.runtime.Scanner s, java_cup.runtime.SymbolFactory sf) {super(s,sf);}

  /** Production table. */
  protected static final short _production_table[][] = 
    unpackFromStrings(new String[] {
    "\000\020\000\002\004\003\000\002\002\004\000\002\004" +
    "\003\000\002\004\003\000\002\004\003\000\002\004\003" +
    "\000\002\005\003\000\002\005\003\000\002\011\013\000" +
    "\002\011\013\000\002\011\013\000\002\012\022\000\002" +
    "\012\020\000\002\006\015\000\002\007\021\000\002\010" +
    "\003" });

  /** Access to production table. */
  public short[][] production_table() {return _production_table;}

  /** Parse-action table. */
  protected static final short[][] _action_table = 
    unpackFromStrings(new String[] {
    "\000\131\000\012\005\017\006\013\010\011\011\015\001" +
    "\002\000\004\002\uffff\001\002\000\004\002\ufffd\001\002" +
    "\000\004\002\ufffa\001\002\000\004\002\ufffb\001\002\000" +
    "\004\002\133\001\002\000\004\027\121\001\002\000\004" +
    "\002\001\001\002\000\004\014\103\001\002\000\004\002" +
    "\ufffc\001\002\000\004\002\ufff2\001\002\000\004\002\ufffe" +
    "\001\002\000\012\022\022\023\020\024\023\026\021\001" +
    "\002\000\004\014\074\001\002\000\006\014\042\025\043" +
    "\001\002\000\004\014\033\001\002\000\004\014\024\001" +
    "\002\000\004\021\025\001\002\000\004\007\026\001\002" +
    "\000\004\021\027\001\002\000\004\021\030\001\002\000" +
    "\004\012\031\001\002\000\004\021\032\001\002\000\004" +
    "\002\ufff8\001\002\000\004\021\034\001\002\000\004\007" +
    "\035\001\002\000\004\021\036\001\002\000\004\021\037" +
    "\001\002\000\004\012\040\001\002\000\004\021\041\001" +
    "\002\000\004\002\ufff9\001\002\000\004\021\061\001\002" +
    "\000\004\027\044\001\002\000\004\014\045\001\002\000" +
    "\004\021\046\001\002\000\004\007\047\001\002\000\004" +
    "\021\050\001\002\000\004\015\051\001\002\000\004\021" +
    "\052\001\002\000\004\012\053\001\002\000\004\021\054" +
    "\001\002\000\004\016\055\001\002\000\004\021\056\001" +
    "\002\000\004\012\057\001\002\000\004\021\060\001\002" +
    "\000\004\002\ufff6\001\002\000\004\007\062\001\002\000" +
    "\004\021\063\001\002\000\004\015\064\001\002\000\004" +
    "\021\065\001\002\000\004\012\066\001\002\000\004\021" +
    "\067\001\002\000\004\016\070\001\002\000\004\021\071" +
    "\001\002\000\004\012\072\001\002\000\004\021\073\001" +
    "\002\000\004\002\ufff5\001\002\000\004\021\075\001\002" +
    "\000\004\007\076\001\002\000\004\021\077\001\002\000" +
    "\004\021\100\001\002\000\004\012\101\001\002\000\004" +
    "\021\102\001\002\000\004\002\ufff7\001\002\000\004\021" +
    "\104\001\002\000\004\007\105\001\002\000\004\021\106" +
    "\001\002\000\004\007\107\001\002\000\004\021\110\001" +
    "\002\000\004\015\111\001\002\000\004\021\112\001\002" +
    "\000\004\012\113\001\002\000\004\021\114\001\002\000" +
    "\004\016\115\001\002\000\004\021\116\001\002\000\004" +
    "\012\117\001\002\000\004\021\120\001\002\000\004\002" +
    "\ufff3\001\002\000\004\014\122\001\002\000\004\021\123" +
    "\001\002\000\004\007\124\001\002\000\004\021\125\001" +
    "\002\000\004\007\126\001\002\000\004\021\127\001\002" +
    "\000\004\021\130\001\002\000\004\012\131\001\002\000" +
    "\004\021\132\001\002\000\004\002\ufff4\001\002\000\004" +
    "\002\000\001\002" });

  /** Access to parse-action table. */
  public short[][] action_table() {return _action_table;}

  /** <code>reduce_goto</code> table. */
  protected static final short[][] _reduce_table = 
    unpackFromStrings(new String[] {
    "\000\131\000\022\002\011\004\007\005\003\006\015\007" +
    "\004\010\013\011\006\012\005\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001" });

  /** Access to <code>reduce_goto</code> table. */
  public short[][] reduce_table() {return _reduce_table;}

  /** Instance of action encapsulation class. */
  protected CUP$SyntacticAnalyzer$actions action_obj;

  /** Action encapsulation object initializer. */
  protected void init_actions()
    {
      action_obj = new CUP$SyntacticAnalyzer$actions(this);
    }

  /** Invoke a user supplied parse action. */
  public java_cup.runtime.Symbol do_action(
    int                        act_num,
    java_cup.runtime.lr_parser parser,
    java.util.Stack            stack,
    int                        top)
    throws java.lang.Exception
  {
    /* call code in generated class */
    return action_obj.CUP$SyntacticAnalyzer$do_action(act_num, parser, stack, top);
  }

  /** Indicates start state. */
  public int start_state() {return 0;}
  /** Indicates start production. */
  public int start_production() {return 1;}

  /** <code>EOF</code> Symbol index. */
  public int EOF_sym() {return 0;}

  /** <code>error</code> Symbol index. */
  public int error_sym() {return 1;}



    public static void main(String args[])
    {
        try
        {
            SyntacticAnalyzer sa = new SyntacticAnalyzer(new LexicalAnalyzer(new FileReader(args[0])));
            Object result = sa.parse().value;
            System.out.println("Executed!");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

}

/** Cup generated class to encapsulate user supplied action code.*/
class CUP$SyntacticAnalyzer$actions {


    Event event;
    Instruction instruction;
    java.util.HashMap ntpt = Knowledge.nameToPersonType;
    java.util.HashMap ptdt = Knowledge.personTypeToDateType;

  private final SyntacticAnalyzer parser;

  /** Constructor */
  CUP$SyntacticAnalyzer$actions(SyntacticAnalyzer parser) {
    this.parser = parser;
  }

  /** Method with the actual generated action code. */
  public final java_cup.runtime.Symbol CUP$SyntacticAnalyzer$do_action(
    int                        CUP$SyntacticAnalyzer$act_num,
    java_cup.runtime.lr_parser CUP$SyntacticAnalyzer$parser,
    java.util.Stack            CUP$SyntacticAnalyzer$stack,
    int                        CUP$SyntacticAnalyzer$top)
    throws java.lang.Exception
    {
      /* Symbol object for return from actions */
      java_cup.runtime.Symbol CUP$SyntacticAnalyzer$result;

      /* select the action based on the action number */
      switch (CUP$SyntacticAnalyzer$act_num)
        {
          /*. . . . . . . . . . . . . . . . . . . .*/
          case 15: // display ::= SHOW 
            {
              Object RESULT =null;
		
    instruction = new Instruction(Instruction.Command.SHOW);

              CUP$SyntacticAnalyzer$result = parser.getSymbolFactory().newSymbol("display",6, ((java_cup.runtime.Symbol)CUP$SyntacticAnalyzer$stack.peek()), ((java_cup.runtime.Symbol)CUP$SyntacticAnalyzer$stack.peek()), RESULT);
            }
          return CUP$SyntacticAnalyzer$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 14: // free1 ::= FREE AT INT SLASH INT SLASH INT FROM INT DOUBLE INT TO INT DOUBLE INT 
            {
              Object RESULT =null;
		int monthleft = ((java_cup.runtime.Symbol)CUP$SyntacticAnalyzer$stack.elementAt(CUP$SyntacticAnalyzer$top-12)).left;
		int monthright = ((java_cup.runtime.Symbol)CUP$SyntacticAnalyzer$stack.elementAt(CUP$SyntacticAnalyzer$top-12)).right;
		int month = (int)((java_cup.runtime.Symbol) CUP$SyntacticAnalyzer$stack.elementAt(CUP$SyntacticAnalyzer$top-12)).value;
		int dayleft = ((java_cup.runtime.Symbol)CUP$SyntacticAnalyzer$stack.elementAt(CUP$SyntacticAnalyzer$top-10)).left;
		int dayright = ((java_cup.runtime.Symbol)CUP$SyntacticAnalyzer$stack.elementAt(CUP$SyntacticAnalyzer$top-10)).right;
		int day = (int)((java_cup.runtime.Symbol) CUP$SyntacticAnalyzer$stack.elementAt(CUP$SyntacticAnalyzer$top-10)).value;
		int yearleft = ((java_cup.runtime.Symbol)CUP$SyntacticAnalyzer$stack.elementAt(CUP$SyntacticAnalyzer$top-8)).left;
		int yearright = ((java_cup.runtime.Symbol)CUP$SyntacticAnalyzer$stack.elementAt(CUP$SyntacticAnalyzer$top-8)).right;
		int year = (int)((java_cup.runtime.Symbol) CUP$SyntacticAnalyzer$stack.elementAt(CUP$SyntacticAnalyzer$top-8)).value;
		int hourleft = ((java_cup.runtime.Symbol)CUP$SyntacticAnalyzer$stack.elementAt(CUP$SyntacticAnalyzer$top-6)).left;
		int hourright = ((java_cup.runtime.Symbol)CUP$SyntacticAnalyzer$stack.elementAt(CUP$SyntacticAnalyzer$top-6)).right;
		int hour = (int)((java_cup.runtime.Symbol) CUP$SyntacticAnalyzer$stack.elementAt(CUP$SyntacticAnalyzer$top-6)).value;
		int minutesleft = ((java_cup.runtime.Symbol)CUP$SyntacticAnalyzer$stack.elementAt(CUP$SyntacticAnalyzer$top-4)).left;
		int minutesright = ((java_cup.runtime.Symbol)CUP$SyntacticAnalyzer$stack.elementAt(CUP$SyntacticAnalyzer$top-4)).right;
		int minutes = (int)((java_cup.runtime.Symbol) CUP$SyntacticAnalyzer$stack.elementAt(CUP$SyntacticAnalyzer$top-4)).value;
		int hour2left = ((java_cup.runtime.Symbol)CUP$SyntacticAnalyzer$stack.elementAt(CUP$SyntacticAnalyzer$top-2)).left;
		int hour2right = ((java_cup.runtime.Symbol)CUP$SyntacticAnalyzer$stack.elementAt(CUP$SyntacticAnalyzer$top-2)).right;
		int hour2 = (int)((java_cup.runtime.Symbol) CUP$SyntacticAnalyzer$stack.elementAt(CUP$SyntacticAnalyzer$top-2)).value;
		int minutes2left = ((java_cup.runtime.Symbol)CUP$SyntacticAnalyzer$stack.peek()).left;
		int minutes2right = ((java_cup.runtime.Symbol)CUP$SyntacticAnalyzer$stack.peek()).right;
		int minutes2 = (int)((java_cup.runtime.Symbol) CUP$SyntacticAnalyzer$stack.peek()).value;
		
    event = new Event(hour, hour2, month-1, month-1, day, day, "free", "nobody");
    java.util.ArrayList spliceResult = tools.EventArray.checkSplices(event);
    if(spliceResult.size() != 0)
    {
        System.out.println("[Assistant]: That matches with an event, freeing agenda.");
        instruction = new Instruction(Instruction.Command.FREE,spliceResult);
    }
    else
        instruction = new Instruction(Instruction.Command.NOTHING);

              CUP$SyntacticAnalyzer$result = parser.getSymbolFactory().newSymbol("free1",5, ((java_cup.runtime.Symbol)CUP$SyntacticAnalyzer$stack.elementAt(CUP$SyntacticAnalyzer$top-14)), ((java_cup.runtime.Symbol)CUP$SyntacticAnalyzer$stack.peek()), RESULT);
            }
          return CUP$SyntacticAnalyzer$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 13: // rem ::= REMOVE STR AT INT SLASH INT SLASH INT INT DOUBLE INT 
            {
              Object RESULT =null;
		int descriptionleft = ((java_cup.runtime.Symbol)CUP$SyntacticAnalyzer$stack.elementAt(CUP$SyntacticAnalyzer$top-9)).left;
		int descriptionright = ((java_cup.runtime.Symbol)CUP$SyntacticAnalyzer$stack.elementAt(CUP$SyntacticAnalyzer$top-9)).right;
		String description = (String)((java_cup.runtime.Symbol) CUP$SyntacticAnalyzer$stack.elementAt(CUP$SyntacticAnalyzer$top-9)).value;
		int monthleft = ((java_cup.runtime.Symbol)CUP$SyntacticAnalyzer$stack.elementAt(CUP$SyntacticAnalyzer$top-7)).left;
		int monthright = ((java_cup.runtime.Symbol)CUP$SyntacticAnalyzer$stack.elementAt(CUP$SyntacticAnalyzer$top-7)).right;
		int month = (int)((java_cup.runtime.Symbol) CUP$SyntacticAnalyzer$stack.elementAt(CUP$SyntacticAnalyzer$top-7)).value;
		int dayleft = ((java_cup.runtime.Symbol)CUP$SyntacticAnalyzer$stack.elementAt(CUP$SyntacticAnalyzer$top-5)).left;
		int dayright = ((java_cup.runtime.Symbol)CUP$SyntacticAnalyzer$stack.elementAt(CUP$SyntacticAnalyzer$top-5)).right;
		int day = (int)((java_cup.runtime.Symbol) CUP$SyntacticAnalyzer$stack.elementAt(CUP$SyntacticAnalyzer$top-5)).value;
		int yearleft = ((java_cup.runtime.Symbol)CUP$SyntacticAnalyzer$stack.elementAt(CUP$SyntacticAnalyzer$top-3)).left;
		int yearright = ((java_cup.runtime.Symbol)CUP$SyntacticAnalyzer$stack.elementAt(CUP$SyntacticAnalyzer$top-3)).right;
		int year = (int)((java_cup.runtime.Symbol) CUP$SyntacticAnalyzer$stack.elementAt(CUP$SyntacticAnalyzer$top-3)).value;
		int hourleft = ((java_cup.runtime.Symbol)CUP$SyntacticAnalyzer$stack.elementAt(CUP$SyntacticAnalyzer$top-2)).left;
		int hourright = ((java_cup.runtime.Symbol)CUP$SyntacticAnalyzer$stack.elementAt(CUP$SyntacticAnalyzer$top-2)).right;
		int hour = (int)((java_cup.runtime.Symbol) CUP$SyntacticAnalyzer$stack.elementAt(CUP$SyntacticAnalyzer$top-2)).value;
		int minutesleft = ((java_cup.runtime.Symbol)CUP$SyntacticAnalyzer$stack.peek()).left;
		int minutesright = ((java_cup.runtime.Symbol)CUP$SyntacticAnalyzer$stack.peek()).right;
		int minutes = (int)((java_cup.runtime.Symbol) CUP$SyntacticAnalyzer$stack.peek()).value;
		
    System.out.format("\nRemove %s",description);
    event = new Event(description);
    instruction = new Instruction(Instruction.Command.REMOVE, event);

              CUP$SyntacticAnalyzer$result = parser.getSymbolFactory().newSymbol("rem",4, ((java_cup.runtime.Symbol)CUP$SyntacticAnalyzer$stack.elementAt(CUP$SyntacticAnalyzer$top-10)), ((java_cup.runtime.Symbol)CUP$SyntacticAnalyzer$stack.peek()), RESULT);
            }
          return CUP$SyntacticAnalyzer$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 12: // schedule2 ::= SCHEDULE MEETING AT INT SLASH INT FROM INT DOUBLE INT TO INT DOUBLE INT 
            {
              Object RESULT =null;
		int monthleft = ((java_cup.runtime.Symbol)CUP$SyntacticAnalyzer$stack.elementAt(CUP$SyntacticAnalyzer$top-10)).left;
		int monthright = ((java_cup.runtime.Symbol)CUP$SyntacticAnalyzer$stack.elementAt(CUP$SyntacticAnalyzer$top-10)).right;
		int month = (int)((java_cup.runtime.Symbol) CUP$SyntacticAnalyzer$stack.elementAt(CUP$SyntacticAnalyzer$top-10)).value;
		int dayleft = ((java_cup.runtime.Symbol)CUP$SyntacticAnalyzer$stack.elementAt(CUP$SyntacticAnalyzer$top-8)).left;
		int dayright = ((java_cup.runtime.Symbol)CUP$SyntacticAnalyzer$stack.elementAt(CUP$SyntacticAnalyzer$top-8)).right;
		int day = (int)((java_cup.runtime.Symbol) CUP$SyntacticAnalyzer$stack.elementAt(CUP$SyntacticAnalyzer$top-8)).value;
		int hourleft = ((java_cup.runtime.Symbol)CUP$SyntacticAnalyzer$stack.elementAt(CUP$SyntacticAnalyzer$top-6)).left;
		int hourright = ((java_cup.runtime.Symbol)CUP$SyntacticAnalyzer$stack.elementAt(CUP$SyntacticAnalyzer$top-6)).right;
		int hour = (int)((java_cup.runtime.Symbol) CUP$SyntacticAnalyzer$stack.elementAt(CUP$SyntacticAnalyzer$top-6)).value;
		int minutesleft = ((java_cup.runtime.Symbol)CUP$SyntacticAnalyzer$stack.elementAt(CUP$SyntacticAnalyzer$top-4)).left;
		int minutesright = ((java_cup.runtime.Symbol)CUP$SyntacticAnalyzer$stack.elementAt(CUP$SyntacticAnalyzer$top-4)).right;
		int minutes = (int)((java_cup.runtime.Symbol) CUP$SyntacticAnalyzer$stack.elementAt(CUP$SyntacticAnalyzer$top-4)).value;
		int hour2left = ((java_cup.runtime.Symbol)CUP$SyntacticAnalyzer$stack.elementAt(CUP$SyntacticAnalyzer$top-2)).left;
		int hour2right = ((java_cup.runtime.Symbol)CUP$SyntacticAnalyzer$stack.elementAt(CUP$SyntacticAnalyzer$top-2)).right;
		int hour2 = (int)((java_cup.runtime.Symbol) CUP$SyntacticAnalyzer$stack.elementAt(CUP$SyntacticAnalyzer$top-2)).value;
		int minutes2left = ((java_cup.runtime.Symbol)CUP$SyntacticAnalyzer$stack.peek()).left;
		int minutes2right = ((java_cup.runtime.Symbol)CUP$SyntacticAnalyzer$stack.peek()).right;
		int minutes2 = (int)((java_cup.runtime.Symbol) CUP$SyntacticAnalyzer$stack.peek()).value;
		
    event = new Event(hour, hour2, month-1, month-1, day, day, "personal", "nobody");
    Event spliceResult = tools.EventArray.checkSplice(event);
    if(spliceResult != null)
    {
        System.out.println("[Assistant]: You have another event at that date");
        Event majorPriority = Agent.Decision.decideEvent(event, spliceResult);
        instruction = new Instruction(Instruction.Command.CHANGE,spliceResult,majorPriority);
    }
    else
        instruction = new Instruction(Instruction.Command.SCHEDULE,event);

              CUP$SyntacticAnalyzer$result = parser.getSymbolFactory().newSymbol("schedule2",8, ((java_cup.runtime.Symbol)CUP$SyntacticAnalyzer$stack.elementAt(CUP$SyntacticAnalyzer$top-13)), ((java_cup.runtime.Symbol)CUP$SyntacticAnalyzer$stack.peek()), RESULT);
            }
          return CUP$SyntacticAnalyzer$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 11: // schedule2 ::= SCHEDULE MEETING WITH STR AT INT SLASH INT FROM INT DOUBLE INT TO INT DOUBLE INT 
            {
              Object RESULT =null;
		int companionleft = ((java_cup.runtime.Symbol)CUP$SyntacticAnalyzer$stack.elementAt(CUP$SyntacticAnalyzer$top-12)).left;
		int companionright = ((java_cup.runtime.Symbol)CUP$SyntacticAnalyzer$stack.elementAt(CUP$SyntacticAnalyzer$top-12)).right;
		String companion = (String)((java_cup.runtime.Symbol) CUP$SyntacticAnalyzer$stack.elementAt(CUP$SyntacticAnalyzer$top-12)).value;
		int monthleft = ((java_cup.runtime.Symbol)CUP$SyntacticAnalyzer$stack.elementAt(CUP$SyntacticAnalyzer$top-10)).left;
		int monthright = ((java_cup.runtime.Symbol)CUP$SyntacticAnalyzer$stack.elementAt(CUP$SyntacticAnalyzer$top-10)).right;
		int month = (int)((java_cup.runtime.Symbol) CUP$SyntacticAnalyzer$stack.elementAt(CUP$SyntacticAnalyzer$top-10)).value;
		int dayleft = ((java_cup.runtime.Symbol)CUP$SyntacticAnalyzer$stack.elementAt(CUP$SyntacticAnalyzer$top-8)).left;
		int dayright = ((java_cup.runtime.Symbol)CUP$SyntacticAnalyzer$stack.elementAt(CUP$SyntacticAnalyzer$top-8)).right;
		int day = (int)((java_cup.runtime.Symbol) CUP$SyntacticAnalyzer$stack.elementAt(CUP$SyntacticAnalyzer$top-8)).value;
		int hourleft = ((java_cup.runtime.Symbol)CUP$SyntacticAnalyzer$stack.elementAt(CUP$SyntacticAnalyzer$top-6)).left;
		int hourright = ((java_cup.runtime.Symbol)CUP$SyntacticAnalyzer$stack.elementAt(CUP$SyntacticAnalyzer$top-6)).right;
		int hour = (int)((java_cup.runtime.Symbol) CUP$SyntacticAnalyzer$stack.elementAt(CUP$SyntacticAnalyzer$top-6)).value;
		int minutesleft = ((java_cup.runtime.Symbol)CUP$SyntacticAnalyzer$stack.elementAt(CUP$SyntacticAnalyzer$top-4)).left;
		int minutesright = ((java_cup.runtime.Symbol)CUP$SyntacticAnalyzer$stack.elementAt(CUP$SyntacticAnalyzer$top-4)).right;
		int minutes = (int)((java_cup.runtime.Symbol) CUP$SyntacticAnalyzer$stack.elementAt(CUP$SyntacticAnalyzer$top-4)).value;
		int hour2left = ((java_cup.runtime.Symbol)CUP$SyntacticAnalyzer$stack.elementAt(CUP$SyntacticAnalyzer$top-2)).left;
		int hour2right = ((java_cup.runtime.Symbol)CUP$SyntacticAnalyzer$stack.elementAt(CUP$SyntacticAnalyzer$top-2)).right;
		int hour2 = (int)((java_cup.runtime.Symbol) CUP$SyntacticAnalyzer$stack.elementAt(CUP$SyntacticAnalyzer$top-2)).value;
		int minutes2left = ((java_cup.runtime.Symbol)CUP$SyntacticAnalyzer$stack.peek()).left;
		int minutes2right = ((java_cup.runtime.Symbol)CUP$SyntacticAnalyzer$stack.peek()).right;
		int minutes2 = (int)((java_cup.runtime.Symbol) CUP$SyntacticAnalyzer$stack.peek()).value;
		
    //System.out.format("\nMeeting with %s scheduled at %d:%d on %d-%d-%d\n",companion,hour,minutes,month,day,year);
    String personType = (String)ntpt.get(companion);
    String dateType = "personal";
    if(!personType.equals(""))
    {
        dateType = (String)ptdt.get(personType);
    }
    event = new Event(hour, hour2, month-1, month-1, day, day, dateType, companion);
    Event spliceResult = tools.EventArray.checkSplice(event);
    if(spliceResult != null)
    {
        System.out.println("[Assistant]: You have another event at that date");
        Event majorPriority = Agent.Decision.decideEvent(event, spliceResult);
        instruction = new Instruction(Instruction.Command.CHANGE,spliceResult,majorPriority);
    }
    else
        instruction = new Instruction(Instruction.Command.SCHEDULE,event);

              CUP$SyntacticAnalyzer$result = parser.getSymbolFactory().newSymbol("schedule2",8, ((java_cup.runtime.Symbol)CUP$SyntacticAnalyzer$stack.elementAt(CUP$SyntacticAnalyzer$top-15)), ((java_cup.runtime.Symbol)CUP$SyntacticAnalyzer$stack.peek()), RESULT);
            }
          return CUP$SyntacticAnalyzer$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 10: // schedule1 ::= SCHEDULE MEDICAL AT INT SLASH INT INT DOUBLE INT 
            {
              Object RESULT =null;
		int descriptionleft = ((java_cup.runtime.Symbol)CUP$SyntacticAnalyzer$stack.elementAt(CUP$SyntacticAnalyzer$top-7)).left;
		int descriptionright = ((java_cup.runtime.Symbol)CUP$SyntacticAnalyzer$stack.elementAt(CUP$SyntacticAnalyzer$top-7)).right;
		String description = (String)((java_cup.runtime.Symbol) CUP$SyntacticAnalyzer$stack.elementAt(CUP$SyntacticAnalyzer$top-7)).value;
		int monthleft = ((java_cup.runtime.Symbol)CUP$SyntacticAnalyzer$stack.elementAt(CUP$SyntacticAnalyzer$top-5)).left;
		int monthright = ((java_cup.runtime.Symbol)CUP$SyntacticAnalyzer$stack.elementAt(CUP$SyntacticAnalyzer$top-5)).right;
		int month = (int)((java_cup.runtime.Symbol) CUP$SyntacticAnalyzer$stack.elementAt(CUP$SyntacticAnalyzer$top-5)).value;
		int dayleft = ((java_cup.runtime.Symbol)CUP$SyntacticAnalyzer$stack.elementAt(CUP$SyntacticAnalyzer$top-3)).left;
		int dayright = ((java_cup.runtime.Symbol)CUP$SyntacticAnalyzer$stack.elementAt(CUP$SyntacticAnalyzer$top-3)).right;
		int day = (int)((java_cup.runtime.Symbol) CUP$SyntacticAnalyzer$stack.elementAt(CUP$SyntacticAnalyzer$top-3)).value;
		int hourleft = ((java_cup.runtime.Symbol)CUP$SyntacticAnalyzer$stack.elementAt(CUP$SyntacticAnalyzer$top-2)).left;
		int hourright = ((java_cup.runtime.Symbol)CUP$SyntacticAnalyzer$stack.elementAt(CUP$SyntacticAnalyzer$top-2)).right;
		int hour = (int)((java_cup.runtime.Symbol) CUP$SyntacticAnalyzer$stack.elementAt(CUP$SyntacticAnalyzer$top-2)).value;
		int minutesleft = ((java_cup.runtime.Symbol)CUP$SyntacticAnalyzer$stack.peek()).left;
		int minutesright = ((java_cup.runtime.Symbol)CUP$SyntacticAnalyzer$stack.peek()).right;
		int minutes = (int)((java_cup.runtime.Symbol) CUP$SyntacticAnalyzer$stack.peek()).value;
		
    //System.out.format("\n%s date scheduled at %d:%d on %d-%d-%d\n",description,hour,minutes,month,day,year);
    event = new Event(hour, hour+1, month-1, month-1, day, day, description, "nobody");
    //System.out.println("Comparing result: "+tools.EventArray.checkSplice(event));
    Event spliceResult = tools.EventArray.checkSplice(event);
    if(spliceResult != null)
    {
        System.out.println("[Assistant]: You have another event at that date");
        Event majorPriority = Agent.Decision.decideEvent(event, spliceResult);
        instruction = new Instruction(Instruction.Command.CHANGE,spliceResult,majorPriority);
    }
    else
        instruction = new Instruction(Instruction.Command.SCHEDULE,event);

              CUP$SyntacticAnalyzer$result = parser.getSymbolFactory().newSymbol("schedule1",7, ((java_cup.runtime.Symbol)CUP$SyntacticAnalyzer$stack.elementAt(CUP$SyntacticAnalyzer$top-8)), ((java_cup.runtime.Symbol)CUP$SyntacticAnalyzer$stack.peek()), RESULT);
            }
          return CUP$SyntacticAnalyzer$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 9: // schedule1 ::= SCHEDULE PERSONAL AT INT SLASH INT INT DOUBLE INT 
            {
              Object RESULT =null;
		int descriptionleft = ((java_cup.runtime.Symbol)CUP$SyntacticAnalyzer$stack.elementAt(CUP$SyntacticAnalyzer$top-7)).left;
		int descriptionright = ((java_cup.runtime.Symbol)CUP$SyntacticAnalyzer$stack.elementAt(CUP$SyntacticAnalyzer$top-7)).right;
		String description = (String)((java_cup.runtime.Symbol) CUP$SyntacticAnalyzer$stack.elementAt(CUP$SyntacticAnalyzer$top-7)).value;
		int monthleft = ((java_cup.runtime.Symbol)CUP$SyntacticAnalyzer$stack.elementAt(CUP$SyntacticAnalyzer$top-5)).left;
		int monthright = ((java_cup.runtime.Symbol)CUP$SyntacticAnalyzer$stack.elementAt(CUP$SyntacticAnalyzer$top-5)).right;
		int month = (int)((java_cup.runtime.Symbol) CUP$SyntacticAnalyzer$stack.elementAt(CUP$SyntacticAnalyzer$top-5)).value;
		int dayleft = ((java_cup.runtime.Symbol)CUP$SyntacticAnalyzer$stack.elementAt(CUP$SyntacticAnalyzer$top-3)).left;
		int dayright = ((java_cup.runtime.Symbol)CUP$SyntacticAnalyzer$stack.elementAt(CUP$SyntacticAnalyzer$top-3)).right;
		int day = (int)((java_cup.runtime.Symbol) CUP$SyntacticAnalyzer$stack.elementAt(CUP$SyntacticAnalyzer$top-3)).value;
		int hourleft = ((java_cup.runtime.Symbol)CUP$SyntacticAnalyzer$stack.elementAt(CUP$SyntacticAnalyzer$top-2)).left;
		int hourright = ((java_cup.runtime.Symbol)CUP$SyntacticAnalyzer$stack.elementAt(CUP$SyntacticAnalyzer$top-2)).right;
		int hour = (int)((java_cup.runtime.Symbol) CUP$SyntacticAnalyzer$stack.elementAt(CUP$SyntacticAnalyzer$top-2)).value;
		int minutesleft = ((java_cup.runtime.Symbol)CUP$SyntacticAnalyzer$stack.peek()).left;
		int minutesright = ((java_cup.runtime.Symbol)CUP$SyntacticAnalyzer$stack.peek()).right;
		int minutes = (int)((java_cup.runtime.Symbol) CUP$SyntacticAnalyzer$stack.peek()).value;
		
    //System.out.format("\n%s date scheduled at %d:%d on %d-%d-%d\n",description,hour,minutes,month,day,year);
    event = new Event(hour, hour+1, month-1, month-1, day, day, description, "nobody");
    //System.out.println("Comparing result: "+tools.EventArray.checkSplice(event));
    Event spliceResult = tools.EventArray.checkSplice(event);
    if(spliceResult != null)
    {
        System.out.println("[Assistant]: You have another event at that date");
        Event majorPriority = Agent.Decision.decideEvent(event, spliceResult);
        instruction = new Instruction(Instruction.Command.CHANGE,spliceResult,majorPriority);
    }
    else
        instruction = new Instruction(Instruction.Command.SCHEDULE,event);

              CUP$SyntacticAnalyzer$result = parser.getSymbolFactory().newSymbol("schedule1",7, ((java_cup.runtime.Symbol)CUP$SyntacticAnalyzer$stack.elementAt(CUP$SyntacticAnalyzer$top-8)), ((java_cup.runtime.Symbol)CUP$SyntacticAnalyzer$stack.peek()), RESULT);
            }
          return CUP$SyntacticAnalyzer$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 8: // schedule1 ::= SCHEDULE WORK AT INT SLASH INT INT DOUBLE INT 
            {
              Object RESULT =null;
		int descriptionleft = ((java_cup.runtime.Symbol)CUP$SyntacticAnalyzer$stack.elementAt(CUP$SyntacticAnalyzer$top-7)).left;
		int descriptionright = ((java_cup.runtime.Symbol)CUP$SyntacticAnalyzer$stack.elementAt(CUP$SyntacticAnalyzer$top-7)).right;
		String description = (String)((java_cup.runtime.Symbol) CUP$SyntacticAnalyzer$stack.elementAt(CUP$SyntacticAnalyzer$top-7)).value;
		int monthleft = ((java_cup.runtime.Symbol)CUP$SyntacticAnalyzer$stack.elementAt(CUP$SyntacticAnalyzer$top-5)).left;
		int monthright = ((java_cup.runtime.Symbol)CUP$SyntacticAnalyzer$stack.elementAt(CUP$SyntacticAnalyzer$top-5)).right;
		int month = (int)((java_cup.runtime.Symbol) CUP$SyntacticAnalyzer$stack.elementAt(CUP$SyntacticAnalyzer$top-5)).value;
		int dayleft = ((java_cup.runtime.Symbol)CUP$SyntacticAnalyzer$stack.elementAt(CUP$SyntacticAnalyzer$top-3)).left;
		int dayright = ((java_cup.runtime.Symbol)CUP$SyntacticAnalyzer$stack.elementAt(CUP$SyntacticAnalyzer$top-3)).right;
		int day = (int)((java_cup.runtime.Symbol) CUP$SyntacticAnalyzer$stack.elementAt(CUP$SyntacticAnalyzer$top-3)).value;
		int hourleft = ((java_cup.runtime.Symbol)CUP$SyntacticAnalyzer$stack.elementAt(CUP$SyntacticAnalyzer$top-2)).left;
		int hourright = ((java_cup.runtime.Symbol)CUP$SyntacticAnalyzer$stack.elementAt(CUP$SyntacticAnalyzer$top-2)).right;
		int hour = (int)((java_cup.runtime.Symbol) CUP$SyntacticAnalyzer$stack.elementAt(CUP$SyntacticAnalyzer$top-2)).value;
		int minutesleft = ((java_cup.runtime.Symbol)CUP$SyntacticAnalyzer$stack.peek()).left;
		int minutesright = ((java_cup.runtime.Symbol)CUP$SyntacticAnalyzer$stack.peek()).right;
		int minutes = (int)((java_cup.runtime.Symbol) CUP$SyntacticAnalyzer$stack.peek()).value;
		
    //System.out.format("\n%s date scheduled at %d:%d on %d-%d-%d\n",description,hour,minutes,month,day,year);
    event = new Event(hour, hour+1, month-1, month-1, day, day, description, "nobody");
    //System.out.println("Comparing result: "+tools.EventArray.checkSplice(event));
    Event spliceResult = tools.EventArray.checkSplice(event);
    if(spliceResult != null)
    {
        System.out.println("[Assistant]: You have another event at that date");
        Event majorPriority = Agent.Decision.decideEvent(event, spliceResult);
        instruction = new Instruction(Instruction.Command.CHANGE,spliceResult,majorPriority);
    }
    else
        instruction = new Instruction(Instruction.Command.SCHEDULE,event);
    

              CUP$SyntacticAnalyzer$result = parser.getSymbolFactory().newSymbol("schedule1",7, ((java_cup.runtime.Symbol)CUP$SyntacticAnalyzer$stack.elementAt(CUP$SyntacticAnalyzer$top-8)), ((java_cup.runtime.Symbol)CUP$SyntacticAnalyzer$stack.peek()), RESULT);
            }
          return CUP$SyntacticAnalyzer$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 7: // agend ::= schedule2 
            {
              Object RESULT =null;

              CUP$SyntacticAnalyzer$result = parser.getSymbolFactory().newSymbol("agend",3, ((java_cup.runtime.Symbol)CUP$SyntacticAnalyzer$stack.peek()), ((java_cup.runtime.Symbol)CUP$SyntacticAnalyzer$stack.peek()), RESULT);
            }
          return CUP$SyntacticAnalyzer$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 6: // agend ::= schedule1 
            {
              Object RESULT =null;

              CUP$SyntacticAnalyzer$result = parser.getSymbolFactory().newSymbol("agend",3, ((java_cup.runtime.Symbol)CUP$SyntacticAnalyzer$stack.peek()), ((java_cup.runtime.Symbol)CUP$SyntacticAnalyzer$stack.peek()), RESULT);
            }
          return CUP$SyntacticAnalyzer$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 5: // todo ::= display 
            {
              Object RESULT =null;

              CUP$SyntacticAnalyzer$result = parser.getSymbolFactory().newSymbol("todo",2, ((java_cup.runtime.Symbol)CUP$SyntacticAnalyzer$stack.peek()), ((java_cup.runtime.Symbol)CUP$SyntacticAnalyzer$stack.peek()), RESULT);
            }
          return CUP$SyntacticAnalyzer$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 4: // todo ::= free1 
            {
              Object RESULT =null;

              CUP$SyntacticAnalyzer$result = parser.getSymbolFactory().newSymbol("todo",2, ((java_cup.runtime.Symbol)CUP$SyntacticAnalyzer$stack.peek()), ((java_cup.runtime.Symbol)CUP$SyntacticAnalyzer$stack.peek()), RESULT);
            }
          return CUP$SyntacticAnalyzer$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 3: // todo ::= rem 
            {
              Object RESULT =null;

              CUP$SyntacticAnalyzer$result = parser.getSymbolFactory().newSymbol("todo",2, ((java_cup.runtime.Symbol)CUP$SyntacticAnalyzer$stack.peek()), ((java_cup.runtime.Symbol)CUP$SyntacticAnalyzer$stack.peek()), RESULT);
            }
          return CUP$SyntacticAnalyzer$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 2: // todo ::= agend 
            {
              Object RESULT =null;

              CUP$SyntacticAnalyzer$result = parser.getSymbolFactory().newSymbol("todo",2, ((java_cup.runtime.Symbol)CUP$SyntacticAnalyzer$stack.peek()), ((java_cup.runtime.Symbol)CUP$SyntacticAnalyzer$stack.peek()), RESULT);
            }
          return CUP$SyntacticAnalyzer$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 1: // $START ::= todo EOF 
            {
              Object RESULT =null;
		int start_valleft = ((java_cup.runtime.Symbol)CUP$SyntacticAnalyzer$stack.elementAt(CUP$SyntacticAnalyzer$top-1)).left;
		int start_valright = ((java_cup.runtime.Symbol)CUP$SyntacticAnalyzer$stack.elementAt(CUP$SyntacticAnalyzer$top-1)).right;
		Object start_val = (Object)((java_cup.runtime.Symbol) CUP$SyntacticAnalyzer$stack.elementAt(CUP$SyntacticAnalyzer$top-1)).value;
		RESULT = start_val;
              CUP$SyntacticAnalyzer$result = parser.getSymbolFactory().newSymbol("$START",0, ((java_cup.runtime.Symbol)CUP$SyntacticAnalyzer$stack.elementAt(CUP$SyntacticAnalyzer$top-1)), ((java_cup.runtime.Symbol)CUP$SyntacticAnalyzer$stack.peek()), RESULT);
            }
          /* ACCEPT */
          CUP$SyntacticAnalyzer$parser.done_parsing();
          return CUP$SyntacticAnalyzer$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 0: // todo ::= create 
            {
              Object RESULT =null;

              CUP$SyntacticAnalyzer$result = parser.getSymbolFactory().newSymbol("todo",2, ((java_cup.runtime.Symbol)CUP$SyntacticAnalyzer$stack.peek()), ((java_cup.runtime.Symbol)CUP$SyntacticAnalyzer$stack.peek()), RESULT);
            }
          return CUP$SyntacticAnalyzer$result;

          /* . . . . . .*/
          default:
            throw new Exception(
               "Invalid action number found in internal parse table");

        }
    }
}

