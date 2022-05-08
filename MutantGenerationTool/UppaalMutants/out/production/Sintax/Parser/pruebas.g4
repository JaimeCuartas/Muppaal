grammar pruebas; // rename to distinguish from Expr.g4

prog:   expr* ;

expr: ID LESS ID # jeje  ;


LESS:   ID comparisonOperator ID ;

comparisonOperator: '<' | '>' | '==' ;

LESSE:  '<=' ;
SYMBOL: '<<*' ;

COMPARISON:

MUL :   '*' ; // assigns token name to '*' used above in grammar
DIV :   '/' ;
ADD :   '+' ;
SUB :   '-' ;
MULDIV: '*/' ;
ID  :   [a-zA-Z]+ ;      // match identifiers
INT :   [0-9]+ ;         // match integers
NEWLINE:'\r'? '\n' ;     // return newlines to parser (is end-statement signal)
WS  :   [ \t]+ -> skip ; // toss out whitespace
