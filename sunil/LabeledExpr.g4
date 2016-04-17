grammar LabeledExpr;

prog: (stat|function)* ;

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
	|   STRING						#string
    |   ID                          # id
    |   '(' expr ')'                # parens
    ;

	
function: 'print''('expr')'			#printline
| 'print''("'ID'")'			#printString
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
STRING: '"'.*?'"' ;
NEWLINE:'\r'? '\n' ;     // return newlines to parser (is end-statement signal)
WS  :   [ \t]+ -> skip ; // toss out whitespace
