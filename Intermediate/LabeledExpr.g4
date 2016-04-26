grammar LabeledExpr;

prog: (stat|function)+ ;

stat:   expr  NEWLINE*             # printExpr
        | ID '=' expr  NEWLINE*    # assign
	| looping 	           #loops
	| condition		   #ifcond
	| NEWLINE                  #blank
	| 'stack' ID NEWLINE                #stackdec
	;

expr:   expr'++'                                   #postfix
	|   expr op=('*'|'/'|'%') expr             #MulDivMod
    |   expr op=('+'|'-') expr                 #AddSub
	|   expr op=('<'|'>'|'<='|'>=') expr       #relational
	|   expr op=('=='|'!=')  expr              #equality
	|   expr op=('&&' | '||') expr	        	   #logicalANDOR
	|   INT                                    #int
	|   BOOL				   #bool
	|   STRING				   #string
    |   ID                                     #id
    |   '(' expr ')'                           #parens
    |   ID '(' args=arguments ')'              #funccall
    |   ID '.' 'pushstk' '(' INT ')'    #stkpush
    |   ID '.' 'popstk' '()'            #stkpop
    |   ID '.' 'peekstk' '()'           #stkpeek
    |   ID '.' 'emptystk' '()'          #stkempty
            ;


arguments: exprsn+=expr (',' exprsn+=expr)*
        ;
	
function: 'print''('expr')'     	 					#printline
        | 'print''("'ID'")'		      				        #printString
        | 'method' ID '(' args=exprsList ')' NEWLINE* '{' stmt=prog ret=returnStmt '}' 	#funcdecl
        ;


returnStmt: ('return' ID)?
        ;

exprsList: exprsn+=expr (',' exprsn+=expr)*
        ;

looping: 'while' '('exps=expr')' NEWLINE* '{' whlstmt=prog '}'			#loopcond
	;

condition:  ifStmt elseStmt?
	;

ifStmt: 'if' '(' exp=expr ')' NEWLINE* '{' ifstmt=prog '}' NEWLINE*       #if
        ;

elseStmt : 'else' NEWLINE* '{' elstmt=prog '}'            #else
        ;

MUL :   '*' ;
DIV :   '/' ;
MOD :   '%' ;
ADD :   '+' ;
SUB :   '-' ;
LESS:	'<';
GRT:	'>';
LE:	'<=';
ME:	'>=';
EQ:	'==';
NEQ:	'!=';
LAND:	'&&';
LOR:	'||';
BOOL:   'true' | 'false' ;               //match bool
INT :   [0-9]+ ;                         // match integers
ID  :   [a-zA-Z][a-zA-Z0-9]* ;           // match identifiers
STRING: '"'.*?'"' ;
NEWLINE:'\r'? '\n' ;                     // return newlines to parser (is end-statement signal)
WS  :   [ \r\n\t]+ -> skip ;             // toss out whitespace
SL_COMMENT
: '//' .*? '\n' -> skip
;

ML_COMMENT
: '/*' .*? '*/' -> skip
;
