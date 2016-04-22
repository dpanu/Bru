grammar LabeledExpr;

prog: (stat|function)* ;

stat:   expr NEWLINE                # printExpr
    |   ID '=' expr NEWLINE          # assign
    |    NEWLINE                      # blank
	| looping 							#loops
	| condition							#ifcond
    ;

expr:   expr'++'                    	         #postfix
	|   expr op=('*'|'/'|'%') exp		 # MulDivMod
	|   expr op=('+'|'-') expr  		 # AddSub
	|   expr op=('<'|'>'|'<='|'>=') exp	 #relational
	|	expr op=('=='|'!=')  exp	 #equality
	|	expr '&&' expr	            	 #logicalAND
	|	expr '||' expr   	 	 #logicalOR
    	|   INT                         	 # int
	|   BOOL				 #bool
	|   STRING				 #string
        |   ID                                   # id
        |   '(' expr ')'                         # parens
    ;


	
function: 'print''('expr')'     							#printline
        | 'print''("'ID'")'									#printString
        | 'method' ID '(' ID? (',' ID)* ')' '{' stat+ '}' 	#funcdecl
;

looping: 'while' '('expr')' '{' stat+ '}'			#loopcond
		;

		
condition:	 ifStmt (elifStmt)* elseStmt?
		 ;

ifStmt: 'if' '(' expr ')' '{' stat+ '}'             #if
        ;

elifStmt : 'else if' '(' expr ')' '{' stat+ '}'     #elseif
            ;

elseStmt : 'else' '{' stat+ '}'                     #else
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
