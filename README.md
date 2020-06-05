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

## TP3 : Pattern Decorator et State
### Question 1
Voici les erreurs que nous avons relevé dans le diagramme de classes :
- Il est impossible de spécifier le type de pizza (petite ou grande) avec cette structure
- Il manque le coordinateur (de type collaborateur) d’un point pizza
- Il manque une méthode pour l'affectation d'un collaborateur sur une tâche dans System
- Il n’y a pas assez de moyens de transports différents
- Le prix des pizzas devrait être un float et non un int
- Il manque des cardinalités sur certaines relations entre classes
- Enfin, l’ensemble est brouillon et peu compréhensible avec beaucoup de classes et relations, ce qui peut rendre la maintenabilité difficile.
### Question 2
L'avantage du pattern decorator est sa capacité à pouvoir ajouter dynamiquement des fonctionnalité à un objet sans passer par plusieurs héritages successifs ou reprendre toute la conception
Dans notre cas, il sera alors bien plus simple de définir une pizza en retard pendant un happy hour avec un décorateur que par héritages successifs.
![Dessin du pattern decorateur](https://github.com/Antonin-Gaboriau/ESIR_TP_MDI/blob/master/Images/decorateur.jpg)
### Question 3
Le pattern state est très adapté à notre cas, il permettra en effet de ne permettre certaines actions que si on se situe dans un certain état via le comportement suivant :
La possibilité de passer d’un état à l’autre sera à définir dans la méthode compute associée à chaque état, ce qui rend le passage d’un état à l’autre uniquement dépendant de l’état dans lequel la commande se situe.
![Dessin du state pattern](https://github.com/Antonin-Gaboriau/ESIR_TP_MDI/blob/master/Images/etats.png)
