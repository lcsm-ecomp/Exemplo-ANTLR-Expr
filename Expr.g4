grammar Expr;

//Sintaxe

start : expr EOF ; 

expr : expr OP2 expr  #Mult
     | expr OP1 expr  #Soma
     | NUM            #Const
	 | APAR expr FPAR #Group
	 ;


//Lexica

NUM : [0-9]+ ;
OP1 : '+' | '-' ;
OP2 : '*' | '/' ;
APAR : '(' ;
FPAR : ')' ;

SPACES : (' ' | '\n' | '\t' | '\r') -> skip;

