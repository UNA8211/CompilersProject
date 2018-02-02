lexer grammar Little;

// First line of this file must be the grammar name.
// So, please keep the first line as it is provided.
// Please write your grammar below this line.

KEYWORD :'PROGRAM'|'STRING'|'PROGRAM'|'BEGIN'|'END'|'FUNCTION'|'READ'|'WRITE'|'IF'|'ELSE'|'FI'|'FOR'|'ROF'|'RETURN'|'INT'|'VOID'|'STRING'|'FLOAT'|'WHILE'|'ENDIF'|'ENDWHILE';

WHITESPACE : ' ' -> skip;

NEWLINE : '\n' -> skip;

RETURN : '\r' -> skip;

TAB : '\t' -> skip;

IDENTIFIER : [A-z][A-z0-9]*;

INTLITERAL : [0-9]+;

FLOATLITERAL : [0-9]*'.'[0-9]+;

STRINGLITERAL : '"'.*?'"';

COMMENT : '--'.*?'\n' -> skip;

OPERATOR : ':='|'+'|'-'|'*'|'/'|'='|'!='|'<'|'>'|'('|')'|';'|','|'<='|'>=';