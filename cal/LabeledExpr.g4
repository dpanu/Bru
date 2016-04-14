grammar LabeledExpr;

prog:   stat+ ;

stat:   expr NEWLINE                # printExpr
    |   ID '=' expr NEWLINE         # assign
    |   NEWLINE                     # blank
    |   condition NEWLINE           # ifcondition
    ;

expr:   INT                         # int
    |   ID                          # id
    |   '(' expr ')'                # parens
    |	op=('!') expr				# not
	|	expr op=('*'|'/') expr      # MulDiv
    |   expr op=('+'|'-') expr      # AddSub
    |	expr op=('<'|'>'|'<='|'>=') expr #comparison
    |	expr op=('==' | '!=') expr			#equality
    |	expr op=('&&') expr			#conditionalAND
    |	expr op=('||') expr			#conditionalOR 
    ;
    
value:  ID                           # id
	 |  INT							 # int
	 |	STRING
	 |	BOOL
	 ;

condition:'if (' expr '){' stat '}'
		| 'if (' expr '){'stat'}'
	      'else{'stat'}'
		;


MUL :   '*' ; // assigns token name to '*' used above in grammar
DIV :   '/' ;
ADD :   '+' ;
SUB :   '-' ;
NOT :	'!' ;
ID  :   [a-zA-Z][a-zA-Z0-9]* ;      // match identifiers
INT :   [0-9]+ ;         // match integers
STRING: [.]* ;
BOOL :  '[ TRUE |  FALSE ]';
NEWLINE:'\r'? '\n' ;     // return newlines to parser (is end-statement signal)
WS  :   [\r\n\t]+ -> skip ; // toss out whitespace
LES:   '<' ;
GRT:  '>' ;
LESE:  '<=';
GRTE:  '>=';
EE:  '==';
NE:  '!=';
AND: '&&';
OR: '||';
