grammar LabeledExpr;

prog: stat* ;

stat:   expr NEWLINE                # printExpr
    |   ID '=' expr NEWLINE          # assign
    |    NEWLINE                      # blank
    ;

expr:   expr'++'                    #postfix
	|   expr op=('*'|'/'|'%') expr  # MulDivMod
    |   expr op=('+'|'-') expr      # AddSub
	|   expr op=('<'|'>'|'<='|'>=') expr #relational
	|	expr op=('=='|'!=')  expr   #equality
	|	expr '&&' expr	        	#logicalAND
	|	expr '||' expr   			#logicalOR
    |   INT                         # int
	|   BOOL						#bool
    |   ID                          # id
    |   '(' expr ')'                # parens
    ;

MUL :   '*' ; // assigns token name to '*' used above in grammar
DIV :   '/' ;
MOD :   '%' ;
ADD :   '+' ;
SUB :   '-' ;
LESS:	'<'	;
GRT:	'>'	;
LE:		'<=';
ME:		'>=';
EQ:		'==';
NEQ:	'!=';
LAND:	'&&';
LOR:	'||';
BOOL:   'true' | 'false' ;  //match bool
INT :   [0-9]+ ;         // match integers
ID  :   [a-zA-Z][a-zA-Z0-9]* ;      // match identifiers
NEWLINE:'\r'? '\n' ;     // return newlines to parser (is end-statement signal)
WS  :   [ \t]+ -> skip ; // toss out whitespace
