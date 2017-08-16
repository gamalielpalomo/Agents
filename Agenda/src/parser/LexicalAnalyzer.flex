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
    return symbol(sym.SLASH);
}
":"
{
    return symbol(sym.DOUBLE);
}
"schedule"
{
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
"free"
{
    return symbol(sym.FREE);
}
"at"
{
    return symbol(sym.AT);
}
"from"
{
    return symbol(sym.FROM);
}
"to"
{
    return symbol(sym.TO);
}
"work"
{
    return symbol(sym.WORK,yytext().toString());
}
"personal"
{
    return symbol(sym.PERSONAL,yytext().toString());
}
"medical"
{
    return symbol(sym.MEDICAL,yytext().toString());
}
"meeting"
{
    return symbol(sym.MEETING,yytext().toString());
}
"with"
{
    return symbol(sym.WITH,yytext().toString()  );
}
"show"
{
    return symbol(sym.SHOW);
}
{space}
{}
{intgr}
{
    return symbol(sym.INT,Integer.parseInt(yytext()));
}
{string}
{
    return symbol(sym.STR, yytext().toString());
}
[^]
{
    return symbol(sym.GEN);
}