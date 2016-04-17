grammar LabeledExpr;

prog:   stat+ ;

stat:   'print' expr NEWLINE        # printExpr
	|   'return' expr NEWLINE		# returnExpr
	|	'print' value NEWLINE       # printValue
	|   'return' value NEWLINE      # returnValue
    |   ID '=' expr NEWLINE         # assign
    |   ID '=' value NEWLINE        # assignvalue
    |   NEWLINE                     # blank
    |   condition NEWLINE           # ifcondition
	|	looping NEWLINE				# loops
	|   function NEWLINE			# funcdecl
    ;

expr:   INT                         # int
    |   ID                          # id
    |   '(' expr ')'                # parens
	|	expr op=('*'|'/') expr      # MulDiv
    |   expr op=('+'|'-') expr      # AddSub
    ;
    
function: 'method' ID '(' ID (' ,' ID)* ')' '{' stat+ '}' #funcdef
		;

conditionalexpr:	expr op=('<'|'>'|'<='|'>=') expr    		# comparison
				|	expr op=('=='|'!=') expr					# equality
				|	expr op=('&&' | '||') expr					# conditionalANDOR
				;
    
value:  ID                           # idval
	 |  INT							 # intval
	 |	STRING                       # string
	 |	BOOL						 # bool
	 ;

	  	 
	 
looping: 'while' '('conditionalexpr')' '{' stat+ '}'	# loopcond
		;

	 
condition:	 ifStmt (elifStmt)* elseStmt?	# ifelse
		 ;

ifStmt: 'if' '(' conditionalexpr ')' '{' stat+ '}' # if
        ; 

elifStmt : 'else if' '(' conditionalexpr ')' '{' stat+ '}' # elseif
		 ; 

elseStmt : 'else' '{' stat+ '}'  # else
		 ;

MUL :   '*' ; // assigns token name to '*' used above in grammar
DIV :   '/' ;
ADD :   '+' ;
SUB :   '-' ;
NOT :	'!' ;
ID  :   [a-zA-Z][a-zA-Z0-9]* ;      // match identifiers
INT :   [0-9]+ ;         // match integers
STRING: '"'.*?'"';
BOOL : ['True'| 'False'];
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
