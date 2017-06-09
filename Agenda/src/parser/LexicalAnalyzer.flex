package parser;
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
intgr   = [0-9]+
string  = [a-zA-Z]+


%%
" " 
{}
";"
{
    return symbol(sym.SEMI);
}
"/"
{
    System.out.print("/");
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
    return symbol(sym.WORK,yytext().toString());
}
"personal"
{
    System.out.print(" PERSONAL");
    return symbol(sym.PERSONAL,yytext().toString());
}
"medical"
{
    System.out.print(" MEDICAL");
    return symbol(sym.MEDICAL,yytext().toString());
}
"meeting"
{
    System.out.print(" MEETING");
    return symbol(sym.MEETING,yytext().toString());
}
"with"
{
    System.out.print(" WITH");
    return symbol(sym.WITH,yytext().toString()  );
}
{space}
{}
{intgr}
{
    System.out.print(" "+yytext());
    return symbol(sym.INT,Integer.parseInt(yytext()));
}
{string}
{
    System.out.print(" "+yytext());
    return symbol(sym.STR, yytext().toString());
}
[^]
{
    System.out.println("Generic Symbol: "+yytext());
    return symbol(sym.GEN);
}