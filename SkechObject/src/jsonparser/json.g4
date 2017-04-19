grammar json;

json
	:	'{' 
			'"code"' COLON code COMMA 
			'"stdin"' COLON stdin COMMA 
			'"trace"' COLON traces COMMA
			'"userlog"' COLON userlog 	'}'
	;
	
userlog
	:	STRING
	;
	

code
	:	STRING
	;

stdin	:	STRING
	;	

traces
	:	 '[' (trace COMMA)* trace ']'
	;

trace	
	:	'{' stdout event line stack_to_render globals ordered_globals func_name heap '}'
	;


stdout		
	:	'"stdout"' COLON STRING COMMA
	;

event	
	:	'"event"' COLON STRING COMMA
	;

line	
	:	'"line"' COLON NUMBER COMMA
	;

globals
	:	'"globals"' COLON '{' varlist '}' COMMA
	;

ordered_globals
	:	'"ordered_globals"' COLON '[' varnames ']' COMMA
	;

func_name
	:	'"func_name"' COLON STRING COMMA
	;

heap
	:	'"heap"' COLON '{' heap_content '}' 
	;

varlist
	:	(var COMMA)* var?
	;

var
	:	STRING COLON value
	;

value
	:	NUMBER
	|	'[' '"REF"' COMMA NUMBER ']'
	|	'[' '"VOID"' ']'
	;

varnames
	:	(STRING  COMMA)* (STRING)?
	;

heap_content
	:	(heap_object COMMA)* (heap_object)?
	;

heap_object
	:	STRING COLON '[' '"LIST"' COMMA list ']'
	;

list
	:	(NUMBER COMMA)* NUMBER
	;

stack_to_render
	:	'"stack_to_render"' COLON '['  stack ']' COMMA
	;

stack
	:	 ('{' frame '}' COMMA )* '{' frame '}'
	;

frame	
	:	 func_name encoded_locals ordered_varnames parent_frame_id_list is_highlighted is_zombie is_parent unique_hash frame_id 
	;

encoded_locals
	:	'"encoded_locals"' COLON '{' varlist '}' COMMA
	;

ordered_varnames
	:	'"ordered_varnames"' COLON '[' varnames ']' COMMA
	;

parent_frame_id_list
	:	'"parent_frame_id_list"' COLON '[' ']' COMMA
	;

is_highlighted
	:	'"is_highlighted"' COLON BOOLEAN COMMA
	;

is_zombie
	:	'"is_zombie"'	COLON BOOLEAN COMMA
	;

is_parent
	:	'"is_parent"' COLON BOOLEAN COMMA
	;

unique_hash
	:	'"unique_hash"' COLON STRING COMMA
	;

frame_id
	:	'"frame_id"' COLON NUMBER
	;

// LEXER

COLON	:	':';
COMMA	:	',';

BOOLEAN
	:	'true'	|	'false'
	;

STRING
	:	'"' (ESC | ~ ["\\])* '"'
	;

ESC
	: '\\' ('\"'|'\\'|'/'|'b'|'f'|'n'|'r'|'t')
	;

fragment
HEX_DIGIT
	: ('0'..'9'|'a'..'f'|'A'..'F')
	;

NUMBER
	: '-'? INT '.' [0-9] + EXP? | '-'? INT EXP | '-'? INT
	;

fragment INT
   	: '0' | [1-9] [0-9]*
   	;
// no leading zeros
fragment EXP
   	: [Ee] [+\-]? INT
   	;
// \- since - means "range" inside [...]
WS
   	: [ \t\n\r] + -> skip
   	;







