package FileManager;

import java_cup.runtime.*;

%public
%class Lexer
%cup
%cupdebug
%line
%column

LineTerminator = \r|\n|\r\n
WhiteSpace     = {LineTerminator} | [ \t\f]

code = [:digit:]+
cost = [-]? code [.][:digit:]+
shortName = [:jletter:]([:jletterdigit:] | [-] | [_])*[.]?{termArch}?
longName = {shortName}{{WhiteSpace}{shortName}}*

