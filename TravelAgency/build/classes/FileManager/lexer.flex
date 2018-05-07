package FileManager;

import java_cup.runtime.*;

%%

%public
%class Lexer
%cup
%cupdebug
%line
%column

LineTerminator = \r|\n|\r\n
WhiteSpace     = {LineTerminator} | [ \t\f]

code = [:digit:]+
cost = {code} [.][:digit:]+
shortName = [:jletter:]([:jletterdigit:] | [-] | [_] | [.])*
longName = {shortName}({WhiteSpace}{shortName})*

%{
  	StringBuilder string = new StringBuilder();
  
  	private Symbol symbol(int type) {
    	return new Symbol(type, yyline+1, yycolumn+1);
  	}

  	private Symbol symbol(int type, Object value) {
    	return new Symbol(type, yyline+1, yycolumn+1, value);
  	}

  	private void error(String message) {
    	System.out.println("Error en linea line "+(yyline+1)+", columna "+(yycolumn+1)+" : "+message);
  	}

  	public LexerArch (java.io.Reader in) {
		this.zzReader = in;
	}

	private void imprimirToken(String textSalida){
		System.out.println("Leido: >> " + textSalida + " <<");
	}
%}

%%

<YYINITIAL>{
	","					{imprimirToken(yytext()); return symbol(coma, yytext());}
	{code}				{imprimirToken(yytext()); return symbol(codeD, yytext());}
	{cost}				{imprimirToken(yytext()); return symbol(cost, yytext());}
	{longName}			{imprimirToken(yytext()); return symbol(Name, yytext());}
	{LineTerminator} 	{imprimirToken(yytext()); return symbol(Enter, yytext());}
	{WhiteSpace} 		{/*Nothing to do*/}
}

[^] {error("Simbolo invalido <"+ yytext()+">");}
<<EOF>>                 { return symbol(EOF); }
