grammar  DiscretePL;


prog: decl+ data*  stat+ ;                    //programs

decl:  'bool'  ID  (',' ID)* ';'  NL+         #BoolVar 
           |   'int'  ID  (',' ID)* ';'  NL+          #IntVar  
           ; 

data:    'int'  ID '='  INT  ';'  NL+                                #IntData
           | 'bool'  ID '='  C  ';'  NL+                                #BoolData
           |  'bool' '['  ']' ID '=' 'read'  '('  FILENAME ')' ';'  NL+   #BoolRead
           |  'int' '['  ']' ID '=' 'read'  '(' FILENAME ')' ';'     NL+   #IntRead
           |  'double' '['  ']' ID '=' 'read'  '('  FILENAME ')' ';'  NL+ #DoubleRead
           |  'bool' '['  ']' ID '=' '{'  C   ( ',' C)+    '}' ';'   NL+    #BoolArray
           |  'int' '['  ']' ID '=' '{'  INT    ( ',' INT)+  '}' ';'   NL+          #IntArray
           |  'double' '['  ']' ID '=' '{'  DOUBLE (',' DOUBLE)+ '}' ';'  NL+   #DoubleArray
           ;

stat:     'if'  '(' expr ')'  '{' NL stat+ NL* '}' NL+ ebranch '{' NL stat+ NL* '}' NL+      #Conditional  
        |    'while'  '(' expr ')'  '{' NL stat+ NL* '}' NL+       #Loop
        |     'for' '(' ID 'in' r ')' '{' NL stat+ NL* '}' NL+    #  Forfold
        |    ID  '='  'Bernoulli'  '(' r ')'                  #BernoulliAssg
        |    ID  '='  'Discrete'  '(' r ')'                  #DiscreteAssg
        |    ID  '='   expr                                      #DeterAssg
        |    'observe'  '('  expr  ')'                        #Observe
        |    'Infer'    '('  ID  ')'                     #InferExpectation
        |    stat   ';'  stat?                            #Sequential      
        |    NL+                                                   #Skip 
        ;

r       :          ID                                # VarOrData
                   | INT                            # IntNumber
                   |  DOUBLE                   # DoubleNumber
               ;

ebranch :   EBRANCH      ;

expr:   '('expr')'
          | UOP expr                 //unary operation
          | r EQ r                      //equal to
          | r GT r                      //greater than
          | r  LT r                     //lower than
          | expr BOP expr        //binary operations
          | ID
          | C                          //bool constant
          | INT                      //int constant
          ;

BOP         :  '&&'               //binary operators  
                | '||'
                ;

UOP        :  '!'  ;               //unary operators

C              :    'true'                   //match bool value 0 or 1 
                 | 'false'
                 ;

EQ:  '=='  ;                     // equal operators

GT:   '>' ;                      //greater operators
LT:    '<';                      //lower than

           
EBRANCH:  'else';

INT          :        DIGIT+       ;             //int 

DOUBLE  :          DIGIT+ '.' DIGIT+;      //double

FILENAME:    ( '/' STRING )+ '/'  STRING  '.' 'txt';

ID           :      STRING   //match identifier
                     |  STRING '[' STRING ']'  
                     |  STRING '[' INT   ']' 
                     ;   


STRING :       LETTER (LETTER|DIGIT)*;

LETTER     :   [a-zA-Z];

DIGIT        :  [0-9];

NL            : '\r'?  '\n' ;

LINE_COMMENT : '//' .*? '\r'? '\n'-> skip ; // Match "//" stuff '\n'

WS           :   [ \t]+ -> skip ; // toss out whitespace
