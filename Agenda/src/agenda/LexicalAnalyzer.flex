package agenda;
import java_cup.runtime.*;
import java.io.Reader;

%%

%class LexicalAnalyzer
%line
%column
%cup
%{
    private Symbol symbol(int type)
    {
        return new Symbol(type,yyline,yycolumn);
    }
    private Symbol symbol(int type, Object value)
    {
        return new Symbol(type,yyline,yycolumn,value);
    }
%}

jump    = \r|\n|\r\n
space   = {jump}|[\t\f]
intgr     = [0-9]+


%%
" " 
{}
";"
{
    return symbol(sym.SEMI);
}
"/"
{
    return symbol(sym.SLASH);
}
":"
{
    System.out.print(":");
    return symbol(sym.DOUBLE);
}
"schedule"
{
    System.out.print(" SCHEDULE");
    return symbol(sym.SCHEDULE);
}
"remove"
{
    return symbol(sym.REMOVE);
}
"change"
{
    return symbol(sym.CHANGE);
}
"at"
{
    System.out.print(" AT");
    return symbol(sym.AT);
}
"from"
{
    return symbol(sym.FROM);
}
"to"
{
    System.out.print(" TO");
    return symbol(sym.TO);
}
"work"
{
    System.out.print(" WORK");
    return symbol(sym.WORK);
}
"personal"
{
    System.out.print(" PERSONAL");
    return symbol(sym.PERSONAL);
}
"medical"
{
    System.out.print(" MEDICAL");
    return symbol(sym.MEDICAL);
}
{space}
{}
{intgr}
{
    System.out.print(" "+yytext());
    return symbol(sym.INT,Integer.parseInt(yytext()));
}
[^]
{
    throw new Error("Ilegal character <"+yytext()+"> found in line "+yyline+" column "+yycolumn);
}