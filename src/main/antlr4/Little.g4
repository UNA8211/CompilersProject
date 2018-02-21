grammar Little;

// First line of this file must be the grammar name.
// So, please keep the first line as it is provided.
// Please write your grammar below this line.

/*************************************
*             CFG(PARSER)            *
*************************************/

/* Program */
program : PROGRAM id BEGIN pgm_body END;
id : IDENTIFIER;
pgm_body : decl func_declarations;
decl: string_decl decl | var_decl decl |;

/* Global String Declaration */
string_decl: STRING id ASSIGNMENT str SEMICOLON;
str: STRINGLITERAL;

/* Variable Declaration */
var_decl: var_type id_list SEMICOLON;
var_type: FLOAT | INT;
any_type: var_type | VOID;
id_list: id id_tail;
id_tail: COMMA id id_tail |;

/* Function Paramater List */
param_decl_list: param_decl param_decl_tail |;
param_decl: var_type id;
param_decl_tail: COMMA param_decl param_decl_tail |;

/* Function Declarations */
func_declarations: func_decl func_declarations |;
func_decl: FUNCTION any_type id OPENPAREN param_decl_list CLOSEPAREN BEGIN func_body END;
func_body: decl stmt_list;

/* Statement List */
stmt_list: stmt stmt_list |;
stmt: base_stmt | if_stmt | while_stmt;
base_stmt: assign_stmt |read_stmt | write_stmt | return_stmt;

/* Basic Statements */
assign_stmt: assign_expr SEMICOLON;
assign_expr: id ASSIGNMENT expr;
read_stmt: READ OPENPAREN id_list CLOSEPAREN SEMICOLON;
write_stmt: WRITE OPENPAREN id_list CLOSEPAREN SEMICOLON;
return_stmt: RETURN expr SEMICOLON;

/* Expressions */
expr: expr_prefix factor;
expr_prefix: expr_prefix factor addop |;
factor: factor_prefix postfix_expr;
factor_prefix: factor_prefix postfix_expr mulop |;
postfix_expr: primary | call_expr;
call_expr: id OPENPAREN expr_list CLOSEPAREN;
expr_list: expr expr_list_tail |;
expr_list_tail: COMMA expr expr_list_tail |;
primary: OPENPAREN expr CLOSEPAREN | id | INTLITERAL | FLOATLITERAL;
addop: PLUS | MINUS;
mulop: MULTIPLY | DIVIDE;

/* Complex Statements and Condition */
if_stmt: IF OPENPAREN cond CLOSEPAREN decl stmt_list else_part ENDIF;
else_part:ELSE decl stmt_list |;
cond: expr compop expr;
compop: OTHEROP;

/* While Statements */
while_stmt: WHILE OPENPAREN cond CLOSEPAREN decl stmt_list ENDWHILE;

/*************************************
*            TOKENS(LEXER)           *
*************************************/

PROGRAM: 'PROGRAM';

STRING: 'STRING';

BEGIN: 'BEGIN';

END: 'END';

FUNCTION: 'FUNCTION';

READ: 'READ';

FLOAT: 'FLOAT';

INT: 'INT';

VOID: 'VOID';

WRITE: 'WRITE';

RETURN: 'RETURN';

IF: 'IF';

ENDIF: 'ENDIF';

ELSE: 'ELSE';

WHILE: 'WHILE';

ENDWHILE: 'ENDWHILE';

WHITESPACE : ' ' -> skip;

NEWLINE : '\n' -> skip;

RETURNCHAR : '\r' -> skip;

TAB : '\t' -> skip;

IDENTIFIER : [A-z][A-z0-9]*;

INTLITERAL : [0-9]+;

FLOATLITERAL : [0-9]*'.'[0-9]+;

STRINGLITERAL : '"'.*?'"';

COMMENT : '--'.*?'\n' -> skip;

OTHEROP : '='|'!='|'<'|'>'|'<='|'>=';

ASSIGNMENT : ':=';

SEMICOLON: ';';

COMMA: ',';

OPENPAREN: '(';

CLOSEPAREN: ')';

PLUS: '+';

MINUS: '-';

MULTIPLY: '*';

DIVIDE: '/';