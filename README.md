# TP MDI

## TP2 : Étude du patron de conception Visiteur

Pour `Block(Assignment(Variable_Ref("x"),Integer_Value(10)),Print(Variable_Ref("x")))` voici notre dessin de l'arbre 
![Dessin de l'arbre](https://github.com/Antonin-Gaboriau/ESIR_TP_MDI/blob/master/tp2/Arbre%20q2.png)

Voici les règles manquantes Bin_Expression, Integer_Value et Variable_Ref que nous avons fait à partir du diagramme de classe
```Bin_Expression ::= left: Expression; right : Expression; op: Operator
Integer_Value ::=  value: Integer
Variable_Ref ::= name: String
```

Et voici notre grammaire concrète 
```Block : "{" Statement* "}" 
Statement : Assignment | Conditional | Print | Read | While | Block
Expression : Bin_Expression | Integer_Value | Variable_Ref
Assignment : Variable_Ref "=" Expression ";"
Conditional : "if" "(" Expression ")" "then" Block "else" Block
Print : "print" "(" Expression ")" ";"
Read : "read" "(" Variable_ref ")" ";"
While : "while "(" Expression ")" Block
Bin_Expression : Expression Operator Expression
Integer_Value : Integer
Variable_Ref : String
```
